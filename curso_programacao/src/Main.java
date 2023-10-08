import java.util.Locale;

public class Main {
	public static void main(String[] args) {
		System.out.print("Hello World - ");
		System.out.println("Good Morning");
		
		int y = 32;
		System.out.println(y);
		
		double x = 10.35784;
		System.out.println(x);
		System.out.printf("%.2f%n", x);
		System.out.printf("%.4f%n", x);
		Locale.setDefault(Locale.CANADA_FRENCH);
		System.out.printf("%.2f%n", x);
		Locale.setDefault(Locale.US);
		
		System.out.printf("Resultado: %.2f metros%n", x);
		
		String nome = "Maria";
		int idade = 31;
		double renda = 4000.0;
		System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);
		
		// Exercícios
		
		//Entrada de valor
		String product1 = "Computer";
		String product2 = "Office desk";
		int age = 30;
		int code = 5290;
		char gender = 'F';
		double price1 = 2100.00;
		double price2 = 650.50;
		double measure = 53.234567;
		
		//Saida de valor
		Locale.setDefault(Locale.CANADA_FRENCH);
		System.out.println("Products:");
		System.err.printf("%s, which price is $%.2f%n", product1, price1);
		System.err.printf("%s, which price is $%.2f%n", product2, price2);
		System.err.printf("Record: %d years old, code %d and gender: %c%n", age, code, gender);
		
		System.out.printf("Measue with eight decimal places: %.8f%n", measure);
		System.out.printf("Measue (Three decimal places): %.3f%n", measure);
		
		Locale.setDefault(Locale.US);
		System.out.printf("US decimal point: %.3f%n", measure);
		
		//----------------------- FIM EXERCÌCIOS ------------------------------------
		
	}
}
