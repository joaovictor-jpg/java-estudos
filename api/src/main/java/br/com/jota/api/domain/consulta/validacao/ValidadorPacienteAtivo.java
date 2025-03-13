package br.com.jota.api.domain.consulta.validacao;

import br.com.jota.api.domain.ValidacaoException;
import br.com.jota.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.jota.api.domain.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        Boolean pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente escluido");
        }
    }
}
