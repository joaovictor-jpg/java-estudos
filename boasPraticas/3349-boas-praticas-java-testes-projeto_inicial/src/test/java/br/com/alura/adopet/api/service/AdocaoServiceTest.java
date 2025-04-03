package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validacoes.ValidacaoPetDisponivel;
import br.com.alura.adopet.api.validacoes.ValidacaoSolicitacaoAdocao;
import br.com.alura.adopet.api.validacoes.ValidacaoTutorComAdocaoEmAndamento;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AdocaoServiceTest {

    @InjectMocks
    private AdocaoService adocaoService;

    private SolicitacaoAdocaoDto dto;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private EmailService emailService;

    @Spy
    private List<ValidacaoSolicitacaoAdocao> validacaoSolicitacaoAdocaos = new ArrayList<>();

    @Mock
    private ValidacaoTutorComAdocaoEmAndamento validacaoTutorComAdocaoEmAndamento;

    @Mock
    private ValidacaoPetDisponivel validacaoPetDisponivel;

    @Mock
    private Pet pet;

    @Mock
    private Tutor tutor;

    @Mock
    private Abrigo abrigo;

    @Captor
    private ArgumentCaptor<Adocao> adocaoArgumentCaptor;

    @Test
    @Description("Deveria salvar adoção ao solicitar")
    void solicitarC1() {

        this.dto = new SolicitacaoAdocaoDto(10L, 11L, "Motivo");

        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        BDDMockito.given(pet.getAbrigo()).willReturn(abrigo);

        adocaoService.solicitar(dto);

        then(adocaoRepository).should().save(adocaoArgumentCaptor.capture());
        Adocao adocaoSalva = adocaoArgumentCaptor.getValue();
        Assertions.assertEquals(pet, adocaoSalva.getPet());
        Assertions.assertEquals(tutor, adocaoSalva.getTutor());
        Assertions.assertEquals(dto.motivo(), adocaoSalva.getMotivo());
    }

    @Test
    @Description("Deverar chamar os validadores de adoção ao solicitar")
    void solicitarC2() {
        this.dto = new SolicitacaoAdocaoDto(10L, 11L, "Motivo");

        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
        BDDMockito.given(pet.getAbrigo()).willReturn(abrigo);
        validacaoSolicitacaoAdocaos.add(validacaoPetDisponivel);
        validacaoSolicitacaoAdocaos.add(validacaoTutorComAdocaoEmAndamento);

        adocaoService.solicitar(dto);

        then(validacaoPetDisponivel).should().validar(dto);
        then(validacaoTutorComAdocaoEmAndamento).should().validar(dto);

    }

}