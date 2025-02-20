package br.com.jota.gof.Singleton;

/**
 * Singleton = "Laze Holder".
 *
 * Author = "Jota"
 */
public class SingletonLazyHolder {

    private static class Holder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
    }

    public static SingletonLazyHolder getInstancia() {
        return Holder.instancia;
    }
}
