package br.edu.ifsp.dsis4.biblioteca.entidades;

import java.util.List;

public class Leitor {

    private int id;

    private String email;

    private String rg_numero;

    private String rg_estado;

    private String prontuario;

    private CategoriaLeitor categoriaLeitor;

    private Usuario usuario;

    private List<Emprestimo> emprestimos;

    public Leitor() {
    }

    public Leitor(int id, String email, String rg_numero, String rg_estado, String prontuario, CategoriaLeitor categoriaLeitor, Usuario usuario, List<Emprestimo> emprestimos) {
        this.id = id;
        this.email = email;
        this.rg_numero = rg_numero;
        this.rg_estado = rg_estado;
        this.prontuario = prontuario;
        this.categoriaLeitor = categoriaLeitor;
        this.usuario = usuario;
        this.emprestimos = emprestimos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg_numero() {
        return rg_numero;
    }

    public void setRg_numero(String rg_numero) {
        this.rg_numero = rg_numero;
    }

    public String getRg_estado() {
        return rg_estado;
    }

    public void setRg_estado(String rg_estado) {
        this.rg_estado = rg_estado;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public CategoriaLeitor getCategoriaLeitor() {
        return categoriaLeitor;
    }

    public void setCategoriaLeitor(CategoriaLeitor categoriaLeitor) {
        this.categoriaLeitor = categoriaLeitor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public boolean addEmprestimo(Emprestimo e) {
        if(emprestimos.size() < 3) {
            return emprestimos.add(e);
        }
        return false;
    }

    public boolean removeEmprestimo(Emprestimo e) {
        return emprestimos.remove(e);
    }

    public boolean bloqueado() {
        for(Emprestimo e : emprestimos) {
            if (e.emAtraso()) {
                return false;
            }
        }
        return emprestimos.size() == 3;
    }
}
