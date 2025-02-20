package br.com.jota.gof.facade;

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.migrarCliente("João", "21240470");
    }
}
