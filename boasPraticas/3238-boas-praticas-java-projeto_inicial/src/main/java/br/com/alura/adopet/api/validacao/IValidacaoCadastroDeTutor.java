package br.com.alura.adopet.api.validacao;

import br.com.alura.adopet.api.dto.CadastroTutorDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IValidacaoCadastroDeTutor implements ValidacaoCadastroDeTutor {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public void validar(CadastroTutorDto dto) {
        boolean telefoneJaCadastrado = tutorRepository.existsByTelefone(dto.telefone());
        boolean emailJaCadastrado = tutorRepository.existsByEmail(dto.email());

        if (telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoException("Telefone ou email já castrado");
        }
    }
}
