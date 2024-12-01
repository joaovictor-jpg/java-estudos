package modal;

public class Musica {
    public String titulo;
    public String artista;
    public int anoLancamento;
    public double avaliacao;
    public int numAvaliacoes;

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", avaliacao=" + avaliacao +
                ", numAvaliacoes=" + numAvaliacoes +
                '}';
    }
}
