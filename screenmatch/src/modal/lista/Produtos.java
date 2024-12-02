package modal.lista;

import modal.Cartao;

import java.util.Scanner;

public class Produtos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre com os dados do usuário");
        System.out.print("Entre com o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite Quanto de crédito ele possui: ");
        Double credito = scanner.nextDouble();

        Cartao cartao = new Cartao(nome, credito);

        int acao = 1;

        while (acao != 0) {
            System.out.print("Digite o nome do produto: ");
            String nomeProduto = scanner.next();
            System.out.println();
            System.out.print("Digite o valor da compra: ");
            Double preco = scanner.nextDouble();
            cartao.setProduto(new modal.Produtos(nomeProduto, preco));
            System.out.println("Digite 0 para sair ou 1 para continuar comprando");
            acao = scanner.nextInt();
        }

        System.out.println("COMPRAS REALIZADAS:");
        System.out.println(cartao.getProduto());

    }
}
