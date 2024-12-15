package br.com.joao.screenmatchspring.principal;

import br.com.joao.screenmatchspring.model.DadosSerie;
import br.com.joao.screenmatchspring.model.Episodio;
import br.com.joao.screenmatchspring.model.Serie;
import br.com.joao.screenmatchspring.model.Temporada;
import br.com.joao.screenmatchspring.model.enums.Categoria;
import br.com.joao.screenmatchspring.respository.SerieRepository;
import br.com.joao.screenmatchspring.service.ConverteDados;
import br.com.joao.screenmatchspring.service.ObterDadosSerce;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private final String ENDERECO = "http://www.omdbapi.com/?";
    private final String API_KEY = "apikey=7d410bf0&t=";
    private final String SEASON = "&season=";
    private ConverteDados converso = new ConverteDados();
    private List<DadosSerie> dadosSerie = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();
    private Optional<Serie> serieOptional;

    private SerieRepository serieRepository;

    public Principal(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public void exibMenu() {
        menu();
//        System.out.println("Digite o nome da série a busca");
//        var nomeSerie = scanner.nextLine();
//        var json = ObterDadosSerce.obterDadosSerie(ENDERECO + API_KEY + nomeSerie.replace(" ", "+"));
//        var serie = converso.obterDados(json, Serie.class);
//
//        System.out.println(serie);
//
//        List<Temporada> temporadas = new ArrayList<>();
//
//        for (int i = 1; i < serie.totalTemporada(); i++) {
//            var temporada = ObterDadosSerce.obterDadosSerie(ENDERECO + API_KEY + nomeSerie.replace(" ", "+") + SEASON + i);
//            temporadas.add(converso.obterDados(temporada, Temporada.class));
//        }
//
//        System.out.println(temporadas);
//
////        List<Episodio> episodios = new ArrayList<>();
////
////        for (int i = 0; i < temporadas.size(); i++) {
////            episodios.addAll(temporadas.get(i).episodios());
////        }
////
////        episodios.forEach(episodio -> System.out.println(episodio.titulo()));
//
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
//
//        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream())
////                .collect(Collectors.toList());
//                .toList();
//
//        System.out.println("\nTop 10 episódio");
//        dadosEpisodios.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primeiro filtro: (N/A) " + e))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao)
//                        .reversed())
//                .limit(10)
//                .peek(e -> System.out.println("Ordenação: " + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Mapeamento: " + e))
//                .forEach(System.out::println);
//
//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios()
//                        .stream()
//                        .map(d -> new Episodio(t.temporada(), d)))
//                .collect(Collectors.toList());
//
//        episodios.forEach(System.out::println);
//
//        System.out.println("\nDigite um trecho do nome do episódio");
//        var trechoTitulo = scanner.nextLine();
//        Optional<Episodio> first = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
//                .findFirst();
//
//        if (first.isPresent()) {
//            System.out.println("Episódio encontrado");
//            System.out.println("Temporada: " + first.get().getTemporada());
//        } else {
//            System.out.println("Episódio não encontrado");
//        }
//
//        System.out.println(first);
//
//        System.out.println("A partir de que ano deseja ver os episódios?");
//        var ano = scanner.nextInt();
//        scanner.nextLine();
//
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> {
//                    System.out.println("Temporada " + e.getTemporada() + ", Episodio: " + e.getNumeroEpisodio() +
//                            ", Data Lançamento: " + e.getDataLancamento().format(formatador));
//                });
//
//        Map<Integer, Double> avaliacaoPorTemporada = episodios.stream()
//                .filter(e -> e.getAvaliacao() > 0.0)
//                .collect(Collectors.groupingBy(Episodio::getTemporada,
//                        Collectors.averagingDouble(Episodio::getAvaliacao)));
//
//        System.out.println(avaliacaoPorTemporada);
//
//        DoubleSummaryStatistics est = episodios.stream()
//                .filter(e -> e.getAvaliacao() > 0.0)
//                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
//
//        System.out.println("Média: " + est.getAverage());
//        System.out.println("Melhor episódio: " + est.getMax());
//        System.out.println("O pior episódio: " + est.getMin());
//        System.out.println("Quantidade: " + est.getCount());
    }

    private void buscarEpisodiosPorData() {
        buscarSeriePorTitulo();
        if (serieOptional.isPresent()) {
            System.out.println("Digiti o limite de lançamento");
            var anoLançamento = scanner.nextInt();
            scanner.nextLine();
            List<Episodio> episodios = serieRepository.episodiosPorSerieEAno(serieOptional.get(), anoLançamento);
            episodios.forEach(e ->
                    System.out.printf("Série: %s Temporada %s - Episódio %s - Título: %s - avaliação: %s - Ano de Lançamento: %s\n",
                            e.getSerie().getTitulo(), e.getTemporada(),
                            e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao(), e.getDataLancamento()));
        }
    }

    private void topEpisodiosPorSerie() {
        buscarSeriePorTitulo();

        if (serieOptional.isPresent()) {
            Serie serie = serieOptional.get();
            List<Episodio> episodios = serieRepository.TopEpisodiosPorSerie(serie);
            episodios.forEach(e ->
                    System.out.printf("Série: %s Temporada %s - Episódio %s - Título: %s - avaliação: %s\n",
                            e.getSerie().getTitulo(), e.getTemporada(),
                            e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
        } else {
            System.out.println("Série não encontrado");
        }
    }

    private void buscarEpisodioPorTrecho() {
        System.out.println("Qual é o trecho do episódio");
        var trechoEpisodio = scanner.nextLine();
        List<Episodio> episodiosEncontrados = serieRepository.episodiosPorTrecho(trechoEpisodio);

        episodiosEncontrados.forEach(e ->
                System.out.printf("Série: %s Temporada %s - Episódio %s - Título: %s - avaliação: %s\n",
                        e.getSerie().getTitulo(), e.getTemporada(),
                        e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
    }

    private void buscarPorTamanhoDeTemporada() {
        System.out.println("Quantas temporadas? ");
        int numeroDeTemporadas = scanner.nextInt();
        System.out.println("Mínimo de avaliação aceita: ");
        double avaliacao = scanner.nextDouble();

        List<Serie> serieList = serieRepository.seriesPorTemporadaEAvaliacao(numeroDeTemporadas, avaliacao);

        serieList.forEach(System.out::println);
    }

    private void bustaTopCincoSeries() {
        Optional<List<Serie>> serieOptional = serieRepository.findTop5ByOrderByAvaliacaoDesc();
        serieOptional.stream().forEach(
                sL -> sL.forEach(System.out::println)
        );
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha uma série pelo nome: ");
        var nomeSerie = scanner.nextLine();
        this.serieOptional = serieRepository.findByTituloContainingIgnoreCase(nomeSerie);

        if (serieOptional.isPresent()) {
            System.out.println("Dados da série: " + serieOptional.get());
        } else {
            System.out.println("Série não encontrado");
        }
    }

    private void buscarSeriePorAutores() {
        System.out.println("Entre com o nome do autor");
        var nomeAutor = scanner.nextLine();
        System.out.println("Avaliações a partir de que valor? ");
        var avaliacao = scanner.nextDouble();

        Optional<List<Serie>> serieOptinal = serieRepository.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAutor, avaliacao);

        if (serieOptinal.isPresent()) {
            System.out.println("Série em que " + nomeAutor + " trabalhou:");
            serieOptinal.stream()
                    .forEach(s -> {
                        s.forEach(System.out::println);
                    });
        } else {
            System.out.println("Série não encontrado");
        }
    }

    private void buscarSeriePorCategoria() {
        System.out.println("Digite a categoria");
        var categoria = scanner.nextLine();
        Categoria categoria1 = Categoria.fromStringPtBr(categoria);
        Optional<List<Serie>> seriesOptional = serieRepository.findByGenero(categoria1);

        System.out.println("Série da categoria: " + categoria);

        seriesOptional.ifPresent(
                e -> e.forEach(System.out::println)
        );
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
//        dadosSerie.add(dados);
        serieRepository.save(new Serie(dados));
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = scanner.nextLine();
        var json = ObterDadosSerce.obterDadosSerie(ENDERECO + API_KEY + nomeSerie.replace(" ", "+"));
        DadosSerie dados = converso.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void listarSeriesBuscaDas() {
        this.series = serieRepository.findAll();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarEpisodioPorSerie() {
        listarSeriesBuscaDas();

        System.out.println("Entre com o título da serie");
        var nomeSerie = scanner.nextLine();

        Optional<Serie> serieOption = this.series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nomeSerie.toLowerCase()))
                .findFirst();

        if (serieOption.isPresent()) {
            List<Temporada> temporadas = new ArrayList<>();

            var serie = serieOption.get();

            for (int i = 1; i < serie.getTotalTemporada(); i++) {
                var json = ObterDadosSerce.obterDadosSerie(ENDERECO + API_KEY + serie.getTitulo()
                        .replace(" ", "+") + SEASON + i);
                Temporada dadosTempora = converso.obterDados(json, Temporada.class);
                temporadas.add(dadosTempora);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios()
                            .stream().map(e -> new Episodio(d.temporada(), e)))
                    .collect(Collectors.toList());
            serie.setEpisodios(episodios);
            serieRepository.save(serie);
        } else {
            System.out.println("Série não encontrada!");
        }

    }

    private void menu() {
        var opcoes = -1;
        while (opcoes != 0) {
            var menu = """
                    1 - Buscar série
                    2 - Buscar episódio
                    3 - Listar séries buscadas
                    4 - Buscar série por título
                    5 - Buscar série por autor
                    6 - Top 5 favoritas
                    7 - Buscar Por categoria
                    8 - Minimo de Temporadas
                    9 - Buscar episódio port trecho
                    10 - Top 5 episódios
                    11 - Buscar episódio por data
                    0 - Sair
                    """;

            System.out.println(menu);
            opcoes = scanner.nextInt();
            scanner.nextLine();

            switch (opcoes) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscaDas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriePorAutores();
                    break;
                case 6:
                    bustaTopCincoSeries();
                    break;
                case 7:
                    buscarSeriePorCategoria();
                    break;
                case 8:
                    buscarPorTamanhoDeTemporada();
                    break;
                case 9:
                    buscarEpisodioPorTrecho();
                    break;
                case 10:
                    topEpisodiosPorSerie();
                    break;
                case 11:
                    buscarEpisodiosPorData();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

}
