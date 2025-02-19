package br.com.jota.aula_spring_data_jpa.config.security;

import br.com.jota.aula_spring_data_jpa.model.User;
import br.com.jota.aula_spring_data_jpa.repository.UserRepository;
import br.com.jota.aula_spring_data_jpa.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenAccessFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public TokenAccessFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Recuperar o token da requisição
        String token = retriveRequestToken(request);

        if (token != null) {
            // Validação do token
            String username = tokenService.verifyToken(token);
            User user = userRepository.findByUsernameIgnoreCase(username).orElseThrow();

            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String retriveRequestToken(HttpServletRequest request) {
        var headerAuthorization = request.getHeader("Authorization");
        if (headerAuthorization != null) {
            return headerAuthorization.replace("Bearer ", "");
        }

        return null;
    }
}
