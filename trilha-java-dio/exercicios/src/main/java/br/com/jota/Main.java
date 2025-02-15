package br.com.jota;

import br.com.jota.exercicio2.Conta;
import br.com.jota.exercicio2.ContaCorrente;
import br.com.jota.exercicio2.ContaPoupanca;

import java.util.Scanner;

public class Main {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String titular = sc.nextLine();
        int numeroConta = sc.nextInt();
        double saldoInicial = sc.nextDouble();

        Conta conta = new Conta(titular, numeroConta, saldoInicial);

        // Operações de saque e depósito
        if (sc.hasNextDouble()) {
            double valorSaque = sc.nextDouble();
            if (!conta.sacar(valorSaque)) {
                System.out.println("Saque invalido: Saldo insuficiente");
                System.out.println("Saldo Atual: " + String.format("%.2f", conta.consultarSaldo()));
                return;
            }
        }

        if (sc.hasNextDouble()) {
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
        }

        // Imprime o saldo final atualizado
        System.out.println("Saldo Atualizado: " + String.format("%.2f", conta.consultarSaldo()));

        sc.close(); // Fecha o scanner
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tipoConta = scanner.nextLine();
        String nomeConta = scanner.nextLine();
        Integer numeroDaConta = Integer.parseInt(scanner.nextLine());
        double saldoInicial = scanner.nextDouble();

        Conta conta;

        if (tipoConta.equalsIgnoreCase("Corrente")) {
            // TODO: Para Conta Corrente, leia também o limite de cheque especial e crie a instância.
            Double limit = scanner.nextDouble();

            // TODO: Implemente a lógica para criar uma instância de ContaCorrente ou ContaPoupanca:
            // Dica: Use um if para verificar o tipo da conta.
            conta = new ContaCorrente(nomeConta, numeroDaConta, saldoInicial, limit);
        } else {
            // TODO: Para Conta Poupança, apenas inicialize a conta com o saldo inicial:
            conta = new ContaPoupanca(nomeConta, numeroDaConta, saldoInicial);
        }


        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        }

        scanner.close();
    }
}