package enteties;

public class Retangulo {

	private double base;
	private double altura;
	
	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	public double area() {
		return base * altura;
	}

	public double perimetro() {
		return 2 * (altura + base);
	}

	public double diagonal() {
		return Math.sqrt(Math.pow(altura, 2) + Math.pow(base, 2));
	}

}
