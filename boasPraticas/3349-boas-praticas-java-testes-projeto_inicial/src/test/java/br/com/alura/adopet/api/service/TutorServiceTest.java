package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizacaoTutorDto;
import br.com.alura.adopet.api.dto.CadastroTutorDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class TutorServiceTest {

    @InjectMocks
    private TutorService tutorService;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private AtualizacaoTutorDto atualizacaoTutorDto;

    @Mock
    private Tutor tutor;

    @Captor
    private ArgumentCaptor<Tutor> tutorArgumentCaptor;

    @Test
    @Description("Deve efetuar chamada para o método de salva o tutor no banco")
    void cadastrarC1() {

        CadastroTutorDto dto = new CadastroTutorDto("Jota", "(61) 98395-1091", "jota@gmail.com");

        BDDMockito.given(tutorRepository.existsByTelefoneOrEmail(dto.telefone(), dto.email())).willReturn(false);

        tutorService.cadastrar(dto);

        then(tutorRepository).should().save(tutorArgumentCaptor.capture());
        Tutor tutorSalvo = tutorArgumentCaptor.getValue();

        Assertions.assertEquals(dto.email(), tutorSalvo.getEmail());
    }


    @Test
    @Description("Deve lançar uma exceção quando telefone ou email já cadastrado")
    void cadastrarC2() {

        CadastroTutorDto dto = new CadastroTutorDto("Jota", "(61) 98395-1091", "jota@gmail.com");

        BDDMockito.given(tutorRepository.existsByTelefoneOrEmail(dto.telefone(), dto.email())).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, () -> tutorService.cadastrar(dto));
    }

    @Test
    @Description("Deve efetuar a chamada para o método de atualizar dados do tutor repository")
    void atualizarC1() {
        BDDMockito.given(tutorRepository.getReferenceById(atualizacaoTutorDto.id())).willReturn(tutor);

        tutorService.atualizar(atualizacaoTutorDto);

        then(tutor).should().atualizarDados(atualizacaoTutorDto);

    }
}