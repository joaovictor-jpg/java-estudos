package model.entities;

public class Employees implements Comparable<Employees> {

	private String name;
	private Double wage;

	public Employees() {

	}

	public Employees(String name, Double wage) {
		this.name = name;
		this.wage = wage;
	}

	public String getName() {
		return name;
	}

	public Double getWage() {
		return wage;
	}

	@Override
	public int compareTo(Employees obj) {
		return this.name.compareTo(obj.getName());
	}

}
