package br.com.jota.Music.services;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaGemini {

    public static String obterTraducao(String texto, String openAIToken) {

        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(openAIToken)
                .modelName("gemini-1.5-flash")
                .build();

        return gemini.generate("me fale sobre o artista: " + texto);
    }
}
