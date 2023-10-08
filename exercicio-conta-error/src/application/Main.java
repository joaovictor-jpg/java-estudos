package application;

import java.util.Scanner;

import model.entities.Account;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdraw = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdraw);

			System.out.println();

			System.out.print("Enter amount for withdraw: ");
			withdraw = sc.nextDouble();

			account.withdraw(withdraw);

			System.out.println("New balance: " + account.getBalance());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
