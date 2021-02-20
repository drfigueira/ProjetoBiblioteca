package br.edu.ifsp.dsis4.biblioteca.entidades;

import java.time.LocalDate;

public class Usuario {

    private int id;

    private String nome;

    private String endereco;

    private String estado;

    private String telefone;

    private LocalDate dataNascimento;

    public Usuario() {

    }

    public Usuario(int id, String nome, String endereco, String estado, String telefone, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.estado = estado;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}