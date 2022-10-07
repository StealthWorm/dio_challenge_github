package br.com.dio;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CenaDoCrime {
    public static void main(String[] args) {
        // use uma lista pra fazer 5 perguntas para uma pessoa sobre um crime
        // 1 - telefonou para a vitima?
        // 2 - esteve no local do crime?
        // 3 - mora perto da vitima?
        // 4 - devia para a vitima?
        // 5 - ja trabalhou com a vitima?
        // se a pessoa responder positivo a 2 questões ela é classificada como suspeita, entre 3 e 4 como Cúmplice e 5 como assasssina.
        // caso contrario sera classificada como inocente.
        // armazenar as respostas (S/N), na lista. filtro pela quantidade de repetições

        Scanner scan = new Scanner(System.in);
        String resp;
        int count;

        List<String> respostas = new ArrayList<>();
        List<String> perguntas = new ArrayList<>() {{
            add("Você havia telefonado para a vítima ?");
            add("Você esteve no local do crime no dia do ocorrido ?");
            add("Você morava perto da vítima ?");
            add("Você devia algo para a vítima ?");
            add("Você ja trabalhou com a vítima ?");
        }};

        System.out.println("--------\tINTERROGATÓRIO (Por favor responda com 'S' para Sim e 'N' para Não)\t--------");
        for (String p : perguntas) {
            System.out.println(p);
            while (!scan.hasNext("S") && !scan.hasNext("N") && !scan.hasNext("s") && !scan.hasNext("n")) {
                System.out.println("Essa não é uma entrada válida!");
                scan.next();
            }
            resp = scan.next();
            respostas.add(resp);
        }

        count = Collections.frequency(respostas, "S") + Collections.frequency(respostas, "s");

        if (count == 2) {
            System.out.println("Você é considerado suspeito.");
        } else if (count > 2 && count < 5) {
            System.out.println("Você é considerado cúmplice.");
        } else if (count == 5) {
            System.out.println("Você é culpado.");
        } else {
            System.out.println("Você é inocente.");
        }
    }
}
