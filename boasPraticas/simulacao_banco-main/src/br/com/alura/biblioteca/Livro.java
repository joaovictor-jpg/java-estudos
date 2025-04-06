package br.com.alura.biblioteca;

public class Livro {

    private String titulo;
    private Integer quntidadeDeLivros;

    public Livro(String titulo, Integer quntidadeDeLivros) {
        this.titulo = titulo;
        this.quntidadeDeLivros = quntidadeDeLivros;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getQuntidadeDeLivros() {
        return quntidadeDeLivros;
    }

    public void setQuntidadeDeLivros(Integer quntidadeDeLivros) {
        this.quntidadeDeLivros = this.quntidadeDeLivros - quntidadeDeLivros;
    }
}
