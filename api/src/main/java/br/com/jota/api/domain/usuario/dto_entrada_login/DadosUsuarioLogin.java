package br.com.jota.api.domain.usuario.dto_entrada_login;

import jakarta.validation.constraints.NotBlank;

public record DadosUsuarioLogin(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
