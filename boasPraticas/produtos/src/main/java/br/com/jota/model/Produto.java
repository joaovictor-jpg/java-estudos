package br.com.jota.model;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class Produto {
    @CsvBindByName(column = "ProductID", required = true)
    private int id;
    @CsvBindByName(column = "ProductName", required = true)
    private String nome;
    @CsvBindByName(column = "Description", required = true)
    private String descricao;
    @CsvBindByName(column = "Price", required = true)
    private BigDecimal valor;
    @CsvBindByName(column = "Category", required = true)
    private String categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
