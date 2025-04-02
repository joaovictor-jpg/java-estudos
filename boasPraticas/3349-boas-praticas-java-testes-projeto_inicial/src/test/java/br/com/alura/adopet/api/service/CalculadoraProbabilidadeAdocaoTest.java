package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraProbabilidadeAdocaoTest {

    @Test
    @DisplayName("Probabilidade alta para gatos jovens com peso baixo")
    void probabilidadeAltaCenario1() {
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Jota's Pet",
                "(63) 99592-2094",
                "jota@gmail.com"
        ));

        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Pepe",
                "Siames",
                4,
                "cinza",
                4.0f
        ), abrigo);

        CalculadoraProbabilidadeAdocao calculadoraProbabilidadeAdocao = new CalculadoraProbabilidadeAdocao();

        ProbabilidadeAdocao probabilidadeAdocao = calculadoraProbabilidadeAdocao.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidadeAdocao);
    }

    @Test
    @DisplayName("Probabilidade média para gatos idosos com peso baixo")
    void probabilidadeMediaCenario1() {
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Jota's Pet",
                "(63) 99592-2094",
                "jota@gmail.com"
        ));

        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Pepe",
                "Siames",
                15,
                "cinza",
                4.0f
        ), abrigo);

        CalculadoraProbabilidadeAdocao calculadoraProbabilidadeAdocao = new CalculadoraProbabilidadeAdocao();

        ProbabilidadeAdocao probabilidadeAdocao = calculadoraProbabilidadeAdocao.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidadeAdocao);
    }
}