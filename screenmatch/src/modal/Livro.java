package modal;

import modal.interfaces.Calculavel;

public class Livro extends Produto implements Calculavel {
    private String titulo;
    private String autor;

    public Livro(String nome, double nota1, double nota2, double nota3, double preco) {
        super(nome, nota1, nota2, nota3, preco);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
    }

    public double calcularPrecoFinal() {
        return preco * 0.9;
    }
}
