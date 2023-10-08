package entities;

public class Employee {

	private String name;
	private Integer houres;
	private Double valuePerHour;

	public Employee() {
	}

	public Employee(String name, Integer houres, Double valuePerHour) {
		super();
		this.name = name;
		this.houres = houres;
		this.valuePerHour = valuePerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHoures() {
		return houres;
	}

	public void setHoures(Integer houres) {
		this.houres = houres;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	
	public Double payment() {
		return valuePerHour * houres;
	}
	
	@Override
	public String toString() {
		return name + " - $ " + String.format("%.2f", payment());
	}

}
