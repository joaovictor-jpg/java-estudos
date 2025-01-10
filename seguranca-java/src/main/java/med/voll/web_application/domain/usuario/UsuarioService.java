package med.voll.web_application.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.web_application.domain.RegraDeNegocioException;
import med.voll.web_application.domain.email.EmailService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    private final PasswordEncoder encriptador;
    private final EmailService emailService;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder encriptador, EmailService emailService) {
        this.repository = repository;
        this.encriptador = encriptador;
        this.emailService = emailService;
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
        emailService.enviarEmailComSenhaGeradaAleatoriamente(new Usuario(nome, email, senhaCriptografada, perfil));
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

    public void enviarToken(String email) {
        var usuario = repository.findByEmailIgnoreCase(email).orElseThrow(
                () -> new RegraDeNegocioException("Usuário não encontrado!")
        );

        var token = UUID.randomUUID().toString();
        usuario.setToken(token);
        usuario.setExpiracaoToken(LocalDateTime.now().plusMinutes(20));

        repository.save(usuario);

        emailService.enviarEmailSenha(usuario);
    }
}
