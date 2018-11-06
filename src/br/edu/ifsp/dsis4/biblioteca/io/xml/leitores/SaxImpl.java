package br.edu.ifsp.dsis4.biblioteca.io.xml.leitores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ClasseXML;
import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.InstanciaXML;
import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ObjetoXML;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author leorossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/6/18 6:16 PM
 */
public class SaxImpl extends DefaultHandler implements XMLReader {

    private List<ClasseXML> classes;

    private List<InstanciaXML> resultado;

    private ClasseXML classeAtual;

    private InstanciaXML objetoAtual;

    private String valor;

    public SaxImpl() {
        classes = new ArrayList<>();
        resultado = new ArrayList<>();
    }

    @Override
    public void registrarClasse (final ClasseXML classeXML) {
        classes.add(classeXML);
    }

    @Override
    public List<InstanciaXML> getResultado () {
        return resultado;
    }

    @Override
    public void startDocument () throws SAXException {
        resultado = new ArrayList<>();
    }

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException {
        List<String> tags = classes.stream()
                .map(ObjetoXML::getTag)
                .collect(Collectors.toList());

        if (tags.contains(qName)) {
            classeAtual = buscarPeloNomeDaTag(qName);
            objetoAtual = new InstanciaXML(classeAtual);
            resultado.add(objetoAtual);
        }
    }

    private ClasseXML buscarPeloNomeDaTag (final String tag) {
        for (ClasseXML c : classes) {
            if (c.getTag().equals(tag)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void characters (char[] ch, int start, int length) {
        valor = String.valueOf(ch, start, length);
    }

    @Override
    public void endElement (String uri, String localName, String qName) {
        if (classeAtual.getAttributos().contains(qName)) {
            objetoAtual.set(qName, valor);
        }
    }

}
