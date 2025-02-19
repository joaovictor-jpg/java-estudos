package br.com.jota.aula_spring_data_jpa.controller;

import br.com.jota.aula_spring_data_jpa.dto.Login;
import br.com.jota.aula_spring_data_jpa.model.User;
import br.com.jota.aula_spring_data_jpa.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("Login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(login.username(), login.password());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var token = tokenService.createdToken((User) authentication.getPrincipal());

        return ResponseEntity.ok().body(token);
    }
}
