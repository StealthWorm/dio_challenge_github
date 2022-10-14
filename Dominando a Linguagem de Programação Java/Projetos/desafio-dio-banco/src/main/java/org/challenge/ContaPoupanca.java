package org.challenge;

import java.util.*;

public class ContaPoupanca extends Conta {
    Random rand = new Random();
    protected double projecaoJuros = rand.nextDouble(0.1d, 2d);
    public ContaPoupanca(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
    }

    public double calcularJurosProximoMes(double montante) {
        return montante * projecaoJuros;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("---------\tEXTRATO CONTA POUPANÇA\t---------");
        super.imprimirInfosComuns();
    }
}
