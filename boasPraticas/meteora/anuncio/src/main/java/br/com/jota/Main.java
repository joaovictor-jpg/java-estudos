package br.com.jota;

import br.com.jota.model.Anuncio;
import br.com.jota.model.Produto;

import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        var produto = new Produto (1, "TV", "4K", new BigDecimal(4000), "Eletrodoméstico");
        var anuncio = new Anuncio(produto, new BigDecimal(2000), 20);

        System.out.println(anuncio);
    }
}