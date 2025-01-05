package br.com.jota.api.controllers;

import br.com.jota.api.domain.usuario.dto_entrada_login.DadosUsuarioLogin;
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

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosUsuarioLogin dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());

        var authenticaon = maneger.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
