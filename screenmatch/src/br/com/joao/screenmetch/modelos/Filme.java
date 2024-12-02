package br.com.joao.screenmetch.modelos;

import br.com.joao.screenmetch.interfaces.Classificavel;

public class Filme extends Titulos implements Classificavel {
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}
