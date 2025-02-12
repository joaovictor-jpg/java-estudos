package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        System.out.println("Mostrar a lista na orderm");
        numeros.sort(Integer::compareTo);
        numeros.forEach(System.out::println);
        System.out.println("|-----------------------------------------------------------------|");
    }
}