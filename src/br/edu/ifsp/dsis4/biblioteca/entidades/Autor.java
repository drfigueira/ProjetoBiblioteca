package br.edu.ifsp.dsis4.biblioteca.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "autor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Autor {

    private int id;

    @XmlElement(name = "nome")
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
