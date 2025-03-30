package br.com.alura.services;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {

    @Mock
    private ClientHttpConfiguration client;

    @InjectMocks
    private AbrigoServices abrigoService;

    @Mock
    private HttpResponse<String> response;

    private final Abrigo abrigo = new Abrigo("Teste", "61981880392", "abrigo_alura@gmail.com");

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveVerificarQuandoHaAbrigo() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigosCadastrados = "Abrigos cadastrados:";
        String expectedIdENome = "0 - Teste";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        when(response.body()).thenReturn("[{" + abrigo.toString() + "}]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        abrigoService.listaAbrigos();

        String[] lines = byteArrayOutputStream.toString().split(System.lineSeparator());
        String actualAbrigosCadastrados = lines[0];
        String actualIdENome = lines[1];

        Assertions.assertEquals(expectedAbrigosCadastrados, actualAbrigosCadastrados);
        Assertions.assertEquals(expectedIdENome, actualIdENome);
    }

    @Test
    void deveVerificarQuandoNaoHaAbrigo() throws IOException, InterruptedException {
        String expect = "Não há abrigos cadastrados";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        when(response.body()).thenReturn("[]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        abrigoService.listaAbrigos();

        String[] lines = byteArrayOutputStream.toString().split(System.lineSeparator());
        String actual = lines[0];

        Assertions.assertEquals(expect, actual);
    }
}
