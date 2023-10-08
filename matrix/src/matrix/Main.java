package matrix;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] matriz = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}

		System.out.println("Main diagonal:");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == i)
					System.out.print(matriz[i][j] + " ");
			}
		}
		
		System.out.println();
		
		int soma = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matriz[i][j] < 0)
					soma++;
			}
		}
		
		System.out.println("Negative namber = " + soma);

		sc.close();
	}

}
