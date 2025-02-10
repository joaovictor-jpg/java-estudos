package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.entities.Livro;
import list.entities.Pessoa;
import list.utils.ComparatorPorAltura;
import list.utils.ComparatorPorAnoLancamentoLivro;

public class MainList {
    /*
     * funções básicas de interface list
     * public static void main(String[] args) {
     * List<Tarefa> tarefas = new ArrayList<>();
     * 
     * tarefas.add(new Tarefa("Estudar Java"));
     * tarefas.add(new Tarefa("Estudar SQL"));
     * tarefas.add(new Tarefa("Estudar DML"));
     * tarefas.add(new Tarefa("Estudar Postgres"));
     * tarefas.add(new Tarefa("Estudar Microsservices"));
     * tarefas.add(new Tarefa("Estudar JavaScript"));
     * tarefas.add(new Tarefa("Estudar React"));
     * tarefas.add(new Tarefa("Estudar Angular"));
     * 
     * System.out.println("Lista de Tarefas");
     * tarefas.forEach(System.out::println);
     * 
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Removendo da lista");
     * List<Tarefa> ListaDeTarefasAtualizada = tarefas.stream().filter(t ->
     * !t.getDescricao().equalsIgnoreCase("Estudar React")).toList();
     * ListaDeTarefasAtualizada.forEach(System.out::println);
     * 
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * System.out.println("Tamanho da lista " + tarefas.size());
     * 
     * System.out.println("Exercícios 1");
     * List<Item> carrinhoDeCompras = new ArrayList<>();
     * 
     * carrinhoDeCompras.add(new Item("Mause", 25.50, 10));
     * carrinhoDeCompras.add(new Item("Teclado", 17.30, 50));
     * carrinhoDeCompras.add(new Item("Monitor", 450.50, 7));
     * carrinhoDeCompras.add(new Item("Gabineite", 120.00, 25));
     * carrinhoDeCompras.add(new Item("Ryze 3", 500.00, 4));
     * carrinhoDeCompras.add(new Item("Memoria RAN", 250.70, 150));
     * carrinhoDeCompras.add(new Item("HD", 100.00, 45));
     * carrinhoDeCompras.add(new Item("Cooler", 50.35, 60));
     * carrinhoDeCompras.add(new Item("SSD", 230.00, 20));
     * 
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * System.out.println("Itens Carrinho:");
     * carrinhoDeCompras.forEach(System.out::println);
     * 
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * System.out.println("Remover item do carrinho");
     * List<Item> carrinhoAtualizado = carrinhoDeCompras.stream().filter(c ->
     * !c.getNome().equalsIgnoreCase("SSD")).toList();
     * carrinhoAtualizado.forEach(System.out::println);
     * 
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * System.out.println("Calcular valor total");
     * Double total = carrinhoAtualizado.stream().reduce(0.0,
     * (acc, item) -> acc + (item.getPreco() * item.getQuantidade()), Double::sum);
     * Double total = carrinhoAtualizado.stream().mapToDouble(item ->
     * item.getPreco() * item.getQuantidade()).sum();
     * System.out.println(total);
     * 
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * carrinhoAtualizado.forEach(System.out::println);
     * }
     */

    // Pesquisa em list
    /*
     * public static void main(String[] args) {
     * List<Livro> livros = new ArrayList<>();
     * 
     * livros.add(new
     * Livro("Coleção Cute & Comfy Coloring Book for Adults Special - Bold Easy - Kit com 3 Livros de Colorir Adulto"
     * , "Camelot Editora", 2025));
     * livros.add(new Livro("Dom Quixote", "Miguel de Cervantes", 1605));
     * livros.add(new Livro("Orgulho e Preconceito", "Jane Austen", 1813));
     * livros.add(new Livro("O Morro dos Ventos Uivantes", "Emily Brontë", 1847));
     * livros.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866));
     * livros.add(new Livro("Os Miseráveis", "Victor Hugo", 1862));
     * livros.add(new Livro("O Grande Gatsby", "F. Scott Fitzgerald", 1925));
     * 
     * System.out.println("Lista de livros");
     * livros.forEach(System.out::println);
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Lista de livros por autor:");
     * List<Livro> livrosPorAutor = livros.stream().filter(livro ->
     * livro.getAutor().equalsIgnoreCase("Victor Hugo")).toList();
     * livrosPorAutor.forEach(System.out::println);
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Buscar por intervalo de ano");
     * List<Livro> listaDeLivroPorAno = livros.stream()filter(livro ->
     * livro.getAnoDeLancamento() > 1800 &&
     * livro.getAnoDeLancamento() < 1900).toList();
     * listaDeLivroPorAno.forEach(System.out::println);
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * System.out.println("Buscar livro por titulo");
     * List<Livro> livrosPorTitulo = livros.stream().filter(livro ->
     * livro.getTitulo().equalsIgnoreCase("Dom Quixote")).toList();
     * livrosPorTitulo.forEach(System.out::println);
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * 
     * List<Integer> numeros = List.of(1, 2, 3, 99, 50, 50, 63, 101, 58, 69, 250,
     * 95, 96, 75);
     * 
     * System.out.println("Mostrar números da lista");
     * numeros.forEach(System.out::println);
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Soma dos números");
     * Integer soma = numeros.stream()
     * .mapToInt(Integer::intValue)
     * .sum();
     * System.out.println(soma);
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Exibir o menor valor");
     * Integer menorValor = numeros.stream().min(Integer::compareTo).orElseThrow();
     * System.out.println(menorValor);
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Exibir o maior valor");
     * Integer maiorValor = numeros.stream().max(Integer::compareTo).orElseThrow();
     * System.out.println(maiorValor);
     * System.out.println(
     * "|---------------------------------------------------------------------------------------------|"
     * );
     * }
     */

