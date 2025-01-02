package br.com.jota.exercicios_fillstack.utils;

import br.com.jota.exercicios_fillstack.DTOs.FraseDTO;
import br.com.jota.exercicios_fillstack.model.Frase;

public class Converso {

    public static FraseDTO converso(Frase frase) {
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }

}
