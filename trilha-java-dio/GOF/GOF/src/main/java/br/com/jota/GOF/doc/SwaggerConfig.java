package br.com.jota.GOF.doc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "DESIGN PATTERN (GOF)",
                version = "1.0",
                description = "Uma API para Design Patterns",
                contact = @Contact(
                        name = "João Victor",
                        url = "https://portfolio-blue-iota-23.vercel.app/sobre",
                        email = "joaovictormdasilva676@gmail.com"
                )
        )
)
public class SwaggerConfig {
}
