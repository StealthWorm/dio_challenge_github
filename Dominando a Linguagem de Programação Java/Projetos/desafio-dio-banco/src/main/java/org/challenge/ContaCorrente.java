package org.challenge;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("---------\tEXTRATO CONTA CORRENTE\t---------");
        imprimirInfosComuns();
    }
}
