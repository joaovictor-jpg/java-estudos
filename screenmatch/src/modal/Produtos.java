package modal;

public class Produtos implements Comparable<Produtos> {
    private String nome;
    private Double preco;

    public Produtos(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public int compareTo(Produtos produtos) {
        return this.preco.compareTo(produtos.getPreco());
    }

    @Override
    public String toString() {
        return "Produtos{ " +
                "nome= '" + nome + '\'' +
                ", preco= " + preco +
                '}';
    }
}
