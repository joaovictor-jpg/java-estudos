package br.com.jota.desafio.fipe;

import br.com.jota.desafio.fipe.model.dto.DadosVeiculo;
import br.com.jota.desafio.fipe.model.dto.Modelo;
import br.com.jota.desafio.fipe.model.dto.Veiculo;
import br.com.jota.desafio.fipe.services.ObterDados;
import br.com.jota.desafio.fipe.services.Transforme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootApplication
public class FipeApplication implements CommandLineRunner {

    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private Transforme transforme = new Transforme();

    public static void main(String[] args) {
        SpringApplication.run(FipeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var menu = """
                    *** OPÇÕES ***
                    Carros
                    Motos
                    Caminhões
                
                    Digite uma opção para consulta:
                """;

        System.out.println(menu);
        var opcao = scanner.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = ObterDados.obterDadosVeidulos(endereco);

        var marcas = transforme.obterLista(json, DadosVeiculo.class);

        marcas.stream().sorted(Comparator.comparing(DadosVeiculo::codigo)).forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = scanner.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = ObterDados.obterDadosVeidulos(endereco);
        var modeloLista = transforme.obterDados(json, Modelo.class);

        System.out.println("\nModelos dessa marca:");
        modeloLista.modelos().stream().sorted(Comparator.comparing(DadosVeiculo::codigo)).forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro a ser buscado");
        var nomeVeiculo = scanner.nextLine();

        List<DadosVeiculo> modelosFiltrados = modeloLista.modelos()
                .stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados:");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("\nDigite por favor código do modelo para buscar os valores de avaliação:");
        var codigoModelo = scanner.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = ObterDados.obterDadosVeidulos(endereco);
        List<DadosVeiculo> anos = transforme.obterLista(json, DadosVeiculo.class);

        List<Veiculo> veiculos = new ArrayList<>();
        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = ObterDados.obterDadosVeidulos(enderecoAnos);
            Veiculo veiculo = transforme.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano:");
        veiculos.forEach(System.out::println);

    }
}
