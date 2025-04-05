package br.com.jota;

import br.com.jota.refl.ObjectToJson;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1, "João", "123");
        ObjectToJson objectToJson = new ObjectToJson();
        System.out.println(objectToJson.transforme(pessoa));
    }
}