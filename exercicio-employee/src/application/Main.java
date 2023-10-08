package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourceEmployee;

public class Main {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {

			if (i == 0) {
				System.out.println("Employee #1 data:");
			} else {
				System.out.printf("Employee #%d data:%n", i);
			}

			System.out.print("Outsourced (y/n)? ");
			char isOutsourced = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			if (isOutsourced == 'y') {
				System.out.print("Additional charge: ");
				double additional = sc.nextDouble();
				employees.add(new OutsourceEmployee(name, hours, valuePerHour, additional));
			} else {
				employees.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		sc.close();

	}
}
