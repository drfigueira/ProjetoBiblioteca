package br.edu.ifsp.dsis4.biblioteca.io.xml.leitores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ClasseXML;
import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.InstanciaXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author s2it_lrossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/14/18 4:10 PM
 */
public class DomImpl implements XMLReader {

    private Document arquivo;

    private List<ClasseXML> classes;

    private List<InstanciaXML> resultado;


    public DomImpl(String arquivo) {
        carregar(arquivo);
        classes = new ArrayList<>();
        resultado = new ArrayList<>();
    }

    @Override
    public void registrarClasse (final ClasseXML classeXML) {
        this.classes.add(classeXML);
    }

    @Override
    public List<InstanciaXML> getResultado () {
        return resultado;
    }

    public void ler() {
        NodeList nodeList = arquivo.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            ClasseXML classeAtual;
            if ((classeAtual = classePorNode(node)) != null) {
                resultado.add(mapearRecursivo(node, classeAtual));
            }
        }
    }

    private ClasseXML classePorNode (final Node node) {
        List<ClasseXML> classesFiltradas = classes.stream()
                .filter(cl -> node.getLocalName().equals(cl.getTag()))
                .collect(Collectors.toList());
        return classesFiltradas.isEmpty() ? null : classesFiltradas.get(0);
    }

    private InstanciaXML mapearRecursivo (final Node node, final ClasseXML classeAtual) {
        InstanciaXML instanciaXML = new InstanciaXML(classeAtual);
        classeAtual.getAttributos().forEach(attr -> {
            Element attrNode = (Element) ((Element) node).getElementsByTagName(attr);
        });
        return null;
    }

    private void carregar (final String arquivo) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.arquivo = builder.parse(arquivo);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
