package br.edu.ifsp.dsis4.biblioteca.entidades;

public class Funcionario {

    private int id;

    private Leitor servidor;

    public Funcionario() {
    }

    public Funcionario(int id, Leitor servidor) {
        this.id = id;
        this.servidor = servidor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Leitor getServidor() {
        return servidor;
    }

    public void setServidor(Leitor servidor) {
        this.servidor = servidor;
    }
}
