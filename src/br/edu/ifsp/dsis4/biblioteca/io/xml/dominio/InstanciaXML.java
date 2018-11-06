package br.edu.ifsp.dsis4.biblioteca.io.xml.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leorossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/6/18 6:07 PM
 */
public class InstanciaXML extends ObjetoXML {

    private Map<String, String> valores;

    private InstanciaXML() {
        super();
        valores = new HashMap<>();
    }

    public InstanciaXML(ClasseXML classe) {
        this();
        this.nomeClasse = classe.getNomeClasse();
        this.tag = classe.getTag();
    }

    public void set(String atributo, String valor) {
        valores.put(atributo, valor);
    }

    public List<String> getValores() {
        return new ArrayList<>(valores.values());
    }
}
