package org.dio.gof.strategy;

public class ComportamentoNormal implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Robo esta se movendo normalmente");
    }
}
