package br.com.joao.screenmetch.calculos;

import br.com.joao.screenmetch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void incluide(Titulo titulos) {
        this.tempoTotal += titulos.getDuracaoEmMinutos();
    }
}
