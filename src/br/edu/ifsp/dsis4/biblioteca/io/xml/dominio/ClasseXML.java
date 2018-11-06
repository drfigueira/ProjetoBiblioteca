package br.edu.ifsp.dsis4.biblioteca.io.xml.dominio;

import java.util.List;

/**
 * @author leorossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/6/18 6:03 PM
 */
public class ClasseXML extends ObjetoXML{

    private List<String> attributos;

    public ClasseXML (final String tag, final Class classe) {
        super(tag, classe);
    }

    public List<String> getAttributos () {
        return attributos;
    }

    public void adicionarAtributo(String atributo) {
        attributos.add(atributo);
    }

}
