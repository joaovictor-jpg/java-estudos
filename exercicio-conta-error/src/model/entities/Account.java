package model.entities;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		
		if(this.withdrawLimit < amount) {
			throw new IllegalArgumentException("Withdraw error: The amount exceeds withdraw limit");
		}
		
		if(this.balance < amount) {
			throw new IllegalArgumentException("Withdraw error: Not enough balance");
		}
		
		balance = balance - amount;
	}

}
