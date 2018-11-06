package br.edu.ifsp.dsis4.biblioteca.io.xml.mapper;

import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.InstanciaXML;

/**
 * @author leorossi
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/6/18 6:38 PM
 */
public interface ConversorDeObjetoXML<T> {

    T converter(InstanciaXML instanciaXML);

}
