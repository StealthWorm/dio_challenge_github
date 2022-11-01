package org.dio.gof;

import org.dio.gof.facade.Facade;
import org.dio.gof.singleton.SingletonEager;
import org.dio.gof.singleton.SingletonLazy;
import org.dio.gof.singleton.SingletonLazyHolder;
import org.dio.gof.strategy.*;

public class Main {
    public static void main(String[] args) {
        //Testes relacionados ao Design Pattern Singleton
        // ele devolve a mesma instancia do codigo em memória, pois o singleton trabalha com apenas uma instancia
        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstance();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstance();
        System.out.println(eager);
        eager = SingletonEager.getInstance();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);


        //Testes relacionados ao Design Pattern Strategy
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento ofensivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        robo.mover();
        robo.setComportamento(defensivo);
        robo.mover();
        robo.setComportamento(ofensivo);
        robo.mover();
        robo.mover();
        robo.mover();


        //Testes relacionados ao Design Pattern Facade
        Facade facade = new Facade();
        facade.migrarCliente("Venilton", "14801788");
    }
}