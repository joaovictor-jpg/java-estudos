package br.com.jota.gof.strategy;

public class Main {
    public static void main(String[] args) {
        Robo robo = new Robo();

        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        robo.setComportamento(normal);
        robo.getComportamento();

        robo.setComportamento(defensivo);
        robo.getComportamento();

        robo.setComportamento(agressivo);
        robo.getComportamento();
    }
}
