package med.voll.web_application.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public Long salvarUsuario(@NotBlank String nome, @NotBlank @Email String email, String senha) {
        String senhaCriptografada = encriptador.encode(senha);
        var usuario = repository.save(new Usuario(nome, email, senhaCriptografada));
        return usuario.getId();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
