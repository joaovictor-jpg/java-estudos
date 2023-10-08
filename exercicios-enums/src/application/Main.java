package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String dp = sc.next();
		Department dep = new Department(dp);

		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String nameWorker = sc.next();
		System.out.print("Level: ");
		String level = sc.next();
		System.out.print("Base salary: ");
		double salary = sc.nextDouble();
		sc.nextLine();

		Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(level), salary, dep);

		System.out.print("How many contracts to this worker? ");
		int numberContracts = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numberContracts; i++) {

			if (i == 0) {
				System.out.println("Enter contract #1 data:");
			} else {
				System.out.println("Enter contract " + i + " data:");
			}
			System.out.print("Date (DD/MM/YYYY): ");
			String date = sc.next();
			System.out.print("Value per hour: ");
			double valueHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			sc.nextLine();
			worker.addContract(new HourContract(sdf.parse(date), valueHour, hours));
		}

		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String date = sc.next().trim();

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDeprecated().getName());
		System.out.println("Income for " + date + ": "
				+ worker.income(Integer.parseInt(date.substring(3)), Integer.parseInt(date.substring(0, 2))));

		sc.close();
	}

}
