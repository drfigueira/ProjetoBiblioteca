package br.edu.ifsp.dsis4.biblioteca.entidades;

/**
 * @author leorossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/5/18 6:40 PM
 */
public class Exemplar {

    private int id;
    
    private int idObra;

    private boolean disponivel;

    public Exemplar() {
    }

    public Exemplar(int id, int idObra, boolean disponivel) {
        this.id = id;
        this.idObra = idObra;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdObra() {
        return idObra;
    }
    
    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    @Override
    public String toString() {
        return String.format("Exemplar: %d-%d | Status: %s", 
                idObra,
                id,
                isDisponivel()? "disponível" : "emprestado");
    }
}
