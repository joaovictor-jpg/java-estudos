package application;

import enteties.Funcionario;
import enteties.Retangulo;

public class Main {
	public static void main(String[] args) {
		
		Retangulo retangulo = new Retangulo(3.00, 4.00);
		System.out.printf("Area = %.2f%n", retangulo.area());
		System.out.printf("Perimeter = %.2f%n", retangulo.perimetro());
		System.out.printf("Diagonal = %.2f%n", retangulo.diagonal());
		
		Funcionario funcionario = new Funcionario("João Victor", 6000.00);
		
		funcionario.salarioLiquido(1000.00);
		
		System.out.println(funcionario);
		
		funcionario.acresentarSalario(10);
		
		System.out.println(funcionario);
	}
}
