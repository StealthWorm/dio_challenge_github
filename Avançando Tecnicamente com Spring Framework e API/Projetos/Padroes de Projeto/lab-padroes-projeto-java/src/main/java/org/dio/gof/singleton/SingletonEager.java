package org.dio.gof.singleton;

// Singleton "Apressado"
public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager(); // ja instancia direto um novo

    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstance() {
        return instancia;
    }
}
