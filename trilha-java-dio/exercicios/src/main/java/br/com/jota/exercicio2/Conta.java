package br.com.jota.exercicio2;

public abstract class Conta {
    protected String name;
    protected Integer numeroDaConta;
    protected Double saldo;

    public Conta(String name, Integer numeroDaConta, double saldo) {
        this.name = name;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }

    public abstract void sacar(double valor);


    public void exibirSaldo() {
        System.out.printf("Saldo Atual: %.2f%n", saldo);
    }
}
