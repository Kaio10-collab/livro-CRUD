package br.com.zup.livros.dto;

import br.com.zup.livros.model.Livro;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class LivroDTO {

    private Integer id;

    @NotBlank
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    private double preco;

    public LivroDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public static Iterable<LivroDTO> converterIterableDeModelParaDTO(Iterable<Livro> livros){
        List<LivroDTO> livroDTOS = new ArrayList<>();

        for(Livro livro: livros){
            livroDTOS.add(conveterModelParaDTO(livro));
        }

        return livroDTOS;
    }

    public static LivroDTO conveterModelParaDTO(Livro livro) {
        LivroDTO livroDTO = new LivroDTO();

        livroDTO.setId(livro.getId());
        livroDTO.setTitulo(livro.getTitulo());
        livroDTO.setDescricao(livro.getDescricao());
        livroDTO.setPreco(livro.getPreco());

        return livroDTO;
    }
}
