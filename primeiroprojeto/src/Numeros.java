import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Entre com um número");
        int numero = read.nextInt();

        if(numero >= 0) {
            System.out.println("Número positivo");
        } else {
            System.out.println("Número negativo");
        }

        System.out.println("Entre com o primeiro número");
        int numeroInteiro1 = read.nextInt();
        System.out.println("Entre com o segundo número");
        int numeroInteiro2 = read.nextInt();

        if(numeroInteiro1 == numeroInteiro2) {
            System.out.println("São iguais");
        } else if (numeroInteiro1 < numeroInteiro2) {
            System.out.println("O segundo é maior");
        } else if (numeroInteiro1 > numeroInteiro2) {
            System.out.println("O primeiro é maior");
        }

        System.out.println("Entre com um número para tabuada");
        int numeroTabuada = read.nextInt();

        for(int i = 1; i <= 10; i++) {
            System.out.println(numeroTabuada * i);
        }

        System.out.println("Entre com um número Inteiro ou Par");
        int numeroInteiroPar = read.nextInt();

        if (numero % 2 == 0) {
            System.out.println("número par");
        } else {
            System.out.println("número impar");
        }

        int escolha = 0;

        while (escolha != 3) {
            System.out.println("-----Menu-----");
            System.out.println("1. Calcular área do quadrado");
            System.out.println("2. Calcular área do círculo");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = read.nextInt();

            if (escolha == 1) {
                System.out.print("Digite o lado do quadrado: ");
                double lado = read.nextDouble();
                double areaQuadrado = lado * lado;
                System.out.println("Área do quadrado: " + areaQuadrado);
            } else if (escolha == 2) {
                System.out.print("Digite o raio do círculo: ");
                double raio = read.nextDouble();
                double areaCirculo = 3.14 * raio * raio;
                System.out.println("Área do círculo: " + areaCirculo);
            } else if (escolha == 3) {
                System.out.println("Programa encerrado.");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.print("Digite um número: ");
        int numeroFatorial = read.nextInt();

        int fatorial = 1;

        for (int i = 1; i <= numeroFatorial; i++) {
            fatorial *= i;
        }

        System.out.println("O fatorial de " + numero + " é: " + fatorial);
    }
}
