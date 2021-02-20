package br.edu.ifsp.dsis4.biblioteca.entidades;

import java.time.LocalDate;

public class Emprestimo {

    private int id;

    private LocalDate dataEmprestimo;

    private LocalDate dataPrevista;

    private Exemplar exemplar;

    private Funcionario funcionario;
    
    private int idLeitor;

    public Emprestimo() {
    }

    public Emprestimo(int id, LocalDate dataEmprestimo, LocalDate dataPrevista, Exemplar exemplar, Funcionario funcionario, int idLeitor) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevista = dataPrevista;
        this.exemplar = exemplar;
        this.funcionario = funcionario;
        this.idLeitor = idLeitor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public int getIdLeitor() {
        return idLeitor;
    }
    
    public void setIdLeitor(int idLeitor) {
        this.idLeitor = idLeitor;
    }

    public boolean emAtraso() {
        return dataEmprestimo.isBefore(LocalDate.now());
    }
}

