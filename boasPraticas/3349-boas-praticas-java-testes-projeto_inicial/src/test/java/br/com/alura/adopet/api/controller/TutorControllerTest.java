package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.service.TutorService;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class TutorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TutorService tutorService;

    @Test
    @Description("Deve retorna 200 quando request está com bore correto")
    void cadastrarC1() throws Exception {
        String json = """
                {
                    "nome": "Rodrigo",
                    "telefone": "(21)0000-9090",
                    "email": "email@example.com.br"
                }
                """;

        var response = mvc.perform(
                post("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    @Description("Deve retorna 400 quando request está incorreta")
    void cadastrarC2() throws Exception {
        String json = "{}";

        var response = mvc.perform(
                post("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
    }
}