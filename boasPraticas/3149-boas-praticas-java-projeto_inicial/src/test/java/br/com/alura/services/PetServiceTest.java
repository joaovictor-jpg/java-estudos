package br.com.alura.services;

import br.com.alura.client.ClientHttpConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    @Mock
    private ClientHttpConfiguration client;

    @Mock
    private HttpResponse<String> response;

    @InjectMocks
    private PetService petService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveVerificarSeDispararRequisicaoPostSeraChamado() throws IOException, InterruptedException {
        String userInput = String.format("Teste%spets.csv",
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        when(client.dispararRequisicaoPost(anyString(), any())).thenReturn(response);

        petService.importaPetsDoAbrigo();
        verify(client.dispararRequisicaoPost(anyString(), anyString()), atLeast(1));
    }

    @Test
    public void deveLancarExcecaoParaArquivoInexistente() {
        String userInput = String.format("AbrigoTeste%sarquivo_inexistente.csv%s",
                System.lineSeparator(),
                System.lineSeparator());

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        assertThrows(NullPointerException.class, () -> petService.importaPetsDoAbrigo());
    }
}
