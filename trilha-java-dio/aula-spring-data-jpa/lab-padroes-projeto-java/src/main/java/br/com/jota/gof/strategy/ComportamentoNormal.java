package br.com.jota.gof.strategy;

public class ComportamentoNormal implements Comportamento{
    @Override
    public void mover() {
        System.out.println("Movendo normalmente...");
    }
}
