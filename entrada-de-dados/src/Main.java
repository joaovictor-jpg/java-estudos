import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String valor;
		valor = sc.next();
		System.out.println("Você digitou: " + valor);
		
		int valor2;
		valor2 = sc.nextInt();
		System.out.println("Você digitou o valor: " + valor2);
		
		double valor3;
		valor3 = sc.nextDouble();
		System.out.println("Você digitou o valor: " + valor3);
		
		char c;
		c = sc.next().charAt(0);
		System.out.println("Você digitou: " + c);
		
		sc.nextLine();
		
		String s1, s2, s3;
		s1 = sc.nextLine();
		s2 = sc.nextLine();
		s3 = sc.nextLine();
		System.out.println("DADOS DIGITADOS:");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		sc.close();
	}
}
