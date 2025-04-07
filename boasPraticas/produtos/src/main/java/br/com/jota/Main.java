package br.com.jota;

import br.com.jota.model.Produto;
import br.com.jota.services.TraduzProdutoService;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Produto> produtos = new CsvToBeanBuilder(new FileReader("src/main/resources/products.csv"))
                .withType(Produto.class).build().parse();

        produtos.forEach(System.out::println);

        TraduzProdutoService traduzProdutoService = new TraduzProdutoService();

        produtos.forEach(produto -> {
            traduzProdutoService.traduzir(produto);
            System.out.println(produto);
        });
    }
}