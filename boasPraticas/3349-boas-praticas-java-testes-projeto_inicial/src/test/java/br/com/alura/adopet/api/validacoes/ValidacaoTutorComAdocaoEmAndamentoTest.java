package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComAdocaoEmAndamentoTest {

    @InjectMocks
    private ValidacaoTutorComAdocaoEmAndamento validador;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    @Description("Deve lançar um error quando Tuto tiver com uma adoção em andamento")
    void validarC1() {

        BDDMockito.given(adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, () -> validador.validar(dto));

    }

    @Test
    @Description("Não deve lançar um error quando Tuto estiver sem adoção em andamento")
    void validarC2() {

        BDDMockito.given(adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(false);

        Assertions.assertDoesNotThrow(() -> validador.validar(dto));

    }
}