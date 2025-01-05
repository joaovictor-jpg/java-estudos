package br.com.jota.api.paciente.dto_saida_dados;

import br.com.jota.api.paciente.entity.Paciente;

public record DadosListagemPaciente(
        String nome,
        String email,
        String cpf
) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
