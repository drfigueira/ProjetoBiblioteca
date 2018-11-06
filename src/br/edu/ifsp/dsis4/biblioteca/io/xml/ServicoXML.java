package br.edu.ifsp.dsis4.biblioteca.io.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import br.edu.ifsp.dsis4.biblioteca.io.Escritor;
import br.edu.ifsp.dsis4.biblioteca.io.Leitor;
import br.edu.ifsp.dsis4.biblioteca.io.xml.leitores.SaxImpl;
import br.edu.ifsp.dsis4.biblioteca.io.xml.leitores.XMLReader;
import br.edu.ifsp.dsis4.biblioteca.io.xml.mapper.XMLModelMapper;
import org.xml.sax.SAXException;

/**
 * @author leorossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/6/18 5:53 PM
 */
public class ServicoXML implements Leitor, Escritor {

    private String arquivo;

    private XMLModelMapper modelMapper;

    private XMLReader reader;

    public ServicoXML() {
        modelMapper = new XMLModelMapper();
        reader = new SaxImpl();
    }

    @Override
    public void escrever (final Object param) {
        throw new UnsupportedOperationException("Ainda não implementado");
    }

    @Override
    public void escrever (final List param) {
        throw new UnsupportedOperationException("Ainda não implementado");
    }

    @Override
    public List ler () {
        try (InputStream input = new FileInputStream(new File(arquivo))) {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

            //TODO terminar de implementar.

        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException("Erro ao parsear arquivo");
        }

        return null;
    }

    @Override
    public void setArquivo (final String endereco) {
        this.arquivo = arquivo;
    }
}
