package br.com.zup.livros.service;

import br.com.zup.livros.model.Autor;
import br.com.zup.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private List<Autor> autores = new ArrayList<>();

    @Autowired
    private AutorRepository autorRepository;

    public Autor cadastrarAutor(Autor autor) {
        Autor objAutor = autorRepository.save(autor);
        return objAutor;
    }

    public Autor buscaDoAutorPeloID(Integer id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);

        if (autorOptional.isPresent()) {
            return autorOptional.get();
        }
        throw new RuntimeException("Autor não foi encontrado neste id informado");
    }

    public Iterable<Autor> pesquisaDeTodosOsAutores() {
        return autorRepository.findAll();
    }

    public Autor atualizaAutorPeloId(Integer id, Autor autor) {
        Optional<Autor> autorOptional = autorRepository.findById(id);

        if (!autorOptional.isPresent()) {
            autor.setId(id);
            autorRepository.save(autor);

        }
        return autor;
    }

    public void deletarAutorPelaId(Integer id) {
        autorRepository.deleteById(id);
    }
}
