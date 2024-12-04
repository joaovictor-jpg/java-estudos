package modal.googlebooks;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class GetGoogleBooks {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);

        System.out.println("Entre com o nome do livro");
        var book = read.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + book))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        System.out.println("| ---------------------------------------------------------------------------------- |");

        System.out.println("IDs das moedas, separados por vírgula se estiver consultando mais de 1 moeda.");
        var moedaCoin = read.nextLine();
        System.out.println("moeda de destino das moedas, separadas por vírgulas se estiver consultando mais de 1 moeda.");
        var moedaDeDestiono = read.nextLine();

        final String key = "CG-RKNxW6nRNrKbACL5NtsrnV2d";

        String uri = "https://api.coingecko.com/api/v3/simple/price?ids=" + moedaCoin + "&vs_currencies=" + moedaDeDestiono + "&x_cg_demo_api_key=" + key;

        HttpClient clientMoeda = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<String> res = clientMoeda.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println(res.body());

        System.out.println("| ---------------------------------------------------------------------------------- |");

        System.out.println("Entre com o nome do prato:");
        var prato = read.nextLine();

        HttpClient restaurante = HttpClient.newHttpClient();
        HttpRequest reqRestaurante = HttpRequest.newBuilder().uri(URI.create("https://www.themealdb.com/api/json/v1/1/search.php?s=" + prato)).build();
        HttpResponse<String> resPrato = restaurante.send(reqRestaurante, HttpResponse.BodyHandlers.ofString());

        System.out.println(resPrato.body());
    }
}
