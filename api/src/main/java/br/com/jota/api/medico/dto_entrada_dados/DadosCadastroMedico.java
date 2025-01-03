package br.com.jota.api.medico.dto_entrada_dados;

import br.com.jota.api.endereco.dto_entrada_dados.DadosEndereco;
import br.com.jota.api.medico.enums.Especialidade;

public record DadosCadastroMedico(String nome, String email, String telefone, String crm, Especialidade especialidade,
                                  DadosEndereco endereco) {
}
