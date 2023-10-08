package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		method1();
//		System.out.println("End of program");

		File file = new File("C:\\Users\\joao\\Desktop\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file: " + e.getMessage());
		} finally {
			if(sc != null) {
				sc.close();
			}
			System.out.println("Fanally block executed");
		}

	}

	public static void method1() {
		System.out.println("**** MÉTODO 1 ****");
		method2();
		System.out.println("**** MÉTODO 1 FIM ****");
	}

	private static void method2() {
		System.out.println("**** MÉTODO 2 ****");

		Scanner sc = new Scanner(System.in);

		try {
			String[] vet = sc.nextLine().split(" ");
			int n = sc.nextInt();
			System.out.println(vet[n]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!");
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("Input error!");
		}

		sc.close();

		System.out.println("**** MÉTODO 2 ****");
	}
}
