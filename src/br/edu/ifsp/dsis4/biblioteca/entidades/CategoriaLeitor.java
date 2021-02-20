package br.edu.ifsp.dsis4.biblioteca.entidades;

public class CategoriaLeitor {

    private int id;

    private String descricao;

    private int tempoEmprestimo;

    public CategoriaLeitor() {
    }

    public CategoriaLeitor(int id, String descricao, int tempoEmprestimo) {
        this.id = id;
        this.descricao = descricao;
        this.tempoEmprestimo = tempoEmprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTempoEmprestimo() {
        return tempoEmprestimo;
    }

    public void setTempoEmprestimo(int tempoEmprestimo) {
        this.tempoEmprestimo = tempoEmprestimo;
    }
}
