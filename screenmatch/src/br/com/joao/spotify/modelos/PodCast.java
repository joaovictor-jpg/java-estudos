package br.com.joao.spotify.modelos;

import br.com.joao.spotify.modelos.interfaces.Reproducao;

public class PodCast extends Audio implements Reproducao {
    private String host;
    private String descricao;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void som() {
        System.out.println("PodCast");
    }
}
