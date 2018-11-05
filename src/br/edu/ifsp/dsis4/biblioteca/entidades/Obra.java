package br.edu.ifsp.dsis4.biblioteca.entidades;

import java.time.LocalDate;
import java.util.List;

public class Obra {

    private String isbn;

    private String titulo;

    private CategoriaLiteraria categoria;

    private List<Autor> autores;

    private List<PalavraChave> palavrasChave;

    private LocalDate dataPublicacao;

    private int numEdicao;

    private String editora;

    public String getIsbn () {
        return isbn;
    }

    public void setIsbn (final String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo () {
        return titulo;
    }

    public void setTitulo (final String titulo) {
        this.titulo = titulo;
    }

    public CategoriaLiteraria getCategoria () {
        return categoria;
    }

    public void setCategoria (final CategoriaLiteraria categoria) {
        this.categoria = categoria;
    }

    public List<Autor> getAutores () {
        return autores;
    }

    public void setAutores (final List<Autor> autores) {
        this.autores = autores;
    }

    public List<PalavraChave> getPalavrasChave () {
        return palavrasChave;
    }

    public void setPalavrasChave (final List<PalavraChave> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public LocalDate getDataPublicacao () {
        return dataPublicacao;
    }

    public void setDataPublicacao (final LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getNumEdicao () {
        return numEdicao;
    }

    public void setNumEdicao (final int numEdicao) {
        this.numEdicao = numEdicao;
    }

    public String getEditora () {
        return editora;
    }

    public void setEditora (final String editora) {
        this.editora = editora;
    }
}
