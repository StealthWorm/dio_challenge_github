package org.dio.gof.strategy;

public class ComportamentoDefensivo implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Robo esta se movendo de modo defensivo");
    }
}
