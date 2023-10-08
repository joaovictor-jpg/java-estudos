package entities;

public class Employee {

	private Integer id;
	private String name;
	private Double wage;

	public Employee() {

	}

	public Employee(Integer id, String nome, Double wage) {
		this.id = id;
		this.name = nome;
		this.wage = wage;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getWage() {
		return wage;
	}
	
	@Override
	public String toString() {
		return this.id + ", " + this.name + ", " + String.format("%.2f", this.wage); 
	}
	
	public void tax(double tax) {
		this.wage += this.wage * tax / 100.0;
	}

}
