package enteties;

public class Funcionario {
	
	private String nome;
	private Double salarioBruto;
	private Double salarioLiquido;
	
	public Funcionario(String nome, Double salarioBruto) {
		this.nome = nome;
		this.salarioBruto = salarioBruto;
	}
	
	public void salarioLiquido(Double tax) {
		this.salarioLiquido = this.salarioBruto - tax;
	}
	
	public void acresentarSalario(int porcentagem) {
		this.salarioLiquido += this.salarioBruto * porcentagem / 100;
	}
	
	@Override
	public String toString() {
		return "Funcáonario: " + this.nome + "$ " + String.format("%.2f", this.salarioLiquido);
	}

}
