package entities;

public class OutsourceEmployee extends Employee {

	private Double additionalCharge;

	public OutsourceEmployee() {
	}

	public OutsourceEmployee(String name, Integer houres, Double valuePerHour, Double additionalCharge) {
		super(name, houres, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	@Override
	public Double payment() {
		return super.payment() + additionalCharge * 1.1;
	}

}
