package projeto;

import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Entre com os dados do cliente");
        System.out.print("\nEntre com o nome do cliente: ");
        String nome = read.next();
        System.out.print("Entre com o tipo de conta: ");
        String tipoDeConta = read.next();
        System.out.print("Entre com o saldo da conta: ");
        double saldo = read.nextDouble();

        Conta conta = new Conta();

        if(tipoDeConta.equals("CORRENTE")) {
            conta = new Conta(nome, TypeConta.CORRENTE, saldo);
        }else if(tipoDeConta.equals("POUPANCA")) {
            conta = new Conta(nome, TypeConta.POUPANCA, saldo);
        }

        System.out.println("Operações");
        System.out.println("1- Consultar saldos");
        System.out.println("2- Valor do depósito");
        System.out.println("3- Transferir valor");
        System.out.println("4- Sair");

        int operacao = read.nextInt();

        while (operacao != 4) {
            if(operacao == 1) {
                System.out.println( conta.getSaldo());
            } else if(operacao == 2) {
                System.out.print("Quanto você deja depósitar: ");
                double deposito = read.nextDouble();
                conta.deposito(deposito);
                System.out.println( conta.getSaldo());
            } else if(operacao == 3) {
                System.out.print("Quanto você deja transferir: ");
                double transferencia = read.nextDouble();
                double saldoDaConta = conta.getSaldo();
                if (saldoDaConta < transferencia) {
                    System.out.println("Saldo insuficiente");
                } else {
                    conta.transferencia(transferencia);
                }
                System.out.println("Seu saldo é de: " + conta.getSaldo());
            } else if(operacao != 4) {
                System.out.println("Opção inválida!");
            }

            System.out.println("Operações");
            System.out.println("1- Consultar saldos");
            System.out.println("2- Valor do depósito");
            System.out.println("3- Transferir valor");
            System.out.println("4- Sair");

            operacao = read.nextInt();
        }

        System.out.println(conta);
    }
}
