package br.edu.ifsp.dsis4.biblioteca.io.xml.leitores;

import java.util.List;

import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ClasseXML;
import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.InstanciaXML;

public interface XMLReader {

    void registrarClasse(ClasseXML classeXML);

    List<InstanciaXML> getResultado();

}
