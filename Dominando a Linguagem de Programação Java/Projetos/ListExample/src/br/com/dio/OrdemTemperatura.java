package br.com.dio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OrdemTemperatura {
    public static void main(String[] args) {
        //lista com as temperaturas medias dos  6 primeiros meses do ano
        // calcular media semestral das temperaturas e mostrar todas as temperaturas acima da media e em que mes elas ocorreram.
        // mostrar o mes por extenso 1-Janeiro
        List<Double> temperaturas = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            double temp = new Random().nextDouble(40d);
            temperaturas.add(temp);
        }

        Iterator<Double> iteratorTemperatura = temperaturas.iterator();
        Double temperaturaMedia, temperaturaTotal = 0d;

        while (iteratorTemperatura.hasNext()) {
            Double next = iteratorTemperatura.next();
            temperaturaTotal += next;
        }
        temperaturaMedia = (temperaturaTotal / temperaturas.size());

        System.out.println(temperaturas);
        System.out.println("A media das temperaturas é: " + String.format("%.2f", temperaturaMedia) + " oC");

        System.out.println("As maiores temperaturas foram nos seguintes meses:");
        for (Double temp : temperaturas) {
            if (temp > temperaturaMedia) {
                System.out.println(formatarMes(temperaturas.indexOf(temp)) + String.format("%.2f", temp) + " graus");
            }
        }
    }
    public static String formatarMes(Integer mes) {
        String mesFormatado;

        switch (mes) {
            case 0: {
                mesFormatado = "Janeiro - ";
                break;
            }
            case 1: {
                mesFormatado = "Fevereiro - ";
                break;
            }
            case 2: {
                mesFormatado = "Março - ";
                break;
            }
            case 3: {
                mesFormatado = "Abril - ";
                break;
            }
            case 4: {
                mesFormatado = "Maio - ";
                break;
            }
            case 5: {
                mesFormatado = "Junho - ";
                break;
            }
            default: {
                mesFormatado = "Indefinido";
            }
        }

        return mesFormatado;
    }
}


