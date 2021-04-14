package br.com.zup.livros.service;

import br.com.zup.livros.dto.FiltroLivroDTO;
import br.com.zup.livros.model.Livro;
import br.com.zup.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private List<Livro> livros = new ArrayList<>();

    @Autowired
    private LivroRepository livroRepository;

    public Livro cadastrarLivro(Livro livro){
       Livro objLivro = livroRepository.save(livro);
        return objLivro;
    }

    public Livro atualizaLivro(Integer id){
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if (!optionalLivro.isPresent())
            throw new RuntimeException("Id não existe");

        livroRepository.save(optionalLivro.get());

        return optionalLivro.get();
    }

    public void deletarLivro(Integer id){
        livroRepository.deleteById(id);
    }

    public Livro buscarLivroPeloId(Integer id){
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if(optionalLivro == null)
            throw new RuntimeException("Livro não existe");
        else
            return optionalLivro.get();
    }

    /**              Outra forma de fazer o Optional também;
     * public Livro buscarLivroPeloId(Integer id){
     *         Optional<Livro> optionalLivro = livroRepository.findById(id);
     *
     *         if(optionalLivro.isPresent()) {
     *             return optionalLivro.get();
     *        }
     *         throw new RuntimeException("Livro não existe");
     *     }
     */

    public Iterable<Livro> pesquisarTodoOsLivros(FiltroLivroDTO livro) {
        if (livro.getId() == null) {
            return livroRepository.findAll();
        }
        return livroRepository.findAll();
    }
}