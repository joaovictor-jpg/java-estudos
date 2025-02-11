package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import map.entities.Produto;

public class EstoqueProdutos {
    public static void main(String[] args) {
        Map<Integer, Produto> estoqueProdutos = new HashMap<>();
        estoqueProdutos.put(101, new Produto(101, "Notebook", 5, 3500.00));
        estoqueProdutos.put(103, new Produto(103, "Teclado", 8, 200.00));
        estoqueProdutos.put(105, new Produto(105, "Mousepad", 15, 50.00));
        estoqueProdutos.put(102, new Produto(102, "Mouse", 10, 150.00));
        estoqueProdutos.put(104, new Produto(104, "Monitor", 3, 1200.00));
        estoqueProdutos.put(106, new Produto(106, "Mecbook", 2, 3700.00));

        System.out.println("Lista de produtos");
        System.out.println(estoqueProdutos);
        System.out.println("|------------------------------------------------------------------------|");

        System.out.println("Calcular total Estoque");
        List<Produto> produtos = estoqueProdutos.values().stream().toList();
        Double total = produtos.stream().reduce(0.0, (acc, produto) -> acc = acc + (produto.getPreco() * produto.getQuantidade()), Double::sum);
        System.out.println(total);
        System.out.println("|------------------------------------------------------------------------|");

        System.out.println("Produto mais caro");
        var produto = produtos.stream().max(Comparator.comparing(Produto::getPreco)).orElseThrow();
        System.out.println(produto);
        System.out.println("|------------------------------------------------------------------------|");

        System.out.println("Obter produto mais barato");
        produto = produtos.stream().min(Comparator.comparing(Produto::getPreco)).orElseThrow();
        System.out.println(produto);
        System.out.println("|------------------------------------------------------------------------|");

        System.out.println("Obter produto com maior quantidade");
        produto = produtos.stream().max(Comparator.comparing(Produto::getQuantidade)).orElseThrow();
        System.out.println(produto);
        System.out.println("|------------------------------------------------------------------------|");
    }
}
