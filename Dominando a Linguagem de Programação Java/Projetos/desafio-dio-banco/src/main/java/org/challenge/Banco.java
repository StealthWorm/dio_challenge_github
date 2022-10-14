package org.challenge;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Banco {

    protected static String BANCO_NOME = "Banco BTPS";
    protected String nome;
    protected Set<Conta> contas;

    public Banco(Set<Conta> contas) {
        this.nome = BANCO_NOME;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    public void mostrarClientes() {
        System.out.println("---------\tLista de Clientes\t---------");
        Set<String> clientes = new TreeSet<>(contas.stream().map(conta -> conta.getCliente().getNome()).toList());
        for (String c : clientes) {
            System.out.println(c);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", contas=" + contas +
                '}';
    }
}
