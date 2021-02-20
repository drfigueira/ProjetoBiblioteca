/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.dsis4.biblioteca.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows7
 */
public class ListaObra {
    
    private List<Obra> obras;
    
    public ListaObra() {
        obras = new ArrayList<>();
    }
    
    public boolean addObra(Obra obra) {
        return obras.add(obra);
    }
    
    public List<Obra> getObras() {
        return obras;
    }
    
    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        obras.forEach(o -> {
            builder.append(o);
            builder.append("\n");
        });
        return builder.toString();
    }
}
