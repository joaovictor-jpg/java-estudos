package br.com.joao.screenmatchspring.model;

import br.com.joao.screenmatchspring.model.ia.DadosTraducao;
import br.com.joao.screenmatchspring.service.ObterDadosSerce;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;

public class ConsultaMyMemory {
    public static String obterTraducao(String text) {
        ObjectMapper mapper = new ObjectMapper();

        String texto = URLEncoder.encode(text);
        String langpair = URLEncoder.encode("en|pt-br");
        String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + langpair;

        String json = ObterDadosSerce.obterDadosSerie(url);

        DadosTraducao traducao;
        try {
            traducao = mapper.readValue(json, DadosTraducao.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return traducao.dadosResposta().textoTraduzido();
    }
}
