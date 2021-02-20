package br.edu.ifsp.dsis4.biblioteca.entidades;

import java.time.LocalDate;
import java.util.List;

public class Obra {

    private int id;

    private String isbn;

    private String titulo;

    private CategoriaLiteraria categoria;

    private List<Autor> autores;

    private List<PalavraChave> palavrasChave;

    private LocalDate dataPublicacao;

    private int numEdicao;

    private String editora;

    private List<Exemplar> exemplares;

    public Obra() {
    }

    public Obra(int id, String isbn, String titulo, CategoriaLiteraria categoria, List<Autor> autores, List<PalavraChave> palavrasChave, LocalDate dataPublicacao, int numEdicao, String editora, List<Exemplar> exemplares) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
        this.autores = autores;
        this.palavrasChave = palavrasChave;
        this.dataPublicacao = dataPublicacao;
        this.numEdicao = numEdicao;
        this.editora = editora;
        this.exemplares = exemplares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public CategoriaLiteraria getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLiteraria categoria) {
        this.categoria = categoria;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<PalavraChave> getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(List<PalavraChave> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getNumEdicao() {
        return numEdicao;
    }

    public void setNumEdicao(int numEdicao) {
        this.numEdicao = numEdicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ");
        builder.append(id);
        builder.append("\nISBN: ");
        builder.append(isbn);
        builder.append("\nTítulo: ");
        builder.append(titulo);
        builder.append("\nCategoria: ");
        builder.append(categoria.getDescricao());
        builder.append("\nAutores: ");
        autores.forEach(a -> {
            builder.append("\n");
            builder.append(a.getNome());
        });
        builder.append("\nPalavras-Chave: ");
        palavrasChave.forEach(p -> {
            builder.append("\n");
            builder.append(p.getPalavra());
        });
        builder.append("\nData de publicação: ");
        builder.append(dataPublicacao.toString());
        builder.append("\nEdição: ");
        builder.append(numEdicao);
        builder.append("\nEditora: ");
        builder.append(editora);
        builder.append("\nExemplares: ");
        exemplares.forEach(e -> {
            builder.append("\n");
            builder.append(e);
        });
        return builder.toString();
    }
    
}
