package application;

import java.util.PrimitiveIterator;
import java.util.Scanner;

import entities.Produto;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
//
//		double[] vetor = new double[n];
//
//		for (int i = 0; i < n; i++) {
//			vetor[i] = sc.nextDouble();
//		}
//
//		double sum = 0.0;
//		for (int i = 0; i < n; i++) {
//			sum += vetor[i];
//		}
//		
//		double avg = sum / n;

//		System.out.printf("Average Height: %.2f", avg);
		
		Produto[] vetor = new Produto[n];
		
		for(int i = 0; i < vetor.length; i++) {
			String nome = sc.next();
			double preco = sc.nextDouble();
			vetor[i] = new Produto(nome, preco);
		}
		
		double soma = 0.0;
		
		for(int i = 0; i < vetor.length; i++) {
			soma += vetor[i].getPreco();
		}
		
		double media = soma / n;
		
		System.out.printf("Average Price: %.2f", media );

		sc.close();

	}

}
