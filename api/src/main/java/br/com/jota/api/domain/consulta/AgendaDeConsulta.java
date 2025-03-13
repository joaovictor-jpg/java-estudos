package br.com.jota.api.domain.consulta;

import br.com.jota.api.domain.ValidacaoException;
import br.com.jota.api.domain.consulta.validacao.ValidadorAgendamentoDeConsulta;
import br.com.jota.api.domain.medico.entity.Medico;
import br.com.jota.api.domain.medico.repository.MedicoRepository;
import br.com.jota.api.domain.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsulta {
    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public AgendaDeConsulta(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() != null && medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id médico informado não existe!");
        }

        this.validadores.forEach(v -> v.validar(dados));

        var medico = escolherMedico(dados);

        if(medico == null) {
            throw new ValidacaoException("Não existe médico disponivel nessa data!");
        }

        var paciente = pacienteRepository.findById(dados.idPaciente()).orElseThrow(() -> new ValidacaoException("Id do paciente não existe!"));
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta.getId(), consulta.getIdMedico().getId(), consulta.getIdPaciente().getId(), consulta.getData());
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando o médico não for escolhido!");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }
}
