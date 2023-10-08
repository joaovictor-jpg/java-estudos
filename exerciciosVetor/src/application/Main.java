package application;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] vetorA = new int[n];
		int[] vetorB = new int[n];
		int[] vetorC = new int[n];

		System.out.println("Digite os valores do vetor A:");
		for (int i = 0; i < n; i++) {
			vetorA[i] = sc.nextInt();
		}
		
		System.out.println("Digite os valores do vetor B:");
		for (int i = 0; i < n; i++) {
			vetorB[i] = sc.nextInt();
		}
		
		System.out.println("VETOR RESULTANTE:");
		for (int i = 0; i < n; i++) {
			vetorC[i] = vetorA[i] + vetorB[i];
		}
		
		for (int i = 0; i < vetorC.length; i++) {
			System.out.println(vetorC[i]);
		}
		
		

		sc.close();
	}
}
