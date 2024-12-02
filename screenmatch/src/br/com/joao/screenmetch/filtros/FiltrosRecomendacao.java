package br.com.joao.screenmetch.filtros;

import br.com.joao.screenmetch.interfaces.Classificavel;

public class FiltrosRecomendacao {
    private String recomendacao;

    public void filtro(Classificavel classificavel) {
        if(classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Colocar na lista para assistir depois");
        }
    }
}
