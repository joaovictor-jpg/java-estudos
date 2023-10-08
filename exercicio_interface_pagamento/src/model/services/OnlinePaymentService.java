package model.services;

public interface OnlinePaymentService {

	public Double paymentFee(double amount);
	public Double Interest(double amont, Integer months);

}
