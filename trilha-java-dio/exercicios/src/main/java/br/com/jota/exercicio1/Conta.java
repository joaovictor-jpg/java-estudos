package br.com.jota.exercicio1;

import java.util.Scanner;

public abstract class Conta {

    // TODO: Implemente os atributos privados para garantir que só podem ser acessados dentro da classe:

    private String titleName;
    private Integer accountNumber;
    private Double balance;

    // TODO: Crie o construtor para inicializar os atributos da conta:

    public Conta(String titleName, Integer accountNumber, Double balance) {
        this.titleName = titleName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    // TODO: Adicione o método público para consultar o saldo:

    public Double consultarSaldo() {
        return balance;
    }


    // TODO: Adicione o método público para realizar saque:

    public Boolean sacar(Double money) {
        if(this.balance > money) {
            this.balance = this.balance - money;
            return true;
        }
        return false;
    }

    // TODO: Crie o método público para realizar depósito


    public void setBalance(Double balance) {
        this.balance = this.balance + balance;
    }

    public Double depositar (Double money) {
        setBalance(money);
        return this.balance;
    }
}