    public static void main(String[] args) {
        /*
         * List<Pessoa> pessoas = List.of(
         * new Pessoa("Ana", 25, 1.68),
         * new Pessoa("Bruno", 30, 1.75),
         * new Pessoa("Carla", 22, 1.60),
         * new Pessoa("Diego", 28, 1.80),
         * new Pessoa("Elisa", 35, 1.65));
         * 
         * System.out.println("Lista de pessoas");
         * pessoas.forEach(System.out::println);
         * System.out.println(
         * "|---------------------------------------------------------------------------------------------|"
         * );
         * 
         * System.out.println("Lista de pessoas ordenada por idade");
         * List<Pessoa> pessoasOrdenadasPorIdade = new ArrayList<>(pessoas);
         * Collections.sort(pessoasOrdenadasPorIdade);
         * pessoasOrdenadasPorIdade.forEach(System.out::println);
         * System.out.println("Pessoa ordenada por idade com stream:");
         * List<Pessoa> pessoasOrdenadaPorIdadeComStream =
         * pessoas.stream().sorted(Pessoa::compareTo).toList();
         * pessoasOrdenadaPorIdadeComStream.forEach(System.out::println);
         * System.out.println(
         * "|---------------------------------------------------------------------------------------------|"
         * );
         * 
         * System.out.println("Lista de pessoas ordenada por altura");
         * List<Pessoa> pessoasOrdenadaPorAltura = new ArrayList<>(pessoas);
         * Collections.sort(pessoasOrdenadaPorAltura, new ComparatorPorAltura());
         * pessoasOrdenadaPorAltura.forEach(System.out::println);
         * System.out.println(
         * "|---------------------------------------------------------------------------------------------|"
         * );
         */

        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(
                "Coleção Cute & Comfy Coloring Book for Adults Special - Bold Easy - Kit com 3 Livros de Colorir Adulto",
                "Camelot Editora", 2025));
        livros.add(new Livro("Dom Quixote", "Miguel de Cervantes", 1605));
        livros.add(new Livro("Orgulho e Preconceito", "Jane Austen", 1813));
        livros.add(new Livro("O Morro dos Ventos Uivantes", "Emily Brontë", 1847));
        livros.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866));
        livros.add(new Livro("Os Miseráveis", "Victor Hugo", 1862));
        livros.add(new Livro("O Grande Gatsby", "F. Scott Fitzgerald", 1925));

        System.out.println("Exibir a lista");
        livros.forEach(System.out::println);
        System.out.println("|---------------------------------------------------------------------------------------------|");

        System.out.println("Ordenando a lista por título");
        List<Livro> livrosOrdenadosPorTitulo = livros.stream().sorted(Livro::compareTo).toList();
        livrosOrdenadosPorTitulo.forEach(System.out::println);
        System.out.println("|---------------------------------------------------------------------------------------------|");

        System.out.println("Ordenação por ano lançamento");
        List<Livro> livrosOrdenadoPorAnoLancamento = new ArrayList<>(livros);
        Collections.sort(livrosOrdenadoPorAnoLancamento, new ComparatorPorAnoLancamentoLivro());
        livrosOrdenadoPorAnoLancamento.forEach(System.out::println);
        System.out.println("|---------------------------------------------------------------------------------------------|");
    }
}
