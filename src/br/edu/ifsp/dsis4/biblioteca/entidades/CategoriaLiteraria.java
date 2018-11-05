package br.edu.ifsp.dsis4.biblioteca.entidades;

public class CategoriaLiteraria {

    private int id;

    private String descricao;

    public CategoriaLiteraria() {

    }

    public CategoriaLiteraria (final int id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId () {
        return id;
    }

    public void setId (final int id) {
        this.id = id;
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (final String descricao) {
        this.descricao = descricao;
    }

}
