import java.util.Scanner;

import error.ParametrosInvalidosException;

public class Contador {
    public static void main(String[] args) {
        Scanner readLine = new Scanner(System.in);

        System.out.print("Entre com o primeiro valor ");
        int primeiroValor = readLine.nextInt();

        readLine.nextLine();

        System.out.print("Entre com o segundo valor (o segundo valor deve ser maior que o primeiro): ");
        int segundoValor = readLine.nextInt();

        readLine.nextLine();

        try {
            fazerCalculo(primeiroValor, segundoValor);
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fazerCalculo(int primeiroValor, int segundoValor) throws ParametrosInvalidosException {
        if (primeiroValor > segundoValor) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int total = segundoValor - primeiroValor;

        imprirNumeros(total);
    }

    private static void imprirNumeros(int total) {
        for (int i = 0; i < total; i++) {
            System.out.println("Imprimindo o número " + (i + 1));
        }
    }
}
