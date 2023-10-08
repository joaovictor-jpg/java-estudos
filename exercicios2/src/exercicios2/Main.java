package exercicios2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// int numero = sc.nextInt();
		// int numero2 = sc.nextInt();

		// Exercicio 1
		/*
		 * if (numero < 0) { System.out.println("NEGATIVO"); } else {
		 * System.out.println("NAO NEGATIVO"); }
		 */

		// Exercicio 2
		/*
		 * if (numero % 2 == 0) { System.out.println("PAR"); } else {
		 * System.out.println("IMPAR"); }
		 */

		// Exercício 3
		/*
		 * if(numero < b) { if(b % numero == 0) { System.out.println("Sao Multiplos"); }
		 * else { System.out.println("Nao sao Multiplos"); } } else { if(numero % b ==
		 * 0) { System.out.println("Sao Multiplos"); } else {
		 * System.out.println("Nao sao Multiplos"); } }
		 */

		// Exercicio 4

		// Exercicio 5
		
		// Exercicio 6
		double valor = sc.nextDouble();
		if (valor < 0 || valor > 100.0) {
			System.out.println("Fora de intervalo");
		} else if (valor <= 25.) {
			System.out.println("Intervalo [0,25]");
		} else if (valor <= 50.0) {
			System.out.println("Intervalo [25,50]");
		} else if(valor <= 70.0) {
			System.out.println("Intervalo [50,70]");
		} else {
			System.out.println("Intervalo [70,100]");
		}

		sc.close();
	}
}
