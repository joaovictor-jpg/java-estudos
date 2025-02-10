package list;

public class MainList {
    public static void main(String[] args) {
        // List<Tarefa> tarefas = new ArrayList<>();

        // tarefas.add(new Tarefa("Estudar Java"));
        // tarefas.add(new Tarefa("Estudar SQL"));
        // tarefas.add(new Tarefa("Estudar DML"));
        // tarefas.add(new Tarefa("Estudar Postgres"));
        // tarefas.add(new Tarefa("Estudar Microsservices"));
        // tarefas.add(new Tarefa("Estudar JavaScript"));
        // tarefas.add(new Tarefa("Estudar React"));
        // tarefas.add(new Tarefa("Estudar Angular"));

        // System.out.println("Lista de Tarefas");
        // tarefas.forEach(System.out::println);

        // System.out.println("|---------------------------------------------------------------------------------------------|");

        // System.out.println("Removendo da lista");
        // List<Tarefa> ListaDeTarefasAtualizada = tarefas.stream().filter(t ->
        // !t.getDescricao().equalsIgnoreCase("Estudar React")).toList();
        // ListaDeTarefasAtualizada.forEach(System.out::println);

        // System.out.println("|---------------------------------------------------------------------------------------------|");
        // System.out.println("Tamanho da lista " + tarefas.size());

        // System.out.println("Exercícios 1");
        // List<Item> carrinhoDeCompras = new ArrayList<>();

        // carrinhoDeCompras.add(new Item("Mause", 25.50, 10));
        // carrinhoDeCompras.add(new Item("Teclado", 17.30, 50));
        // carrinhoDeCompras.add(new Item("Monitor", 450.50, 7));
        // carrinhoDeCompras.add(new Item("Gabineite", 120.00, 25));
        // carrinhoDeCompras.add(new Item("Ryze 3", 500.00, 4));
        // carrinhoDeCompras.add(new Item("Memoria RAN", 250.70, 150));
        // carrinhoDeCompras.add(new Item("HD", 100.00, 45));
        // carrinhoDeCompras.add(new Item("Cooler", 50.35, 60));
        // carrinhoDeCompras.add(new Item("SSD", 230.00, 20));

        // System.out.println(
        // "|---------------------------------------------------------------------------------------------|");
        // System.out.println("Itens Carrinho:");
        // carrinhoDeCompras.forEach(System.out::println);

        // System.out.println(
        // "|---------------------------------------------------------------------------------------------|");
        // System.out.println("Remover item do carrinho");
        // List<Item> carrinhoAtualizado = carrinhoDeCompras.stream().filter(c ->
        // !c.getNome().equalsIgnoreCase("SSD"))
        // .toList();
        // carrinhoAtualizado.forEach(System.out::println);

        // System.out.println(
        // "|---------------------------------------------------------------------------------------------|");
        // System.out.println("Calcular valor total");
        // Double total = carrinhoAtualizado.stream().reduce(0.0,
        // (acc, item) -> acc + (item.getPreco() * item.getQuantidade()), Double::sum);
        // Double total = carrinhoAtualizado.stream().mapToDouble(item ->
        // item.getPreco() * item.getQuantidade()).sum();
        // System.out.println(total);

        // System.out.println(
        // "|---------------------------------------------------------------------------------------------|");
        // carrinhoAtualizado.forEach(System.out::println);
    }
}
