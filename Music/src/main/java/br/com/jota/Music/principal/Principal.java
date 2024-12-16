package br.com.jota.Music.principal;

import br.com.jota.Music.model.Artista;
import br.com.jota.Music.model.Music;
import br.com.jota.Music.model.enums.TipoArtista;
import br.com.jota.Music.repository.ArtistaRepository;
import br.com.jota.Music.services.ConsultaGemini;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository artistaRepository;
    private String openAIToken;

    public Principal(ArtistaRepository artistaRepository, String openAIToken) {
        this.artistaRepository = artistaRepository;
        this.openAIToken = openAIToken;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                    
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void pesquisarDadosDoArtista() {
        System.out.println("Pesquisar dados sobre qual artista:");
        var nome = leitura.nextLine();

        var resposta = ConsultaGemini.obterTraducao(nome, openAIToken);
        System.out.println(resposta.trim());
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Escreva nome do artista:");
        var nome = leitura.nextLine();

        List<Music> musicList = artistaRepository.buscarMusicaPorArtista(nome);

        musicList.forEach(System.out::println);
    }

    private void listarMusicas() {

        List<Artista> artistas = artistaRepository.findAll();

        artistas.forEach(a -> a.getMusic().forEach(System.out::println));

    }

    private void cadastrarMusicas() {
        System.out.println("Informe o nome desse artista:");
        var nome = leitura.nextLine();

        Optional<Artista> artistaOptional = artistaRepository.findByNameContainingIgnoreCase(nome);

        if (artistaOptional.isPresent()) {
            System.out.println("Informe o titulo da musica:");
            var nomeMusica = leitura.nextLine();

            Music music = new Music(nomeMusica);
            music.setArtista(artistaOptional.get());
            artistaOptional.get().getMusic().add(music);

            artistaRepository.save(artistaOptional.get());
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void cadastrarArtistas() {

        var cadastrarNovo = "s";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome desse artista:");
            var nome = leitura.nextLine();
            System.out.println("Informe o tipo desse artista:(solo, dupla ou banda)");
            var tipo = leitura.nextLine();

            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());

            Artista artista = new Artista(nome, tipoArtista);

            artistaRepository.save(artista);

            System.out.println("Cadastrar novo artista (S/N):");
            cadastrarNovo = leitura.nextLine();
        }
    }
}
