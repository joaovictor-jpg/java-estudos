import java.math.BigDecimal;
import java.util.Scanner;

import br.com.jota.entities.Conta;

public abstract class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Por favor, digite o seu nome: ");
        String nome = scn.nextLine();

        System.out.print("Por favor, entre com o número da agência: ");
        String agencia = scn.nextLine();

        System.out.print("Por favor, Entre com o valor do deposito: ");
        BigDecimal saldo = new BigDecimal(scn.nextLine());

        System.out.println("Por favor, Entre com o número da conta: ");
        Integer numero = scn.nextInt();
        scn.nextLine();

        Conta conta = new Conta(nome, agencia, saldo, numero);

        System.out.println(conta);

        scn.close();
    }
}
