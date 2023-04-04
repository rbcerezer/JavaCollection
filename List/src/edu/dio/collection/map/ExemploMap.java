package edu.dio.collection.map;

import java.sql.SQLOutput;
import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        System.out.println("- Crie um dicionário que relacione os modelos e seus relativos consumos: ");

        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("MObi", 16.1);
            put("HB20", 14.4);
            put("Kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("- Substitua o consumo do Gol por 15.2 km/L: ");
        carrosPopulares.put("Gol",15.2);
        System.out.println(carrosPopulares);

        System.out.println("- Confira se o modelo Tucson está no dicionário: ");
        System.out.println("O modelo Tucson está no dicionário?: " + carrosPopulares.containsKey("Tucson"));

        System.out.println("- Exiba o consumo do Uno: ");
        System.out.println("O consumo do Uno é: " + carrosPopulares.get("Uno"));

        //System.out.println("- Exiba o terceiro modelo adicionado: ");
        // não existe esta função

        System.out.println("- Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("- Exiba o consumo dos carros: ");
        System.out.println(carrosPopulares.values());
        //Collection<Double> values = carrosPopulares.values(); *pode colocar em uma variavel


        System.out.println("- Exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry: entries) {
            if(entry.getValue().equals(consumoMaisEficiente))
                modeloMaisEficiente = entry.getKey();
        }
        System.out.println("Modelos mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);


        System.out.println("- Exiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries1 = carrosPopulares.entrySet();
        String modeloMenosEficiente = "";

        for (Map.Entry<String, Double> entry: entries1) {
            if(entry.getValue().equals(consumoMenosEficiente))
                modeloMenosEficiente = entry.getKey();

        }
        System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);

        System.out.println("- Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("A soma dos consumos é: " + soma);

        System.out.println("- Exiba a média dos consumos deste dicionário: ");
        System.out.println("A média de consumo é: " + soma/carrosPopulares.size());

        System.out.println("* " + carrosPopulares);
        System.out.println("- Remova os modelos com consumo igual a 15.6 km/L: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("- Exiba todos os carros na ordem que foram informados: ");
        //usar o LinkedHashMap
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("MObi", 16.1);
            put("HB20", 14.4);
            put("Kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);


        System.out.println("- Exiba o dicionário ordenado pelo modelo: ");
        //Ordenação pela chave -> usar o TreeMap
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println("Ordem por modelo: " + carrosPopulares2);

        System.out.println("- Apague o conjunto de carros: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);


        System.out.println("- Confira se o dicionário está vazia: ");
        System.out.println("A lista está vazia: " + carrosPopulares.isEmpty());

    }
}
