package br.com.jota.gof.facade;

import br.com.jota.gof.subsistema1.crm.CrmService;
import subsistema2.crm.CepApi;

public class Facade {
    public void migrarCliente(String nome, String cep) {

        String cidade = CepApi.getInstance().recuperarCidade(cep);
        String estadoo = CepApi.getInstance().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, estadoo, cidade);
    }
}
