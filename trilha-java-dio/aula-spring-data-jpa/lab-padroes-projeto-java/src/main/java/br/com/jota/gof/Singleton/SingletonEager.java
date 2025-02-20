package br.com.jota.gof.Singleton;

/**
 * Singleton = "Apressado"
 *
 * Autor = "Jota"
 */
public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstancia() {
        return instancia;
    }
}
