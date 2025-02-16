package br.com.jota.primeiros_passos;

import br.com.jota.primeiros_passos.app.ConversorJson;
import br.com.jota.primeiros_passos.app.ViaCepResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class PrimeirosPassosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrimeirosPassosApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ConversorJson converso) throws Exception {
        return args -> {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/21240-470/json/"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ViaCepResponse viaCepResponse = converso.converter(response.body());

            System.out.println(viaCepResponse);
        };
    }

}
