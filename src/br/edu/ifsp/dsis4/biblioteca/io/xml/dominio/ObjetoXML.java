package br.edu.ifsp.dsis4.biblioteca.io.xml.dominio;

public class ObjetoXML {

    protected String tag;

    protected String nomeClasse;

    public ObjetoXML() {

    }

    public ObjetoXML (final String tag, final Class classe) {
        this.tag = tag;
        this.nomeClasse = classe.getSimpleName();
    }

    public String getTag () {
        return tag;
    }

    public void setTag (final String tag) {
        this.tag = tag;
    }

    public String getNomeClasse () {
        return nomeClasse;
    }

    public void setNomeClasse (final String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }
}
