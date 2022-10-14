package org.challenge;

public interface IConta {
    void sacar(double value);

    void depositar(double value);

    void transferir(IConta destino, double value);

    void imprimirExtrato();
}
