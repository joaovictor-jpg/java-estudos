package br.com.forum_hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record AtualizarSenha(
        @NotBlank String token,
        @NotBlank String senha,
        @NotBlank String senhaDeConfirmacao) {

}
