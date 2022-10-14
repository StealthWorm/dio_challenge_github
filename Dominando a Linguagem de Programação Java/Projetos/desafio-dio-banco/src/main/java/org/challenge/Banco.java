package org.challenge;

import java.util.*;
import java.util.function.Consumer;

public class Banco {

    protected static String BANCO_NOME = "Banco BTPS";
    protected String nome;
    protected Set<Conta> contas;

    public Banco(String nome, Set<Conta> contas) {
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

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", contas=" + contas +
                '}';
    }
}
