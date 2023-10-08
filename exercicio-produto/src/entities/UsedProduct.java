package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private Date manufatureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufatureDate) {
		super(name, price);
		this.manufatureDate = manufatureDate;
	}

	public Date getManufatureDate() {
		return manufatureDate;
	}

	public void setManufatureDate(Date manufatureDate) {
		this.manufatureDate = manufatureDate;
	}

	@Override
	public String priceTag() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return this.getName() + " (used) $ " + price + "(Manufacture date: " + sdf.format(manufatureDate) + ")";
	}

}
