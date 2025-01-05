package br.com.jota.api.medico.dto_saida_dados;

import br.com.jota.api.endereco.enitity.Endereco;
import br.com.jota.api.medico.entity.Medico;
import br.com.jota.api.medico.enums.Especialidade;

public record DadoDetalhamentoMedico(
        long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        Endereco endereco
) {
    public DadoDetalhamentoMedico(Medico medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getEndereco()
        );
    }
}
