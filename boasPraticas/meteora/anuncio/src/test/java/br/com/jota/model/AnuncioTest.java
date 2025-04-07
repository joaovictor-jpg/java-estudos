package br.com.jota.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AnuncioTest {
    @Test
    void getQuantidade() {
        var produto = new Produto (1, "TV", "4K", new BigDecimal(4000), "Eletrodoméstico");
        var anuncio = new Anuncio(produto, new BigDecimal(2000), 20);

        Assertions.assertEquals(20, anuncio.getQuantidade());
    }
}