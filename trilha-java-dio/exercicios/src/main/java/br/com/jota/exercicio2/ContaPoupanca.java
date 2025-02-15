package br.com.jota.exercicio2;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String name, Integer numeroDaConta, double saldo) {
        super(name, numeroDaConta, saldo);
    }

    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando apenas o saldo:
        // Dica: Se saldo >= valor, o saque é permitido.

        if(this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saque invalido: Saldo insuficiente");
        }

        exibirSaldo(); // Exibe o saldo atualizado
    }
}
