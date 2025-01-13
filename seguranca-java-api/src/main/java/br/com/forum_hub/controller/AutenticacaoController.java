package br.com.forum_hub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.forum_hub.domain.autenticacao.DadosLogin;
import br.com.forum_hub.domain.autenticacao.DadosRefreshToken;
import br.com.forum_hub.domain.autenticacao.DadosToken;
import br.com.forum_hub.domain.autenticacao.TokenService;
import br.com.forum_hub.domain.usuario.Usuario;
import br.com.forum_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("login")
    public ResponseEntity<DadosToken> efetuarLogin(@Valid @RequestBody DadosLogin dados) {
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = authenticationManager.authenticate(autenticacaoToken);

        String tokenAcesso = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        String refreshToken = tokenService.gerarRefreshToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok().body(new DadosToken(tokenAcesso, refreshToken));
    }

    @PostMapping("/atulaziar-token")
    public ResponseEntity<DadosToken> atualizarToken(@Valid @RequestBody DadosRefreshToken dados) {
        var refreshToken = dados.refreshToken();

        Long id = Long.valueOf(tokenService.verificacaoToken(refreshToken));

        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        String tokenAcesso = tokenService.gerarToken(usuario);
        String novoRefreshToken = tokenService.gerarRefreshToken(usuario);

        return ResponseEntity.ok().body(new DadosToken(tokenAcesso, novoRefreshToken));
        
    }
    

}
