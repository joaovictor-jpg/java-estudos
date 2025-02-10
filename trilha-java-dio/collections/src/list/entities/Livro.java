package list.entities;

public class Livro implements Comparable<Livro> {

    private String titulo;
    private String autor;
    private Integer anoDeLancamento;

    public Livro(String titulo, String autor, Integer anoDeLancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoDeLancamento=" + anoDeLancamento + "]";
    }

    @Override
    public int compareTo(Livro livro) {
        return this.titulo.compareTo(livro.getTitulo());
    }

}
