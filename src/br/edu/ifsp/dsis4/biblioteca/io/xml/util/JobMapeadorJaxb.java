package br.edu.ifsp.dsis4.biblioteca.io.xml.util;

import br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ClasseXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Essa classe é um job que percorre o pacote de entidades na inicialização,
 * buscando classes anotadas com {@link javax.xml.bind.annotation.XmlRootElement}
 * afim de criar as {@link br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ClasseXML} necessárias
 * para que as implementações de leitor/escritor XML nas APIs 'SAX' e 'DOM' saibam o que devem
 * ler/escrever. Em outras palavras, esse job mapeia as classes do domínio da aplicação, convertendo-as
 * em classes do domínio da nossa API de leitura/escrita XML, com base em suas anotações.
 */
public class JobMapeadorJaxb {

    private final String PACOTE_ENTIDADES = "br.edu.ifsp.dsis4.biblioteca.entidades";
    private final String PONTO_CLASS = ".class";

    /**
     * Método que realmente mapeia as classes do domínio e as converte em XML.
     * @return Uma lista de {@link br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ClasseXML} com os
     * metadados das classes do domínio que foram anotadas com {@link javax.xml.bind.annotation.XmlRootElement}.
     * É NullPointerSafe, pois caso nenhuma classe preencha os requisitos de conversão, será retornado uma
     * lista vazia;
     */
    public List<ClasseXML> mapear() {
        List<ClasseXML> classeXMLS = new ArrayList<>();
        try {
            List<Class> entidades = procurarEntidades();
            ClasseXML classeXML;
            for (Class classe : entidades) {
                if (classe.isAnnotationPresent(XmlRootElement.class)) {
                    classeXML = pegarClasseXML(classe);
                    classeXMLS.add(classeXML);
                }
            }
            return classeXMLS;
        } catch (FileNotFoundException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Esse método é responsável por iterar pelo pacote de entidades e trazer para a memória TODAS as classes
     * do domínio, independente de anotações.
     *
     * O código para iterar pelo pacote foi baseado nesse artigo:
     * <a href="https://www.atlassian.com/blog/archives/reflecting_on_the_impossible">
     *     Atalassian Blog: Reflecting on the impossible
     * </a>
     * @return Uma lista contendo todas as classes no pacote de entidades.
     * @throws FileNotFoundException Caso o pacote de entidades não seja encontrado.
     * @throws ClassNotFoundException Caso alguma das classes não seja encontrada.
     */
    private List<Class> procurarEntidades() throws FileNotFoundException, ClassNotFoundException {
        URL dirURL = ClassLoader.getSystemClassLoader().getResource(PACOTE_ENTIDADES.replace('.','/'));
        if (dirURL == null) {
            throw new FileNotFoundException("Diretório de entidades não encontrado. Por favor, não mexa na estrutura de arquivos.");
        }

        File dir = new File(dirURL.getFile());
        List<Class> classes = new ArrayList<>();
        Class classe;
        String nomeArquivo, nomeClasse;

        for (File f : dir.listFiles()) {
            nomeArquivo = f.getName();
            if (nomeArquivo.endsWith(PONTO_CLASS)) {
                nomeClasse = nomeArquivo.substring(0, nomeArquivo.length() - PONTO_CLASS.length());
                classe = Class.forName(PACOTE_ENTIDADES + "." + nomeClasse);
                classes.add(classe);
            }
        }
        return classes;
    }

    /**
     * Converte uma {@link java.lang.Class} em uma {@link br.edu.ifsp.dsis4.biblioteca.io.xml.dominio.ClasseXML}
     * de acordo com as anotações presentes.
     * @param classe Uma classe do domínio de negócios da aplicação, anotada com
     * {@link javax.xml.bind.annotation.XmlRootElement}.
     * @return Uma instância de ClasseXML correspondente.
     */
    private ClasseXML pegarClasseXML(Class classe) {
        ClasseXML classeXML;
        try {
            Annotation rootElement = classe.getAnnotation(XmlRootElement.class);
            String tagRoot = (String) rootElement.annotationType().getMethod("name").invoke(rootElement);
            classeXML =  new ClasseXML(tagRoot, classe);

            for (Field campo : classe.getDeclaredFields()) {
                if (campo.isAnnotationPresent(XmlElement.class)) {
                    Annotation element = campo.getAnnotation(XmlElement.class);
                    String tagElement = (String) element.annotationType().getMethod("name").invoke(element);
                    classeXML.adicionarAtributo(tagElement);
                }
            }

            return classeXML;

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            //TODO criar uma exception decente
            throw new RuntimeException("Há entidades mal escritas. revise as annotations");
        }
    }

}
