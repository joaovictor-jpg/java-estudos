package br.com.joao.screenmatchspring;

import br.com.joao.screenmatchspring.service.ObterDadosSerce;
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
        var consumeApi = ObterDadosSerce.obterDados("http://www.omdbapi.com/?apikey=7d410bf0&t=the+boys");
        System.out.println(consumeApi);
    }
}
