package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());

			Reservation res = new Reservation(number, checkin, checkout);
			System.out.print("Reservation: " + res);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());

			res.updateDate(checkin, checkout);
			System.out.print("Reservation: " + res);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (IllegalArgumentException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpect error");
		} finally {
			sc.close();
		}

	}
}
