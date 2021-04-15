package br.com.zup.livros.controller;

import br.com.zup.livros.dto.FiltroLivroDTO;
import br.com.zup.livros.dto.LivroDTO;
import br.com.zup.livros.model.Livro;
import br.com.zup.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("livros/")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastroLivro(@RequestBody Livro livro){
        return livroService.cadastrarLivro(livro);
    }

    @PutMapping("{id}/")
    public Livro atualizarLivroNaLoja(@PathVariable Integer id, @RequestBody Livro livro){
        Livro livros = livroService.atualizaLivro(id,livro);
        return livros;
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarLivro(@PathVariable Integer id){
        livroService.deletarLivro(id);
    }

    @GetMapping("{id}/")
    public Livro pesquisarLivroPeloId(@PathVariable Integer id) {
        return livroService.buscarLivroPeloId(id);
    }

    @GetMapping
    public Iterable<LivroDTO> retornarTodosOsLivros (@ModelAttribute FiltroLivroDTO filtro ){
        Iterable<Livro> albuns = livroService.pesquisarTodoOsLivros(filtro);
        return LivroDTO.converterIterableDeModelParaDTO(albuns);
    }
}