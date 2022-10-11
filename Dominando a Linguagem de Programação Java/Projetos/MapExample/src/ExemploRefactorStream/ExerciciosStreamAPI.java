package ExemploRefactorStream;

import java.io.PrintStream;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciciosStreamAPI {

    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        List<Integer> numerosAleatoriosInteger = (List) numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());

//        System.out.println("Imprimir todos os elementos da lista:");
//        numerosAleatorios.stream().forEach(System.out::println);
//        numerosAleatorios.forEach(System.out::println);

//        System.out.println("Pegue os 5 primeiros numeros e coloque dentro de um Set:");
//        numerosAleatoriosInteger.stream().limit(5L).collect(Collectors.toSet()).forEach(System.out::println); //ele imprime só 4 pois SET não aceita valores repetivos

        System.out.println("Transforme a lista de String em uma lista de números inteiros");
        List<Integer> listaInteiros = numerosAleatorios.stream()
                                       .map(Integer::parseInt)
                                       .collect(Collectors.toList());
        System.out.println(listaInteiros);

        // o "filter" exige um predicado, na duvida de Ctrl+Espaço e adicione o mesmo na mao antes de refatorar
//        System.out.println("Pegue os numeros pares e maiores do que 2 e coloque em uma lista");
//        List<Integer> listParesMaiorQue2 = numerosAleatorios.stream().map(Integer::parseInt).filter(val -> (val > 2 && val % 2 == 0)).toList();
//        System.out.println(listParesMaiorQue2);

        // o método "average" exige a chamada de um "OptionalDouble" que retorna nada em caso de erro, é um meio de tratar exceções
//        System.out.println("Mostre a media dos numeros");
//        numerosAleatorios.stream()
//                .mapToInt(Integer::parseInt)
//                .average()
//                .ifPresent(System.out::println);

//        System.out.println("Remover valores ímpares");
//        listaInteiros.removeIf(val -> val % 2 != 0);
//        System.out.println(listaInteiros);

//        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
//        Stream var10000 = numerosAleatoriosInteger.stream().skip(3L);

//        Objects.requireNonNull(var10001);
//        var10000.forEach(var10001::println);
//        long countNumerosUnicos = numerosAleatoriosInteger.stream().distinct().count();

        Set<Integer> countNumerosUnicos = listaInteiros.stream().collect(Collectors.toSet());
        Integer count = countNumerosUnicos.size();
        //        numerosAleatoriosInteger.stream().limit(5L).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);
        System.out.println("O tamanho final é de " + count);

//        System.out.print("Mostre o menor valor da lista: " +  listaInteiros.stream().mapToInt(Integer::intValue).min());
//        System.out.print("Mostre o maior valor da lista: " + numerosAleatorios.stream().mapToInt(Integer::parseInt).max());

//        int somaDosNumerosPares = numerosAleatoriosInteger.stream().filter((i) -> {
//            return i % 2 == 0;
//        }).mapToInt(Integer::intValue).sum();
//        System.out.println("Pegue apenas os números ímpares e some: " + somaDosNumerosPares);
//        System.out.println("Mostre a lista na ordem númerica: ");
//        List<Integer> numerosOrdemNatural = (List) numerosAleatoriosInteger.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
//        System.out.println(numerosOrdemNatural);
//        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
//        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = (Map) numerosAleatoriosInteger.stream().collect(Collectors.groupingBy((i) -> {
//            return i % 3 == 0 || i % 5 == 0;
//        }));
//        System.out.println(collectNumerosMultiplosDe3E5);
    }
}
