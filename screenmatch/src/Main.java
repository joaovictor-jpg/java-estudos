import br.com.joao.screenmetch.modelos.Filme;
import br.com.joao.spotify.modelos.Audio;
import br.com.joao.spotify.modelos.Musica;
import br.com.joao.spotify.modelos.PodCast;

public class Main {
    public static void main(String[] args) {
        Audio audioPodCast = new PodCast();
        audioPodCast.setTitulo("PostTech");
        audioPodCast.curtida();
        audioPodCast.reproduzir();

        Musica musica = new Musica();
        musica.setTitulo("Bolier room");
        musica.setArtista("DJ Ramon");
        musica.setGenero("Funk");
        musica.som();
    }
}