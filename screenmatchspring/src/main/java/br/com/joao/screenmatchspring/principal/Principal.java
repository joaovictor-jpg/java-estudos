package br.com.joao.screenmatchspring.principal;

import br.com.joao.screenmatchspring.model.DadosEpisodio;
import br.com.joao.screenmatchspring.model.Episodio;
import br.com.joao.screenmatchspring.model.Serie;
import br.com.joao.screenmatchspring.model.Temporada;
import br.com.joao.screenmatchspring.service.ConverteDados;
import br.com.joao.screenmatchspring.service.ObterDadosSerce;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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

        System.out.println("\nTop 10 episódio");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("Primeiro filtro: (N/A) " + e))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao)
                        .reversed())
                .limit(10)
                .peek(e -> System.out.println("Ordenação: " + e))
                .map(e -> e.titulo().toUpperCase())
                .peek(e -> System.out.println("Mapeamento: " + e))
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios()
                        .stream()
                        .map(d -> new Episodio(t.temporada(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do episódio");
        var trechoTitulo = scanner.nextLine();
        Optional<Episodio> first = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .findFirst();

        if (first.isPresent()) {
            System.out.println("Episódio encontrado");
            System.out.println("Temporada: " + first.get().getTemporada());
        } else {
            System.out.println("Episódio não encontrado");
        }

        System.out.println(first);

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

        Map<Integer, Double> avaliacaoPorTemporada = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));

        System.out.println(avaliacaoPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.println("Média: " + est.getAverage());
        System.out.println("Melhor episódio: " + est.getMax());
        System.out.println("O pior episódio: " + est.getMin());
        System.out.println("Quantidade: " + est.getCount());
    }

}
