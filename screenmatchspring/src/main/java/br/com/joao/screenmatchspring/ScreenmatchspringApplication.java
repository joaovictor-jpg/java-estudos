package br.com.joao.screenmatchspring;

import br.com.joao.screenmatchspring.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchspringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchspringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal();
        principal.exibMenu();

//        var consumioTemporada = ObterDadosSerce.obterDadosSerie("https://www.omdbapi.com/?apikey=7d410bf0&t=the+boys&season=1");
//
//        var temporada = converso.obterDados(consumioTemporada, Temporada.class);
//        System.out.println(temporada);

//        List<Temporada> temporadas = new ArrayList<>();
//
//        for (int i = 1; i < serie.totalTemporada(); i++) {
//            var consumindoTemporada = ObterDadosSerce.obterDadosSerie("https://www.omdbapi.com/?apikey=7d410bf0&t=the+boys&season=" + i);
//            temporadas.add(converso.obterDados(consumindoTemporada, Temporada.class));
//        }
//
//        temporadas.forEach(System.out::println);
    }
}
