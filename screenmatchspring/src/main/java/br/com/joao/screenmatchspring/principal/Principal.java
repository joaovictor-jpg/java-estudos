package br.com.joao.screenmatchspring.principal;

import br.com.joao.screenmatchspring.model.Episodio;
import br.com.joao.screenmatchspring.model.Serie;
import br.com.joao.screenmatchspring.model.Temporada;
import br.com.joao.screenmatchspring.service.ConverteDados;
import br.com.joao.screenmatchspring.service.ObterDadosSerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    }

}
