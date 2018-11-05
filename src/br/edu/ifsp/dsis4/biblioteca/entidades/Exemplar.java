package br.edu.ifsp.dsis4.biblioteca.entidades;

/**
 * @author leorossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/5/18 6:40 PM
 */
public class Exemplar {

    private int id;

    private Obra obra;

    public Exemplar() {

    }

    public Exemplar (final int id, final Obra obra) {
        this.id = id;
        this.obra = obra;
    }

    public int getId () {
        return id;
    }

    public void setId (final int id) {
        this.id = id;
    }

    public Obra getObra () {
        return obra;
    }

    public void setObra (final Obra obra) {
        this.obra = obra;
    }
}
