package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.next();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

		for (int i = 0; i < n; i++) {

			if (i == 0) {
				System.out.println("Enter #1 item data:");
			} else {
				System.out.printf("Enter %d item data:%n", i);
			}
			System.out.print("Product name: ");
			String nameProduct = sc.next();
			System.out.print("Product price: ");
			double value = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			OrderItem item = new OrderItem(quantity, value, new Product(nameProduct, value));

			order.addItem(item);
		}

		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: " + sdf2.format(order.getMoment()));
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + " ("
				+ sdf.format(order.getClient().getBirthDate()) + ") " + order.getClient().getEmail());
		System.out.println("Order items:");
		order.scrollThrough_list();
		System.out.println("Total price: " + String.format("%.2f", order.total()));

		sc.close();
	}
}
