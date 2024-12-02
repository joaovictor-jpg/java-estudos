package modal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cartao {
    private String nome;
    private Double credito;
    private List<Produtos> produto = new ArrayList<>();

    public Cartao(String nome, Double credito) {
        this.nome = nome;
        this.credito = credito;
    }

    public String getNome() {
        return nome;
    }

    public Double getCredito() {
        return credito;
    }

    public List<Produtos> getProduto() {
        Collections.sort(produto);
        List<Produtos> produtos = produto;
        return produtos;
    }

    public void setProduto(Produtos produto) {
        if (this.credito > produto.getPreco()) {
            this.credito -= produto.getPreco();
            this.produto.add(produto);
            System.out.println("Produto comprado com sucesso");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "nome='" + nome + '\'' +
                ", credito=" + credito +
                ", produto=" + produto +
                '}';
    }
}
