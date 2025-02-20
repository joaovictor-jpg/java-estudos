package br.com.jota.gof.strategy;

public class Robo {
    private Comportamento comportamento;

    public void getComportamento() {
        comportamento.mover();
    }

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }
}
