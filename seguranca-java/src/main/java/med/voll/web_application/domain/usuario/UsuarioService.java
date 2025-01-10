package med.voll.web_application.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.web_application.domain.RegraDeNegocioException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    private final PasswordEncoder encriptador;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder encriptador) {
        this.repository = repository;
        this.encriptador = encriptador;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado"));
    }

    public Long salvarUsuario(@NotBlank String nome, @NotBlank @Email String email, Perfil perfil) {
        String primeiraSenha = UUID.randomUUID().toString().substring(0, 8);
        System.out.println("Senha gerada: " + primeiraSenha);
        String senhaCriptografada = encriptador.encode(primeiraSenha);
        var usuario = repository.save(new Usuario(nome, email, senhaCriptografada, perfil));
        return usuario.getId();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public void alterarSenha(DadosAlteracaoSenha dados, Usuario usuario) {
        if (!encriptador.matches(dados.senhaAtual(), usuario.getPassword()))
            throw new RegraDeNegocioException("Senha digitatda não confere com a atual!");

        if (!dados.novaSenha().equals(dados.novaSenhaConfirmacao()))
            throw new RegraDeNegocioException("Senha e confirmação são diferentes!");

        var senha = encriptador.encode(dados.novaSenha());

        usuario.alterarSenha(senha);
        usuario.setSenhaAlterada(true);

        repository.save(usuario);
    }
}
