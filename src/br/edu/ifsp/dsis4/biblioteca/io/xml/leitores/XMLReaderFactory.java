package br.edu.ifsp.dsis4.biblioteca.io.xml.leitores;

import java.util.List;

import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ClasseXML;
import br.edu.ifsp.dsis4.biblioteca.io.xml.util.JobMapeadorJaxb;

public class XMLReaderFactory {

    private static XMLReaderFactory INSTANCE;

    private List<ClasseXML> classesMapeadas;

    private XMLReaderFactory () {
        JobMapeadorJaxb job = new JobMapeadorJaxb();
        this.classesMapeadas = job.mapear();
    }

    public static XMLReaderFactory newXMLReaderFactory () {
        if (INSTANCE == null) {
            INSTANCE = new XMLReaderFactory();
        }
        return INSTANCE;
    }

    public XMLReader newXMLReader (ApiXML tipo) {
        XMLReader reader = procurarImpl(tipo.getClasse());
        if (tipo == ApiXML.SAX || tipo == ApiXML.DOM) {
            classesMapeadas.forEach(reader::registrarClasse);
        }
        return reader;
    }

    private XMLReader procurarImpl (String nomeClasse) {
        try {
            String nomePacote = this.getClass().getPackage().getName();
            Class classe = Class.forName(nomePacote + "." + nomeClasse);
            return (XMLReader) classe.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
