package br.com.jota.api.domain.medico.dto_saida_dados;

import br.com.jota.api.domain.medico.entity.Medico;
import br.com.jota.api.domain.medico.enums.Especialidade;

public record DadosListagemMedicos(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DadosListagemMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
