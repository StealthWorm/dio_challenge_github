import java.util.*;

/*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi conseguido.
 */
public class Exercicio2 {
    public static void main(String[] args) {
        int quantLancamentos = 10;
        List<Integer> valores = new ArrayList<>();
        Map<Integer, Integer> lancamentos = new HashMap<>();

        for (int i = 0; i < quantLancamentos; i++) {
            int number = new Random().nextInt(6) + 1;
            valores.add(number);
        }
        System.out.println(valores);

        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado)) {
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            } else {
                lancamentos.put(resultado, 1);
            }
        }

        System.out.println("\nValor " + " Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }

        // for (Integer entry : lancamentos.keySet()) {
        //     System.out.printf("%3d %10d\n", entry, lancamentos.get(entry));
        // }

    }
}
