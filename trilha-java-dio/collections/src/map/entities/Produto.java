package map.entities;

public class Produto {
    private Integer codigo;
    private String nome;
    private Integer quantidade;
    private Double preco;

    public Produto(Integer codigo, String nome, Integer quantidade, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto(Produto produto) {
        this.codigo = produto.getCodigo();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
        this.preco = produto.getPreco();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto { Código: " + codigo + ", Nome: " + nome +
                ", Quantidade: " + quantidade + ", Preço: R$ " + preco + " }";
    }

}
