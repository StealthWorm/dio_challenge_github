package org.challenge;

//abstract class não pode ser implementada. Não faz sentido implementar direto uma Conta, o correto é implementar um dos subtipos que extendem essa classe
public abstract class Conta implements IConta {
    protected static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;

    protected Cliente cliente;
    protected int tipoConta;


    public Conta(Cliente cliente, int tipoConta) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double value) {
        if (saldo > value) {
            saldo -= value;
        } else {
            System.out.println("Saldo induficiente para saque");
        }
    }

    @Override
    public void depositar(double value) {
        saldo += value;
    }

    @Override
    public void transferir(IConta destino, double value) {
        if (this.saldo > value) {
            this.sacar(value);
            destino.depositar(value);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void imprimirInfosComuns() {
        System.out.println("| \tTitular\t | \tAgência\t | \tNúmero da Conta\t | Saldo \t\t\t\t|");
        System.out.println("| \t" + this.cliente.getNome() + "\t | \t" + this.agencia + "\t\t | \t" + this.numero + "\t\t\t\t | " + String.format("R$ %.2f", this.saldo));
        System.out.println("\n");
    }

    public void descontarCredito(double value) {}

    @Override
    public String toString() {
        return "{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", tipoConta=" + tipoConta +
                '}';
    }
}
