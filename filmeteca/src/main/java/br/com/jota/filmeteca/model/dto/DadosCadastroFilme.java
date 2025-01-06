package br.com.jota.filmeteca.model.dto;

public record DadosCadastroFilme(
        String nome,
        Integer duracao,
        Integer ano,
        String genero
) {
}
