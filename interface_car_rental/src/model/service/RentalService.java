package model.service;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double priceHour;
	private Double pricePerDay;
	private TaxService TaxService;

	public RentalService(Double priceHour, Double pricePerDay, TaxService TaxService) {
		this.priceHour = priceHour;
		this.pricePerDay = pricePerDay;
		this.TaxService = TaxService;
	}

	public void processInvoice(CarRental carRental) {

		Double minutes = (double) Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		Double hours = minutes / 60.0;

		double basicPayment;
		if (hours <= 20.0) {
			basicPayment = priceHour * Math.ceil(hours);
		} else {
			basicPayment = pricePerDay * Math.ceil(hours / 24.0);
		}

		double tax = TaxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

}
