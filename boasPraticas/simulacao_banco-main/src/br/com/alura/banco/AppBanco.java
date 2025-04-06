package br.com.alura.banco;

import java.math.BigDecimal;

public class AppBanco {

    public static void main(String[] args) {
        var cliente = new Cliente("João");
        var conta = new Conta(cliente, new BigDecimal("150"));

        var operacao = new OperacaoSaque(conta, new BigDecimal("150"));

        Thread saqueJoao = new Thread(operacao);
        Thread saqueMaria = new Thread(operacao);

        saqueJoao.start();
        saqueMaria.start();

        System.out.println(Thread.currentThread().getName());

        try {
            saqueJoao.join();
            saqueMaria.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Saque final " + conta.getSaldo());
    }
}
