package org.dio.gof.singleton;

// Singleton "Lazy Holder"
// <a href="https://stackoverflow.com/a/24018148">Referencia</a>
public class SingletonLazyHolder {
    // so tem a função de encapsular a instanciação
    private static class InstanceHolder {
        private static SingletonLazyHolder instancia = new SingletonLazyHolder(); // ja instancia direto um novo
    }

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstance() {
        return InstanceHolder.instancia;
    }
}
