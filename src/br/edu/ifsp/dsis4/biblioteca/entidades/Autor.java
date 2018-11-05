package br.edu.ifsp.dsis4.biblioteca.entidades;

public class Autor {

    private int id;

    private String nome;

    public Autor() {

    }

    public Autor (final int id, final String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId () {
        return id;
    }

    public void setId (final int id) {
        this.id = id;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (final String nome) {
        this.nome = nome;
    }
}
