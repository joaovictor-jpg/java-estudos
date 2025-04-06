package br.com.alura.biblioteca;

public class Reserva implements Runnable {

    private Pessoa pessoa;
    private  Livro livro;
    private Integer quantidade;

    public Reserva(Pessoa pessoa, Livro livro, Integer quantidade) {
        this.pessoa = pessoa;
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public synchronized void reserva() {
        System.out.println("Iniciando reserva");
        if (livro.getQuntidadeDeLivros().compareTo(quantidade) >= 0) {
            System.out.println("Reserva efetuada com sucesso! Aproveite a leitura, " + Thread.currentThread().getName());
            livro.setQuntidadeDeLivros(quantidade);
        } else {
            System.out.println("O livro já foi reservado, " + Thread.currentThread().getName());
        }

        System.out.println("Reservas finalizadas!");
    }

    @Override
    public void run() {
        reserva();
    }
}
