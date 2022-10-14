package org.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

    @Test
    void validarSeSaldoEZeroEmAmbasAsContas() {
        Cliente cli = new Cliente("Thierry");
        Conta cc = new ContaCorrente(cli, 0);
        Conta cp = new ContaPoupanca(cli, 1);

        assertEquals(cp.saldo, cc.saldo);
    }

    @Test
    void validarLimiteCreditoContaCorrenteE5000() {
        Cliente cli = new Cliente("Thierry");
        ContaCorrente cc = new ContaCorrente(cli, 0);

        assertEquals(5000d, cc.limiteCredito);
    }

    @Test
    void validarContadorNumeroConta() {
        Cliente cli = new Cliente("Thierry");
        ContaCorrente cc = new ContaCorrente(cli, 0);

        //ate esse ponto foram criadas 2 contas corrente nos teste, então o esperado é que o ocntador seja 2
        assertEquals(2, cc.numero);
    }
}
