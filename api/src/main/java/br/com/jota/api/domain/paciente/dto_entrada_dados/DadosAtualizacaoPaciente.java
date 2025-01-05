package br.com.jota.api.domain.paciente.dto_entrada_dados;

import br.com.jota.api.domain.endereco.dto_entrada_dados.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco
) {
}
