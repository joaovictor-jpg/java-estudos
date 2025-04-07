package br.com.jota.model;

import java.math.BigDecimal;

public class Anuncio {
    private Produto produto;
    private BigDecimal valor;
    private Integer quantidade;

    public Anuncio(Produto produto, BigDecimal valor, Integer quantidade) {
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "produto=" + produto +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
