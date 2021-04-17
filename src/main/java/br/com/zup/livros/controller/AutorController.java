package br.com.zup.livros.controller;

import br.com.zup.livros.model.Autor;
import br.com.zup.livros.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autores/")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor cadastroAutor(@RequestBody Autor autor){
        return autorService.cadastrarAutor(autor);
    }

    @GetMapping("{id}/")
    public Autor pesquisarAutorPeloId(@PathVariable Integer id) {
            return autorService.buscaDoAutorPeloID(id);
    }

    @GetMapping
    public Iterable<Autor> pesquisarTodosOsAutores(){
        return autorService.pesquisaDeTodosOsAutores();
    }

    @PutMapping("{id}/")
    public Autor atualizarAutor(@PathVariable Integer id, @RequestBody Autor autor){
            Autor autores = autorService.atualizaAutorPeloId(id, autor);
            return autores;
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutor(@PathVariable Integer id){
        try {
            autorService.deletarAutorPelaId(id);
        }catch (RuntimeException e){
            throw new RuntimeException("Id não foi encontrado");
        }
    }
}
