package br.com.zup.livros.repository;

import br.com.zup.livros.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Integer> {

    Iterable<Livro> findByAll(int id);
}