package br.com.forum_hub.domain.usuario;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email,
        String nomeUsuario,
        String biografia,
        String miniBiografia,
        List<String> perfis) {

    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getUsername(), usuario.getNomeUsuario(),
                usuario.getBiografia(), usuario.getMiniBiografia(),
                usuario.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
    }
}
