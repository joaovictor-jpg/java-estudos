package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		List<Employee> listEmployee = new ArrayList<>();

		Employee employeeExists = null;

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				System.out.println("Emplyoee #1:");
			} else {
				System.out.println("Emplyoee #" + i + ":");
			}

			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Nome: ");
			String name = sc.next();
			System.out.print("Salário: ");
			sc.nextLine();
			double salary = sc.nextDouble();

			employeeExists = listEmployee.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);

			if (employeeExists == null) {
				listEmployee.add(new Employee(id, name, salary));
			}

		}

		System.out.println();

		System.out.print("Emtre com ID do Funcíonario que vai receber o almento de salário: ");
		int id = sc.nextInt();

		employeeExists = listEmployee.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);

		if (employeeExists != null) {
			System.out.print("Entre com a porcentagem: ");
			double tax = sc.nextDouble();
			employeeExists.tax(tax);
		} else {
			System.out.println("Esse ID não existe!");
		}

		System.out.println();

		System.out.println("Lista de funcíonario:");
		for (Employee employee : listEmployee) {
			System.out.println(employee);
		}

		sc.close();
	}
}
