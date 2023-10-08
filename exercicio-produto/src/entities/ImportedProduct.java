package entities;

public class ImportedProduct extends Product {
	
	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}
	
	@Override
	public String priceTag() {
		return this.getName() + " $ " + String.format("%.2f", totalPrice()) + "(Customs fee: $ " + customsFee + ")";
	}
	
	public Double totalPrice() {
		return this.price += customsFee;
	}

}
