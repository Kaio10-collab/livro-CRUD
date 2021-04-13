package br.com.zup.livros.model;
/**
import javax.persistence.*;
import java.util.List;


  @Entity
  @Table(name = "livros/")


public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descricao;
    private double preco;
    private List<Livro> livros;

    public Livro() {
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
//por exemplo, tente fazer um CRUD de Livros, por enquanto um livro terá os seguintes atributos: título, descrição e preço
//então você vai fazer um endpoint para cadastrar, atualizar, deletar, buscar por id e um busca todos
//um endpoint pra cada uma dessas ações que eu disse aí pra cima.
 */