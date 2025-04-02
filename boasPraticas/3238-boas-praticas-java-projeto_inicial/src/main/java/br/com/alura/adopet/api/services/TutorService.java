package br.com.alura.adopet.api.services;

import br.com.alura.adopet.api.dto.AtualizacaoTutorDto;
import br.com.alura.adopet.api.dto.CadastroTutorDto;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validacao.ValidacaoCadastroDeTutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    @Autowired
    private ValidacaoCadastroDeTutor validacaoCadastroDeTutor;

    @Transactional
    public void cadastrar(CadastroTutorDto dto) {
        validacaoCadastroDeTutor.validar(dto);

        Tutor tutor = new Tutor(dto);

        repository.save(tutor);
    }

    @Transactional
    public void atualizar(AtualizacaoTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }

}

