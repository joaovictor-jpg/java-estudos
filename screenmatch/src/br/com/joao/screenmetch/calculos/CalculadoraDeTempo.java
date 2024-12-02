package br.com.joao.screenmetch.calculos;

import br.com.joao.screenmetch.modelos.Titulos;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void incluide(Titulos titulos) {
        this.tempoTotal += titulos.getDuracaoEmMinutos();
    }
}
