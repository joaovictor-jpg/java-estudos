package modal.lista;

import modal.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrabalhandoComLista {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("João Victor");
        nomes.add("Claudia Julio");
        nomes.add("Andre Madeira");
        nomes.add("Neuda Maria");
        nomes.add("Candida");

        nomes.forEach(System.out::println);

        ArrayList<String> buscaPorArtistas = new ArrayList<>();

        buscaPorArtistas.add("Adam Sendler");
        buscaPorArtistas.add("Paulo");
        buscaPorArtistas.add("Jacqueline");

        Collections.sort(buscaPorArtistas);

        System.out.println(buscaPorArtistas);

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

        System.out.println("| ----------------------------------------------------------------------------------------- |");

        List<Integer> listInt = new ArrayList<>();
        listInt.add(3);
        listInt.add(4);
        listInt.add(6);
        listInt.add(7);
        listInt.add(9);
        Collections.sort(listInt);
        System.out.println(listInt);

    }
}
