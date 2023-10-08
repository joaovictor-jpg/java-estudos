package exercicios;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * Exercício 1 int valorDaSoma = sc.nextInt(); int valorDaSoma2 = sc.nextInt();
		 * int resultado = valorDaSoma + valorDaSoma2;
		 * 
		 * System.out.printf("Soma: %d", resultado);
		 */

		/*
		 * Exercicio 2 double pi = 3.14159; double raio = sc.nextDouble(); double
		 * resultado = pi * Math.pow(raio, 2.0);
		 * 
		 * System.out.printf("A= %.4f", resultado);
		 */

		/*
		 * Exercicio 3 int a, b, c, d; a = sc.nextInt(); b = sc.nextInt(); c =
		 * sc.nextInt(); d = sc.nextInt(); int resultado = (a * b - c * d);
		 * System.out.println("DIFERENCA: " + resultado);
		 */

		/*
		 * Exercicio 4 int numeroFuncionario, horasTrabalhada; double
		 * valorHorasTrabalhadas, resultado;
		 * 
		 * numeroFuncionario = sc.nextInt(); horasTrabalhada = sc.nextInt();
		 * valorHorasTrabalhadas = sc.nextDouble();
		 * 
		 * resultado = horasTrabalhada * valorHorasTrabalhadas;
		 * 
		 * System.out.println("Numero: " + numeroFuncionario);
		 * System.out.println("Salary = U$ " + resultado);
		 */

		/*
		 * int codigoDaPeca1, codigoDaPeca2, quantidades1, quantidades2; double preco1,
		 * preco2, resultado;
		 */

		/*
		 * Exercicio 5 codigoDaPeca1 = sc.nextInt(); quantidades1 = sc.nextInt(); preco1
		 * = sc.nextDouble();
		 * 
		 * codigoDaPeca2 = sc.nextInt(); quantidades2 = sc.nextInt(); preco2 =
		 * sc.nextDouble();
		 * 
		 * resultado = (quantidades1 * preco1) + (quantidades2 * preco2);
		 * 
		 * System.out.printf("VALOR A PAGAR: R$ %.2f", resultado);
		 */

		double a, b, c;
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();

		System.out.printf("TRIANGULO: %.3f%n", (a * c / 2.0));
		System.out.printf("CIRCULO: %.3f%n", (3.14159 * Math.pow(c, 2.0)));
		System.out.printf("TRAPEZIO: %.3f%n", ((a + b) * c / 2.0));
		System.out.printf("QUADRADO: %.3f%n", (Math.pow(b, 2.0)));
		System.out.printf("RETANGULO: %.3f%n", (a * b));

		sc.close();
	}

}
