package br.com.zup.livros.service;

import br.com.zup.livros.dto.FiltroLivroDTO;
import br.com.zup.livros.model.Livro;
import br.com.zup.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private List<Livro> livros = new ArrayList<>();

    @Autowired
    private LivroRepository livroRepository;

    public Livro cadastrarLivro(Livro livro){
       Livro objLivro = livroRepository.save(livro);
        return objLivro;
    }

    public Livro atualizaLivro(Livro livro) {
        if (livroRepository.existsById(livro.getId())) {
            Livro objLivro = cadastrarLivro(livro);
            return objLivro;
        }
        throw new RuntimeException("Livro não encontrado");
    }

    public void deletarLivro(Integer id){
        livroRepository.deleteById(id);
    }

    public Livro buscarLivroPeloId(int id){
        for(Livro livro : livros){
            if (livro.getId().equals(id)){
                return livro;
            }
        }

        throw new RuntimeException("Livro não existe");
    }

    public Iterable<Livro> pesquisarTodoOsLivros(FiltroLivroDTO livro) {
        if (livro.getId() == null) {
            return livroRepository.findAll();
        }
        return livroRepository.findByAll(livro.getId());
    }
}