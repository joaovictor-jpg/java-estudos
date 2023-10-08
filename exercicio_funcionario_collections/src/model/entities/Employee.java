package model.entities;

public class Employee {

	private String name;
	private String email;
	private Double price;

	public Employee() {
	}

	public Employee(String name, String email, Double price) {
		super();
		this.name = name;
		this.email = email;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Double getPrice() {
		return price;
	}

}
