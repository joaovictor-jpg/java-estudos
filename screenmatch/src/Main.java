import br.com.joao.screenmetch.modelos.Filme;
import modal.Pessoa;
import modal.Produto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        Filme filme = new Filme("Homem Aranha", 2003);
        filme.setDiretor("João");
        filme.setDuracaoEmMinutos(190);

        listaDeFilmes.add(filme);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).toString());


        System.out.println("| ------------------------------------------------------------ |");

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("João Victor", 24));
        pessoas.add(new Pessoa("André", 54));

        System.out.println(pessoas.size());
        System.out.println(pessoas.get(0).toString());
        System.out.println(pessoas);

        Produto produto = new Produto("Lapis", 5.6, 7, 3, 5);
        System.out.println(produto);
    }
}