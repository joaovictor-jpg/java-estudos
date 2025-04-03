package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.service.AbrigoService;
import br.com.alura.adopet.api.service.PetService;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AbrigoControllerTest {

    @MockBean
    private AbrigoService abrigoService;

    @MockBean
    private PetService petService;

    @Mock
    private Abrigo abrigo;

    @Autowired
    private MockMvc mvc;

    @Test
    @Description("Deve retorna um 400 para solicitações com error")
    void cadastrarC1() throws Exception {
        String json = "{}";

        var response = mvc.perform(
                post("/abrigos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(400, response.getStatus());
    }

    @Test
    @Description("Deve retorna um 200 para solicitação de cadastro sem error")
    void cadastrarC2() throws Exception {
        String json = """
                {
                    "nome": "Abrigo feliz",
                    "telefone": "(94)0000-9090",
                    "email": "email@example.com.br"
                }
                """;

        var response = mvc.perform(
                post("/abrigos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    @Description("Deve retorna 404 quando não encontrar abrigo")
    void listarPetsC1() throws Exception {
        var response = mvc.perform(
                get("/abrigos/{idOuNome}pets", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(404, response.getStatus());
    }

    @Test
    @Description("Deveria devolver codigo 200 para requisicao de listar pets do abrigo por nome")
    void listarPetsC2() throws Exception {
        String nome = "Abrigo feliz";

        MockHttpServletResponse response = mvc.perform(
                get("/abrigos/{idOuNome}/pets", nome)
        ).andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    @Description("Deveria devolver codigo 200 para requisicao de listar pets do abrigo por id")
    void listarPetsC3() throws Exception {
        String id = "1";

        MockHttpServletResponse response = mvc.perform(
                get("/abrigos/{idOuNome}/pets", id)
        ).andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    @Description("Deve retorna 404 quando não encontrar abrigo")
    void cadastrarPetC1() throws Exception {
        String json = """
                {
                    "tipo": "GATO",
                    "nome": "Miau",
                    "raca": "padrao",
                    "idade": "5",
                    "cor" : "Parda",
                    "peso": "6.4"
                }
                """;
        String id = "1";
        BDDMockito.given(abrigoService.carregarAbrigo(id)).willThrow(ValidacaoException.class);

        MockHttpServletResponse response = mvc.perform(
                post("/abrigos/{idOuNome}/pets", id)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(404, response.getStatus());
    }

    @Test
    @Description("Deve retorna 200 quando não estiver com erro na requisição")
    void cadastrarPetC2() throws Exception {
        String json = """
                {
                    "tipo": "GATO",
                    "nome": "Miau",
                    "raca": "padrao",
                    "idade": "5",
                    "cor" : "Parda",
                    "peso": "6.4"
                }
                """;

        String id = "1";

        MockHttpServletResponse response = mvc.perform(
                post("/abrigos/{idOuNome}/pets", id)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }

}