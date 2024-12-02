package br.com.joao.lista;

import br.com.joao.screenmetch.modelos.Filme;
import br.com.joao.screenmetch.modelos.Serie;
import br.com.joao.screenmetch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O Podero chefão", 1970);
        filme1.avalia(9);
        Filme filme2 = new Filme("Avatar", 2023);
        filme2.avalia(7);
        var filme3 = new Filme("Dogville", 2003);
        filme3.avalia(6);
        Serie lost = new Serie("Lost", 2000);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(lost);

        lista.forEach(System.out::println);

        for(Titulo item: lista) {
            if(item instanceof Filme filme) {
                System.out.println(filme.getClassificacao());
            }
        }

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDelancamento));
        System.out.println(lista);
    }
}
