package br.com.jota.api.controllers;

import br.com.jota.api.domain.usuario.dto_entrada_login.DadosUsuarioLogin;
import br.com.jota.api.domain.usuario.entity.Usuario;
import br.com.jota.api.services.token.TokenService;
import br.com.jota.api.services.token.dto.DadosTokenJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager maneger;
    @Autowired
    private TokenService service;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosUsuarioLogin dados) {
        var autenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());

        var authentication = maneger.authenticate(autenticationtoken);

        var usuario = (Usuario) authentication.getPrincipal();

        var tokenjwt = service.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJWT(tokenjwt));
    }

}
