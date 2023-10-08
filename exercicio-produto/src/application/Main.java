package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			if (i == 0) {
				System.out.println("Employee #1 data:");
			} else {
				System.out.printf("Employee #%d data:%n", i);
			}

			System.out.print("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (typeProduct == 'i') {
				System.out.print("Customs fee: ");
				double customs = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customs));
			} else if (typeProduct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String date = sc.next();
				products.add(new UsedProduct(name, price, sdf.parse(date)));
			} else {
				products.add(new Product(name, price));
			}
		}
		
		for (Product product : products) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}
}
