package org.challenge;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("---------\tEXTRATO CONTA POUPANÇA\t---------");
        super.imprimirInfosComuns();
    }
}
