//package br.com.dio.collection.list;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class ExemploList {
    public static void main(String[] args) {
        List<Double> notas = new ArrayList<Double>();
        notas.add(7d);
        notas.add(8d);
        notas.add(9d);
        notas.add(10d);
        notas.add(11d);
        notas.add(12d);
        notas.add(13d);

        System.out.println(notas.toString());

        // indica o indice de um valor da liste
        System.out.println(notas.indexOf(10d));

        // adiciona um valor na lista em um indice especifico
        notas.add(4, 8d);
        System.out.println(notas);

        // substitue um valor na lista em um indice especifico
        notas.set(notas.indexOf(7.0), 11d);
        System.out.println(notas);

        // verifica se um valor esta na lista
        System.out.println(notas.contains(1d));
        System.out.println(notas.contains(9d));

        // exibe os valores na ordem em que foram informados
        for (Double nota : notas) {
            System.out.println(nota);
        }

        System.out.println("\n");

        System.out.println("exibe uma posição especifica: " + notas.get(2));

        System.out.println("Exibe a menor nota: " + Collections.min(notas));

        System.out.println("Exibe a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exibe a soma dos valores: " + soma);

        System.out.println("A media dos valores: " + (soma / notas.size()));

        notas.remove(0);
        System.out.println("Remover um valor especifico (notas.remove(index)): " + notas);

        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();

            if (next <= 9)
                iterator1.remove();
        }
        System.out.println("Remover todos os valores que satisfaçam uma condição (menor que 9): " + notas);

        notas.clear();
        System.out.println("Apagar a lista: " + notas);

        System.out.println("Checar se a lista esta vazia: " + notas.isEmpty());

    }
}
