package br.edu.ifsp.dsis4.biblioteca.io;

import java.util.List;

public interface Escritor<T> extends ComponenteIO {

    void escrever(T param);

    void escrever(List<T> param);

}
