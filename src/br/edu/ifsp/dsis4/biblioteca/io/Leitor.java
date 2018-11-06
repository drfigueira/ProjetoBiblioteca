package br.edu.ifsp.dsis4.biblioteca.io;

import java.util.List;

public interface Leitor<T> extends ComponenteIO{

    List<T> ler();

}
