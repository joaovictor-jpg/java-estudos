package br.com.forum_hub.domain.usuario;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email,
        String nomeUsuario,
        String biografia,
        String miniBiografia) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getUsername(), usuario.getNomeUsuario(), usuario.getBiografia(),
                usuario.getMiniBiografia());
    }
}
