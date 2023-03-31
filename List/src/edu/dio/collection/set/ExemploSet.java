package edu.dio.collection.set;

import com.sun.source.doctree.SeeTree;

import java.lang.reflect.Array;
import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5, 9.3, 5d,7d,0d,3.6));
        System.out.println(notas.toString());

        //System.out.println("Exiba a posição da nota 5.0: ");
        //não consigo verificar esta solicitação no método Set

        //System.out.println("Adiciona na lista a nota 8.0 na posição 4: ");
        // o set não permite este tipo de adição por sempre adicinar em modo furtivo

        //System.out.println("Substitua a nota 8.0 pela nota 6.0: ");
        // o set não permite esta operação

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));

        //System.out.println("Exiba a terceira nota adicionada");
        // o set não permite esta operação

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a média das notas: " + soma/ notas.size());

        System.out.println("Remova a nota 0.0: ");
        notas.remove(0d);
        System.out.println(notas);

        //System.out.println("Remova a nota da posição 0: ");
        // o Set não permite trabalhar com o index (índice)

        System.out.println("Remova as notas menores que 7 e exiba na lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem que foram informadas: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);
        //erro pq não permite a inserção de elementos duplicados "7.0"

        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);


        System.out.println("Apague todo o conjunto: ");
        notas.clear();

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());



    }
}
