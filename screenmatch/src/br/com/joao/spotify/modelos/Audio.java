package br.com.joao.spotify.modelos;

public abstract class Audio {
    private String titulo;
    private int totalReproducoes;
    private int totalDeCurtidas;
    private int classificacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void curtida() {
        this.totalDeCurtidas++;
    }
    public void reproduzir() {
        this.totalReproducoes++;
    }
}
