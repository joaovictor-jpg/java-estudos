package br.com.jota.doc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Cadastro de users",
                version = "1.0",
                description = "Uma API para cadastro de users",
                contact = @Contact(
                        name = "João Victor",
                        url = "https://portfolio-blue-iota-23.vercel.app/sobre",
                        email = "joaovictormdasilva676@gmail.com"
                )
        )
)
public class SwaggerConfig {
}
