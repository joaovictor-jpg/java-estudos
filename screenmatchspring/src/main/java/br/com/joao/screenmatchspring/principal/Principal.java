package br.com.joao.screenmatchspring.principal;

import br.com.joao.screenmatchspring.model.DadosEpisodio;
import br.com.joao.screenmatchspring.model.Episodio;
import br.com.joao.screenmatchspring.model.Serie;
import br.com.joao.screenmatchspring.model.Temporada;
import br.com.joao.screenmatchspring.service.ConverteDados;
import br.com.joao.screenmatchspring.service.ObterDadosSerce;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private final String ENDERECO = "http://www.omdbapi.com/?";
    private final String API_KEY = "apikey=7d410bf0&t=";
    private final String SEASON = "&season=";
    private ConverteDados converso = new ConverteDados();

    public void exibMenu() {
        System.out.println("Digite o nome da série a busca");
        var nomeSerie = scanner.nextLine();
        var json = ObterDadosSerce.obterDadosSerie(ENDERECO + API_KEY + nomeSerie.replace(" ", "+"));
        var serie = converso.obterDados(json, Serie.class);

        System.out.println(serie);

        List<Temporada> temporadas = new ArrayList<>();

        for (int i = 1; i < serie.totalTemporada(); i++) {
            var temporada = ObterDadosSerce.obterDadosSerie(ENDERECO + API_KEY + nomeSerie.replace(" ", "+") + SEASON + i);
            temporadas.add(converso.obterDados(temporada, Temporada.class));
        }

        System.out.println(temporadas);

//        List<Episodio> episodios = new ArrayList<>();
//
//        for (int i = 0; i < temporadas.size(); i++) {
//            episodios.addAll(temporadas.get(i).episodios());
//        }
//
//        episodios.forEach(episodio -> System.out.println(episodio.titulo()));

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
//                .collect(Collectors.toList());
                .toList();

        System.out.println("\nTop 5 episódio");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao)
                        .reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios()
                        .stream()
                        .map(d -> new Episodio(t.temporada(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("A partir de que ano deseja ver os episódios?");
        var ano = scanner.nextInt();
        scanner.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> {
                    System.out.println("Temporada " + e.getTemporada() + ", Episodio: " + e.getNumeroEpisodio() +
                            ", Data Lançamento: " + e.getDataLancamento().format(formatador));
                });
    }

}
