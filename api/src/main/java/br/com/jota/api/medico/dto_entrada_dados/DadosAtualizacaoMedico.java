package br.com.jota.api.medico.dto_entrada_dados;

import br.com.jota.api.endereco.dto_entrada_dados.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco
) {
}
