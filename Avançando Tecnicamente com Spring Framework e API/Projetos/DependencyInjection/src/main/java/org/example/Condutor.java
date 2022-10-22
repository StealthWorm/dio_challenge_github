package org.example;

import org.springframework.beans.factory.annotation.Autowired;

public class Condutor {
    public static void main(String[] args) {
        Condutor cond = new Condutor(new Carro());
        cond.automovel();
    }

    @Autowired
    private IVeiculo veiculo;

    public Condutor(IVeiculo obj){
        this.veiculo = obj;
    }

    public void automovel() {
        veiculo.acao();
    }
}
