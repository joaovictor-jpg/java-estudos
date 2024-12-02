package modal.lista;

import modal.Produto;

import java.util.ArrayList;

public class TrabalhandoComLista {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("João Victor");
        nomes.add("Claudia Julio");
        nomes.add("Andre Madeira");
        nomes.add("Neuda Maria");
        nomes.add("Candida");

        nomes.forEach(System.out::println);

        System.out.println("| ------------------------------------------------------------------------------ |");

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Lapis", 4, 5, 9, 3.50));
        produtos.add(new Produto("Caneta", 5, 7, 10, 2.25));
        produtos.add(new Produto("Caderno", 4, 5, 9, 15.00));
        produtos.add(new Produto("Teclado", 9, 7, 10, 50.75));

        double somaValor = 0;

        for (Produto produto : produtos) {
            somaValor += produto.getPreco();
        }

        double media = somaValor / produtos.size();

        System.out.println(String.format("A média é: %.2f", media));

    }
}
