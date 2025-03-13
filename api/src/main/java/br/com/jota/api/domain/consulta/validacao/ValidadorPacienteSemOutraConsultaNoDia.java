package br.com.jota.api.domain.consulta.validacao;

import br.com.jota.api.domain.ValidacaoException;
import br.com.jota.api.domain.consulta.ConsultaRepository;
import br.com.jota.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiraHorario = dados.data().withHour(7);
        var ultimaHorario = dados.data().withHour(18);
        Boolean pacientePossuiOutraConsultaMarcada = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiraHorario, ultimaHorario);
        if (pacientePossuiOutraConsultaMarcada) {
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
