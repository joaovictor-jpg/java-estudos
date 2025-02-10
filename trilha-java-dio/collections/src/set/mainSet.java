package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import set.entities.Aluno;
import set.utils.OrdenarAlunosPorNota;

public class mainSet {
    /*
     * public static void main(String[] args) {
     * Set<Convidado> convidados = new HashSet<>();
     * convidados.add(new Convidado("Ana", 101));
     * convidados.add(new Convidado("Carla", 103));
     * convidados.add(new Convidado("Elisa", 105));
     * convidados.add(new Convidado("Diego", 104));
     * convidados.add(new Convidado("Bruno", 102));
     * 
     * System.out.println("Exibir lista de convidados com set");
     * convidados.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Removendo convidado");
     * Set<Convidado> listaDeConvidadoAtualizada = convidados.stream().filter(c ->
     * c.getCodigo() != 102)
     * .collect(Collectors.toSet());
     * listaDeConvidadoAtualizada.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Quantos convidados têm na lista");
     * Integer totalDeConvidados = listaDeConvidadoAtualizada.size();
     * System.out.println(totalDeConvidados);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * Set<String> palavras = new HashSet<>(Set.of(
     * "casa", "árvore", "computador", "livro", "carro",
     * "escola", "telefone", "música", "viagem", "alegria", "amigo", "felicidade",
     * "noite", "dia", "sol", "lua", "chuva"));
     * 
     * // Exibir as palavras únicas
     * System.out.println("Palavras únicas no Set:");
     * palavras.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Removendo palavra");
     * Set<String> listaDePalavrasAtualizada = palavras.stream().filter(p ->
     * !p.equalsIgnoreCase("música")).collect(Collectors.toSet());
     * listaDePalavrasAtualizada.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * }
     */

    /*
     * public static void main(String[] args) {
     * Set<Contato> contatos = new HashSet<>();
     * 
     * contatos.add(new Contato("Ana", "9999-1111"));
     * contatos.add(new Contato("Bruno", "9999-2222"));
     * contatos.add(new Contato("Carla", "9999-3333"));
     * contatos.add(new Contato("Diego", "9999-4444"));
     * contatos.add(new Contato("Ana", "9999-5555"));
     * contatos.add(new Contato("Elisa", "9999-1111"));
     * 
     * System.out.println("Exibir contatos");
     * contatos.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Pesquisar por nome");
     * Set<Contato> listaDeContatosPorNome = contatos.stream().filter(c ->
     * c.getNome().startWith("Ana"))
     * .collect(Collectors.toSet());
     * listaDeContatosPorNome.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * Set<Contato> listaDeContatoAtualizada = contatos.stream().map(c -> {
     * if (c.getNome().equals("Diego")) {
     * c.setTelefone("(21)9999-2222");
     * }
     * return c;
     * }).collect(Collectors.toSet());
     * 
     * listaDeContatoAtualizada.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * 
     * Set<Tarefa> tarefas = new HashSet<>();
     * 
     * for (int i = 1; i <= 25; i++) {
     * tarefas.add(new Tarefa("Executar tarefa número " + i));
     * }
     * 
     * System.out.println("Lista de tarefas");
     * tarefas.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Remover uma terafa");
     * Set<Tarefa> tarefasAtualizadas = tarefas.stream().filter(t ->
     * !t.getDescricao().equalsIgnoreCase("Executar tarefa número 17")).collect(
     * Collectors.toSet());
     * tarefasAtualizadas.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Total de tarefas");
     * Integer totalTarefas = tarefasAtualizadas.size();
     * System.out.println(totalTarefas);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Marca que uma tarefa foi concluida");
     * tarefasAtualizadas = tarefasAtualizadas.stream().map(t -> {
     * if (t.getDescricao().equalsIgnoreCase("Executar tarefa número 16")) {
     * t.setConcluida(true);
     * }
     * return t;
     * }).collect(Collectors.toSet());
     * tarefasAtualizadas = tarefasAtualizadas.stream().map(t -> {
     * if (t.getDescricao().equalsIgnoreCase("Executar tarefa número 16")) {
     * t.setConcluida(true);
     * }
     * return t;
     * }).collect(Collectors.toSet());
     * tarefasAtualizadas = tarefasAtualizadas.stream().map(t -> {
     * if (t.getDescricao().equalsIgnoreCase("Executar tarefa número 20")) {
     * t.setConcluida(true);
     * }
     * return t;
     * }).collect(Collectors.toSet());
     * tarefasAtualizadas = tarefasAtualizadas.stream().map(t -> {
     * if (t.getDescricao().equalsIgnoreCase("Executar tarefa número 18")) {
     * t.setConcluida(true);
     * }
     * return t;
     * }).collect(Collectors.toSet());
     * tarefasAtualizadas.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * 
     * System.out.println("Marca que uma tarefa foi concluida");
     * tarefasAtualizadas = tarefasAtualizadas.stream().map(t -> {
     * if (t.getDescricao().equalsIgnoreCase("Executar tarefa número 3")) {
     * t.setConcluida(true);
     * }
     * return t;
     * }).collect(Collectors.toSet());
     * tarefasAtualizadas.forEach(System.out::println);
     * tarefasAtualizadas = tarefasAtualizadas.stream().map(t -> {
     * if (t.getDescricao().equalsIgnoreCase("Executar tarefa número 3")) {
     * t.setConcluida(false);
     * }
     * return t;
     * }).collect(Collectors.toSet());
     * tarefasAtualizadas.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * 
     * System.out.println("Obter lista de tarefas concluidas");
     * Set<Tarefa> tarefasConcluidas =
     * tarefasAtualizadas.stream().filter(Tarefa::getConcluida).collect(Collectors.
     * toSet());
     * tarefasConcluidas.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Obter lista de tarefas não concluidas");
     * Set<Tarefa> tarefasSemConcluir = tarefasAtualizadas.stream().filter(tarefa ->
     * !tarefa.getConcluida()).collect(Collectors.toSet());
     * tarefasSemConcluir.forEach(System.out::println);
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * 
     * System.out.println("Limpar lista");
     * tarefas.clear();
     * tarefasAtualizadas.clear();
     * tarefasConcluidas.clear();
     * tarefasSemConcluir.clear();
     * System.out.println(
     * "|--------------------------------------------------------------------------|"
     * );
     * }
     */

