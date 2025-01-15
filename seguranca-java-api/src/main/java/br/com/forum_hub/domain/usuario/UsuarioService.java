package br.com.forum_hub.domain.usuario;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.forum_hub.domain.autenticacao.TokenService;
import br.com.forum_hub.domain.perfil.DadosPerfil;
import br.com.forum_hub.domain.perfil.PerfilNome;
import br.com.forum_hub.domain.perfil.PerfilRepository;
import br.com.forum_hub.infra.email.EmailService;
import br.com.forum_hub.infra.exception.RegraDeNegocioException;
import br.com.forum_hub.services.HierarquiaService;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    private final EmailService emailService;
    private final TokenService tokenService;
    private final PerfilRepository perfilRepository;

    private final HierarquiaService hierarquiaService;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder encoder, EmailService emailService,
            TokenService tokenService, PerfilRepository perfilRepository, HierarquiaService hierarquiaService) {
        this.repository = repository;
        this.encoder = encoder;
        this.emailService = emailService;
        this.tokenService = tokenService;
        this.perfilRepository = perfilRepository;
        this.hierarquiaService = hierarquiaService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmailIgnoreCaseAndVerificadoTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado!"));
    }

    @Transactional
    public Usuario cadastrar(DadosCadostroUsuarios dados) {
        var senhaCriptografada = encoder.encode(dados.senha());

        Optional<Usuario> optionalUsuario = repository.findByEmailIgnoreCaseOrNomeUsuarioIgnoreCase(dados.email(),
                dados.nomeUsuario());

        if (optionalUsuario.isPresent()) {
            throw new RegraDeNegocioException("Já existe uma conta cadastrada com esse email ou nome de usuário!");
        }

        var perfil = perfilRepository.findByNome(PerfilNome.ESTUDANTE);

        var usuario = new Usuario(dados, senhaCriptografada, perfil);

        emailService.enviarEmailVerificacao(usuario);

        repository.save(usuario);

        return usuario;
    }

    @Transactional
    public void verifcarEmail(String codigo) {
        var usuario = repository.findByToken(codigo).orElseThrow();

        usuario.verificar();

        repository.save(usuario);
    }

    public Usuario buscarUsuarioNomeUsuario(String nomeUsuario) {
        return repository.findBynomeUsuario(nomeUsuario).orElseThrow();
    }

    public Usuario atualizarDadosUsuarios(Long id, DadosAtualizarUsuario dados) {
        Usuario usuario = repository.findById(id).orElseThrow();

        Optional<Usuario> optionalUsuario = repository.findBynomeUsuario(dados.nomeUsuario());

        if (optionalUsuario.isPresent()) {
            throw new RegraDeNegocioException("Já existe uma conta cadastrada com nome de usuário!");
        }

        usuario = atualizarUsuario(usuario, dados);

        repository.save(usuario);

        return usuario;
    }

    private Usuario atualizarUsuario(Usuario usuario, DadosAtualizarUsuario dados) {
        if (dados.nome() != null) {
            usuario.setNome(dados.nome());
        }

        if (dados.nomeUsuario() != null) {
            usuario.setNomeUsuario(dados.nomeUsuario());
        }

        if (dados.biografia() != null) {
            usuario.setBiografia(dados.biografia());
        }

        if (dados.miniBiografia() != null) {
            usuario.setMiniBiografia(dados.miniBiografia());
        }

        return usuario;
    }

    public void tokenTrocaSenha(UsuarioEmail usuarioEmail) {

        Usuario usuario = repository.findByEmailIgnoreCaseAndVerificadoTrue(usuarioEmail.email())
                .orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado!"));

        var token = tokenService.gerarToken(usuario);

        emailService.trocaSenha(usuario, token);
    }

    @Transactional
    public void atualizarSenha(AtualizarSenha atualizar) {
        Long id = tokenService.recuperarClaim(atualizar.token());

        if (id == null) {
            throw new RegraDeNegocioException("Token inválido");
        }

        Usuario usuario = repository.findById(id).orElseThrow();

        if (!atualizar.senha().equals(atualizar.senhaDeConfirmacao())) {
            throw new RegraDeNegocioException("Senhas diferentes");
        }

        usuario.setSenha(encoder.encode(atualizar.senha()));

        repository.save(usuario);

    }

    @Transactional
    public void desativarUsuario(Usuario logado, Long id) throws AccessDeniedException {
        Usuario usuario = repository.findById(id).orElseThrow();
        if (hierarquiaService.usuarioNaoTemPermissoes(logado, usuario, "ROLE_ADMIN"))
            throw new AccessDeniedException("Você não pode deletar essa conta!");

        usuario.desativar();
    }

    @Transactional
    public Usuario adicionarPerfil(Long id, DadosPerfil dados) {
        var usuario = repository.findById(id).orElseThrow();
        var perfil = perfilRepository.findByNome(dados.perfilNome());

        usuario.adicionarPerfil(perfil);

        return repository.save(usuario);
    }

    @Transactional
    public Usuario removerPerfil(Long id, DadosPerfil dados) {
        var usuario = repository.findById(id).orElseThrow();
        var perfil = perfilRepository.findByNome(dados.perfilNome());

        usuario.removerPerfil(perfil);

        return usuario;
    }

}
