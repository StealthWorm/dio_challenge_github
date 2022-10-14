package org.challenge;

public class ContaCorrente extends Conta {
    protected double limiteCredito = 5000d;

    public ContaCorrente(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("---------\tEXTRATO CONTA CORRENTE\t---------");
        super.imprimirInfosComuns();
        System.out.println("Crédito disponível: " + limiteCredito);
    }
    @Override
    public void descontarCredito(double value) {
        if (limiteCredito > value) {
            limiteCredito -= value;
        } else {
            System.out.println("Seu saldo atual é de R$ " + String.format("%.2f", limiteCredito) + ". Não há créditos suficientes para realizar a transação");
        }
    }
}
