package org.challenge;

import javax.swing.*;
import java.util.Random;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Set<Conta> contas = new LinkedHashSet<>();

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

        Banco banco = new Banco("nome teste", contas);

        String[] options = {"Conta Corrente", "Conta Poupanca", "Todos"};

        banco.getContas().stream().filter(x -> x.tipoConta == 1).collect(Collectors.toSet());

        List<Conta> contaCorrenteThierry = banco.getContas().stream().filter(x -> x.getCliente().getNome() == "Thierry").toList();
        contaCorrenteThierry.forEach(System.out::println);
        contaCorrenteThierry.forEach(conta -> {
            if (conta.tipoConta == 0) {
                conta.sacar(1000d);
            } else {
                conta.depositar(1000d);
            }
        });

        contaCorrenteThierry.forEach(conta -> conta.descontarCredito(conta, 1000d));
        System.out.println(contaCorrenteThierry);

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

                for (Conta c : contaCorrente) {
                    saidaFormatada += c.getCliente().getNome() + "\t-\t" +
                            Integer.toString(c.getAgencia()) + "\t-\t" +
                            Integer.toString(c.getNumero()) + "\t-\t" +
                            String.format("R$ %.2f", c.getSaldo()) + "\n";
                    c.imprimirExtrato();
                }

                JOptionPane.showMessageDialog(null, "Lista de todas as contas\n" + saidaFormatada);
                break;
            }
            case 1: {
                Set<Conta> contaCorrente = banco.getContas().stream().filter(x -> x.tipoConta == 1).collect(Collectors.toSet());

                for (Conta c : contaCorrente) {
                    saidaFormatada += c.getCliente().getNome() + "\t-\t" +
                            Integer.toString(c.getAgencia()) + "\t-\t" +
                            Integer.toString(c.getNumero()) + "\t-\t" +
                            String.format("R$ %.2f", c.getSaldo()) + "\n";
                    c.imprimirExtrato();
                }

                JOptionPane.showMessageDialog(null, "Lista das contas poupanca \n" + saidaFormatada);
                break;
            }
            case 2: {
                for (Conta c : banco.getContas()) {
                    saidaFormatada += c.getCliente().getNome() + "\t-\t" +
                            Integer.toString(c.getAgencia()) + "\t-\t" +
                            Integer.toString(c.getNumero()) + "\t-\t" +
                            String.format("R$ %.2f", c.getSaldo()) + "\n";
                    c.imprimirExtrato();
                }

                JOptionPane.showMessageDialog(null, "Lista de todas as contas\n" + saidaFormatada);
                break;
            }

            default: {
                System.out.println("erro de processamento");
            }
        }
    }
}