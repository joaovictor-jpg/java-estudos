package br.com.jota.aula_spring_data_jpa.service;

import br.com.jota.aula_spring_data_jpa.handler.BusinessException;
import br.com.jota.aula_spring_data_jpa.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String createdToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("jota")
                    .withSubject(user.getUsername())
                    .withExpiresAt(expiration(30))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new BusinessException("Erro ao gerar token de acesso!");
        }
    }

    public String verifyToken(String token) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256("12345678");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("jota")
                    .build();

            decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            throw new BusinessException("Error ao verificar token jwt");
        }
    }

    private Instant expiration(Integer minutes) {
        return LocalDateTime.now().plusMinutes(minutes).toInstant(ZoneOffset.of("-03:00"));
    }
}
