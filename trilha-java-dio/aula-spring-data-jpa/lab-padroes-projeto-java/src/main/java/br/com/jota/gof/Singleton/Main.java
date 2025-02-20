package br.com.jota.gof.Singleton;

public class Main {
    public static void main(String[] args) {
        SingletonLazy lazy = SingletonLazy.getInstance();
        SingletonLazy lazy2 = SingletonLazy.getInstance();
        SingletonEager eager = SingletonEager.getInstancia();
        SingletonEager eager2 = SingletonEager.getInstancia();
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        SingletonLazyHolder lazyHolder2 = SingletonLazyHolder.getInstancia();

        System.out.println(lazy);
        System.out.println(lazy2);
        System.out.println(eager);
        System.out.println(eager2);
        System.out.println(lazyHolder);
        System.out.println(lazyHolder2);
    }
}