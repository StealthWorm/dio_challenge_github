package org.challenge;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Set<Conta> contas = new LinkedHashSet<>();
        String[] options = {"Conta Corrente", "Conta Poupanca", "Todos", "Listar Clientes"};

        Set<Cliente> clientes = new LinkedHashSet<>() {{
            add(new Cliente("Thierry"));
            add(new Cliente("Juca"));
            add(new Cliente("Alana"));
            add(new Cliente("Jessica"));
            add(new Cliente("Joao"));
            add(new Cliente("Paulo"));
        }};

        for (Cliente c : clientes) {
            Conta cc = new ContaCorrente(c, 0);
            Conta cp = new ContaPoupanca(c, 1);
            cc.depositar(rand.nextDouble(0d, 5000d));
            cp.depositar(rand.nextDouble(0d, 5000d));
            contas.add(cc);
            contas.add(cp);
        }

        Banco banco = new Banco(contas);
        banco.mostrarClientes();

        IConta ccTeste = new ContaCorrente(new Cliente("Rick"), 0);
        IConta cpTeste = new ContaPoupanca(new Cliente("Rick"), 1);

        ccTeste.depositar(1000000d);
        cpTeste.depositar(1000d);

        ContaCorrente cTesteCredito = (ContaCorrente) ccTeste;
        cTesteCredito.descontarCredito(1000d);
        cTesteCredito.descontarCredito(4000d);
        cTesteCredito.descontarCredito(4000d);

        ContaPoupanca cTestePoupanca = (ContaPoupanca) cpTeste;
        System.out.println("A projeção para o proximo mes dessa conta, sob o valor de " + String.format("%.2f", cTestePoupanca.projecaoJuros) + " é de: " + String.format("%.2f", cTestePoupanca.calcularJurosProximoMes(cTestePoupanca.saldo)));

        ccTeste.imprimirExtrato();
        cpTeste.imprimirExtrato();

        int value = JOptionPane.showOptionDialog(
                null,
                "Escolha qual extrato de contas deseja ver",
                "Extrato de clientes " + banco.getNome(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        String saidaFormatada = "Titular\t | \tAgencia\t | \tNumero da Conta\t | Saldo\n\n";

        switch (value) {
            case 0: {
                Set<Conta> contaCorrente = banco.getContas().stream().filter(x -> x.tipoConta == 1).collect(Collectors.toSet());
                JPanel painelFundo;
                JTable tabela;
                JScrollPane barraRolagem;

                for (Conta c : contaCorrente) {
                    saidaFormatada += c.getCliente().getNome() + "   -   " +
                            Integer.toString(c.getAgencia()) + "   -   " +
                            Integer.toString(c.getNumero()) + "   -   " +
                            String.format("R$ %.2f", c.getSaldo()) + "\n";
                    c.imprimirExtrato();
                }

                JOptionPane.showMessageDialog(null, "Lista de todas as contas\n" + saidaFormatada);
                break;
            }
            case 1: {
                Set<Conta> contaCorrente = banco.getContas().stream().filter(x -> x.tipoConta == 1).collect(Collectors.toSet());

                for (Conta c : contaCorrente) {
                    saidaFormatada += c.getCliente().getNome() + "   -   " +
                            Integer.toString(c.getAgencia()) + "   -   " +
                            Integer.toString(c.getNumero()) + "   -   " +
                            String.format("R$ %.2f", c.getSaldo()) + "\n";
                    c.imprimirExtrato();
                }

                JOptionPane.showMessageDialog(null, "Lista das contas poupanca \n" + saidaFormatada);
                break;
            }
            case 2: {
                for (Conta c : banco.getContas()) {
                    saidaFormatada += c.getCliente().getNome() + "   -   " +
                            Integer.toString(c.getAgencia()) + "   -   " +
                            Integer.toString(c.getNumero()) + "   -   " +
                            String.format("R$ %.2f", c.getSaldo()) + "\n";
                    c.imprimirExtrato();
                }

                JOptionPane.showMessageDialog(null, "Lista de todas as contas\n" + saidaFormatada);
                break;
            }
            case 3: {
                Set<String> listarClientes = new TreeSet<>(contas.stream().map(conta -> conta.getCliente().getNome()).toList());
                JOptionPane.showMessageDialog(null, "Lista de Clientes \n" + listarClientes);
                break;
            }

            default: {
                System.out.println("erro de processamento");
            }
        }
    }
}