package br.com.alura.biblioteca;

public class AppBiblioteca {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Maria");
        Livro livro = new Livro("Herry Potter", 1);
        Reserva reserva = new Reserva(pessoa, livro, 1);

        Thread reservaMaria = new Thread(reserva, "Maria");
        Thread reservaJoao = new Thread(reserva, "João");

        reservaMaria.start();
        reservaJoao.start();

        try {
            reservaMaria.join();
            reservaJoao.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
