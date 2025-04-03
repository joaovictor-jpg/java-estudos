package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService abrigoService;

    @Mock
    private AbrigoRepository abrigoRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private Abrigo abrigo;

    @Captor
    private ArgumentCaptor<Abrigo> abrigoArgumentCaptor;

    @Test
    @Description("Deverar chamar o repositorio para salva o abrigo")
    void cadastrarC1() {

        CadastroAbrigoDto dto = new CadastroAbrigoDto("Teste", "(61) 98395-1091","teste@gmail.com");

        BDDMockito.given(abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email())).willReturn(false);

        abrigoService.cadastrar(dto);

        then(abrigoRepository).should().save(abrigoArgumentCaptor.capture());

        Abrigo abrigoSalvo = abrigoArgumentCaptor.getValue();

        Assertions.assertEquals(dto.email(), abrigoSalvo.getEmail());
    }

    @Test
    @Description("Deve lançar uma exceção quando nome, telefone ou email já estiverem cadastrado")
    void cadastrarC2() {
        CadastroAbrigoDto dto = new CadastroAbrigoDto("Teste", "(61) 98395-1091","teste@gmail.com");

        BDDMockito.given(abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email())).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, () -> abrigoService.cadastrar(dto));
    }

    @Test
    @Description("Deve retorna uma lista de PetDto")
    void listarPetsDoAbrigoC1() {
        String nome = "Miau";
        BDDMockito.given(abrigoRepository.findByNome(nome)).willReturn(Optional.of(abrigo));

        abrigoService.listarPetsDoAbrigo(nome);

        then(petRepository).should().findByAbrigo(abrigo);
    }

}