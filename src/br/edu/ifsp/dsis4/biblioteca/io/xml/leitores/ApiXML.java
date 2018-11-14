package br.edu.ifsp.dsis4.biblioteca.io.xml.leitores;

/**
 * @author s2it_lrossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/14/18 2:51 PM
 */
public enum ApiXML {
    SAX("SaxImpl"),
    DOM("DomImpl"),
    JAXB("JaxbImpl");

    private String classe;

    ApiXML (final String classe) {
        this.classe = classe;
    }

    public String getClasse () {
        return classe;
    }
}
