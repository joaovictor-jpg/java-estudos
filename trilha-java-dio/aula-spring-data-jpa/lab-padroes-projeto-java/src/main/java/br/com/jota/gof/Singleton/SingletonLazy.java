package br.com.jota.gof.Singleton;

/**
 * Singleton = "Pregiçoso"
 *
 * @Author = Jota
 */
public class SingletonLazy {
    private static SingletonLazy instancia;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstance() {
        if (instancia == null) {
            instancia = new SingletonLazy();
            return instancia;
        }
        return instancia;
    }
}
