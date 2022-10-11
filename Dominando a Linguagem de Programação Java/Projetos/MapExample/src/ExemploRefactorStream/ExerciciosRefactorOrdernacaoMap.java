package ExemploRefactorStream;


import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciciosRefactorOrdernacaoMap {
    public ExerciciosRefactorOrdernacaoMap() {
    }

    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        List<Integer> numerosAleatoriosInteger = (List)numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        Stream var10000 = numerosAleatoriosInteger.stream().skip(3L);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);

        long countNumerosUnicos = numerosAleatoriosInteger.stream().distinct().count();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

        System.out.print("Mostre o menor valor da lista: ");
        OptionalInt var8 = numerosAleatoriosInteger.stream().mapToInt(Integer::intValue).min();
        var10001 = System.out;
        Objects.requireNonNull(var10001);
        var8.ifPresent(var10001::println);

        System.out.print("Mostre o maior valor da lista: ");
        var8 = numerosAleatoriosInteger.stream().mapToInt(Integer::intValue).max();
        var10001 = System.out;
        Objects.requireNonNull(var10001);
        var8.ifPresent(var10001::println);

        int somaDosNumerosPares = numerosAleatoriosInteger.stream().filter((i) -> {return i % 2 == 0;}).mapToInt(Integer::intValue).sum();
        System.out.println("Pegue apenas os números ímpares e some: " + somaDosNumerosPares);
        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = (List)numerosAleatoriosInteger.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);
        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = (Map)numerosAleatoriosInteger.stream().collect(Collectors.groupingBy((i) -> {
            return i % 3 == 0 || i % 5 == 0;
        }));
        System.out.println(collectNumerosMultiplosDe3E5);
    }
}