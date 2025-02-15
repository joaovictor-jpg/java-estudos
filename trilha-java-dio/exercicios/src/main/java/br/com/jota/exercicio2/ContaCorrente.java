package br.com.jota.exercicio2;

public class ContaCorrente extends Conta {
    private double limite;


    public ContaCorrente(String name, Integer numeroDaConta, double saldo, double limite) {
        super(name, numeroDaConta, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {

        // TODO: Implemente a lógica para verificar se o saque é permitido considerando o saldo e o limite:
        // Dica: Se saldo - valor >= -limite, o saque é permitido.
        if (valor <= this.limite && this.saldo < valor) {
            System.out.printf("Saque realizado: %.2f\n", valor);
            this.limite -= valor;
            this.saldo -= valor;
        } else if (this.saldo >= valor) {
            System.out.printf("Saque realizado: %.2f\n", valor);
            this.saldo -= valor;
        } else {
            System.out.println("Saque invalido: Excede limite");
        }

        exibirSaldo(); // Exibe o saldo atualizado
    }
}
