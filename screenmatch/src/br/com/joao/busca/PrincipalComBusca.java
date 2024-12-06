package br.com.joao.busca;

import br.com.joao.screenmetch.excecao.ErroDeConversaoDeAnoException;
import br.com.joao.screenmetch.modelos.Titulo;
import br.com.joao.screenmetch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner readLine = new Scanner(System.in);

        var sair = "n";

        List<Titulo> listaDeFilmes = new ArrayList<>();

        while (!sair.equalsIgnoreCase("y")) {

            System.out.println("Digite um filme para buscar:");
            var busca = readLine.nextLine();

            String endereco = "http://www.omdbapi.com/?t=" + URLEncoder.encode(busca, "UTF-8") + "&apikey=7d410bf0";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());

                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
                TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println(meuTitulo);

                listaDeFilmes.add(meuTitulo);

                FileWriter fileWriter = new FileWriter("Filmes.txt");
                fileWriter.write(gson.toJson(listaDeFilmes));
                fileWriter.close();

                File file = new File("\\\\wsl.localhost\\Ubuntu\\home\\joao\\projetos\\java-estudos\\screenmatch\\Filmes.txt");
                FileReader reader = new FileReader(file);

                int data = reader.read();
                while (data != -1) {
                    System.out.println((char) data);
                    data = reader.read();
                }

                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    System.out.println(linha);
                }

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum error de argumento na busca, verifica o endereço");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Você deja sair: y/n");
                sair = readLine.nextLine();
            }
        }

    }
}
