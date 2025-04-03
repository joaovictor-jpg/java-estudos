package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComLimiteDeAdocoesTest {

    @InjectMocks
    private ValidacaoTutorComLimiteDeAdocoes validador;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    @Description("Não deveria Permitir solicitacao de adocao tutor atingiu o limite de 5 adocoes")
    void validarC1() {
        //Arrange
        given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(5);

        //Act + Assert
        assertThrows(ValidacaoException.class, () -> validador.validar(dto));
    }

    @Test
    @Description("Deveria permitir solicitacao de adocao tutor nao atingiu limite de 5 adocoes")
    void validarC2() {
        given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(4);

        //Act + Assert
        assertDoesNotThrow(() -> validador.validar(dto));
    }
}