package br.com.zup.livros.repository;

import br.com.zup.livros.model.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Integer> {
}
