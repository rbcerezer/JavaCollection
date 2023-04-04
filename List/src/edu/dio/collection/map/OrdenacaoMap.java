package edu.dio.collection.map;

import java.sql.SQLOutput;
import java.util.*;

public class OrdenacaoMap {
    public static void main(String[] args) {



        System.out.println("--\tOrdem Aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put(" Jk Rowling", new Livro("Harry Potter", 350 ));
            put(" Paulo Coelho", new Livro("O Alquimista", 210 ));
            put(" Shirley Jackson", new Livro("A Maldição da Hill House", 390 ));
        }};
        for (Map.Entry<String, Livro> livro: meusLivros.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        };

        System.out.println("--\tOrdem Inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put(" Jk Rowling", new Livro("Harry Potter", 350 ));
            put(" Paulo Coelho", new Livro("O Alquimista", 210 ));
            put(" Shirley Jackson", new Livro("A Maldição da Hill House", 390 ));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
        System.out.println(livro.getKey() + " - " + livro.getValue().getNome());


        System.out.println("--\tOrdem Alfabética Autores\t--");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());


        System.out.println("--\tOrdem Alfabética nome dos Livros\t--");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros3)
        System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem Número de Páginas\t--");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPagina());
        meusLivros4.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros4)
            System.out.println(livro.getKey() + " - " +livro.getValue().getPaginas());



    }
}

class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }


    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }


}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}
