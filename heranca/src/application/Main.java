package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
	public static void main(String[] args) {
		Account acc = new Account(1001, "Alex", 1000.0);
		BusinessAccount bcc = new BusinessAccount(1002, "Maria", 0.0, 0.01);
		
		// Upcasting
		Account acc1 = bcc;
		Account acc2 = new BusinessAccount(1003, "João", 1000.0, 500.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 1000.0, 0.01);
		
		//Downcasting
		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.0);
		
		// erro: ClassCastException
		// BusinessAccount acc5 = (BusinessAccount) acc3;
		
		// forma de verifica se classe é outra
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc6 = (SavingsAccount)acc3;
			acc6.updateBalance();
			System.out.println("Update!");
		}
		
		acc.withdrawn(200.0);
		System.out.println(acc.getBalance());
		
		acc2.withdrawn(200.0);
		System.out.println(acc2.getBalance());
		
		acc3.withdrawn(200.0);
		System.out.println(acc3.getBalance());
		
	}
}