    public static void main(String[] args) {
        /*Set<Produto> produtos = new HashSet<>();

        produtos.add(new Produto("Notebook", 101, 3500.00, 5));
        produtos.add(new Produto("Mouse", 102, 150.00, 10));
        produtos.add(new Produto("Teclado", 103, 200.00, 8));
        produtos.add(new Produto("Monitor", 104, 1200.00, 3));
        produtos.add(new Produto("Mousepad", 105, 50.00, 15));
        produtos.add(new Produto("Notebook", 101, 3700.00, 2));

        System.out.println("Lista Produtos");
        produtos.forEach(System.out::println);
        System.out.println("|--------------------------------------------------------------------------|");

        System.out.println("Ordena por nome");
        Set<Produto> produtosOrdenadoPorNome = produtos.stream().sorted(Produto::compareTo).collect(Collectors.toSet());
        produtosOrdenadoPorNome.forEach(System.out::println);
        System.out.println("|--------------------------------------------------------------------------|");

        System.out.println("Ordena pro preço");
        Set<Produto> produtosOrdenadorPorPreco = new TreeSet<>(new OrdenarProdutoPorPreco());
        produtosOrdenadorPorPreco.addAll(produtos);
        produtosOrdenadorPorPreco.forEach(System.out::println);
        System.out.println("|--------------------------------------------------------------------------|");*/

        Set<Aluno> alunos = new HashSet<>();

        alunos.add(new Aluno("João", 101, 8.5));
        alunos.add(new Aluno("Maria", 102, 9.2));
        alunos.add(new Aluno("Pedro", 103, 7.8));
        alunos.add(new Aluno("Ana", 104, 8.9));
        alunos.add(new Aluno("Carlos", 105, 6.5));
        alunos.add(new Aluno("João", 101, 7.5));

        System.out.println("Exibir lista de alunos");
        alunos.forEach(System.out::println);
        System.out.println("|--------------------------------------------------------------------------|");

        System.out.println("Ordenando lista de alunos por nome");
        Set<Aluno> alunosOrdenadoPorNome = alunos.stream().sorted(Aluno::compareTo).collect(Collectors.toSet());
        alunosOrdenadoPorNome.forEach(System.out::println);
        System.out.println("|--------------------------------------------------------------------------|");

        System.out.println("Ordernar lista de alunos por notas");
        Set<Aluno> alunosOrdenadosPorNota = new TreeSet<>(new OrdenarAlunosPorNota());
        alunosOrdenadosPorNota.addAll(alunos);
        alunosOrdenadosPorNota.forEach(System.out::println);
        System.out.println("|--------------------------------------------------------------------------|");
    }
}
