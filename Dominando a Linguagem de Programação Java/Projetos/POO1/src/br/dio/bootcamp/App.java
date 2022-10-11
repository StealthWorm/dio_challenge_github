package br.dio.bootcamp;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Carro c1 = new Carro();
        c1.setModelo("Novo");
        c1.setCor("Verde");
        c1.setCapacidade(300);

        List<Carro> carros = new ArrayList<>(){{
            add(new Carro("Preta", "Volvo", 100));
            add(new Carro("Prata", "Gol", 200));
            add(new Carro("Vermelha", "Ferrari", 250));
            add(new Carro("Verde", "Ford", 150));
        }};

        List<Carro> carrosCapacidadeMaiorQue100 = carros.stream().filter(val -> (val.getCapacidade() > 100)).toList();

        System.out.println("Total valor tanque c1: " + c1.calcularTotalGasto(3.50));

        for(Carro c : carros) {
            System.out.println(c.getModelo());
        }

        System.out.println("Carros com capacidade maior que 100");
        for(Carro c : carrosCapacidadeMaiorQue100) {
            System.out.println(c.getModelo() + "/" + c.getCapacidade());
        }


    }
}
