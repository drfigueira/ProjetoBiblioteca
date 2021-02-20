package br.edu.ifsp.dsis4.biblioteca.entidades;

import java.time.LocalDate;

public class Devolucao {

    private int id;

    private LocalDate dataDevolucao;

    private Emprestimo emprestimo;

    public Devolucao() {
    }

    public Devolucao(int id, LocalDate dataDevolucao, Emprestimo emprestimo) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
        this.emprestimo = emprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
}
