package br.com.jota.services;

import br.com.jota.model.Produto;
import space.dynomake.libretranslate.Language;
import space.dynomake.libretranslate.Translator;

public class TraduzProdutoService {
    public void traduzir(Produto produto) {
        String nomeTraduzido = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getNome());
        String descricaoTraduzida = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getDescricao());
        String categoria = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getCategoria());

        produto.setNome(nomeTraduzido);
        produto.setDescricao(descricaoTraduzida);
        produto.setCategoria(categoria);
    }
}
