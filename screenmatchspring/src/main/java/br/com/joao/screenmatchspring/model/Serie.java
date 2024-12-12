package br.com.joao.screenmatchspring.model;

import br.com.joao.screenmatchspring.model.enums.Categoria;

import java.net.URI;
import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporada;
    private Double avaliacao;
    private URI poster;
    private String sinopse;
    private String Atores;
    private Categoria genero;

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporada = dadosSerie.totalTemporada();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.poster = dadosSerie.poster();
        this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse().trim());
        this.Atores = dadosSerie.atores();
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporada() {
        return totalTemporada;
    }

    public void setTotalTemporada(Integer totalTemporada) {
        this.totalTemporada = totalTemporada;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public URI getPoster() {
        return poster;
    }

    public void setPoster(URI poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAtores() {
        return Atores;
    }

    public void setAtores(String atores) {
        Atores = atores;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Serie = { " +
                "titulo='" + titulo + '\'' +
                ", totalTemporada=" + totalTemporada +
                ", avaliacao=" + avaliacao +
                ", poster=" + poster +
                ", sinopse='" + sinopse + '\'' +
                ", Atores='" + Atores + '\'' +
                ", genero=" + genero +
                " }";
    }
}
