package br.com.jota.api.domain.paciente.dto_saida_dados;

import br.com.jota.api.domain.endereco.dto_entrada_dados.DadosEndereco;
import br.com.jota.api.domain.endereco.enitity.Endereco;
import br.com.jota.api.domain.paciente.entity.Paciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosDetalhadoDoPaciente(long id,
                                       String nome,
                                       String email,
                                       String telefone,
                                       String cpf,
                                       Endereco dadosEndereco) {
    public DadosDetalhadoDoPaciente(Paciente dados) {
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getTelefone(), dados.getCpf(), dados.getEndereco());
    }
}
