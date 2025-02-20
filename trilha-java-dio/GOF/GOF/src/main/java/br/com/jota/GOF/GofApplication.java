package br.com.jota.GOF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Projeto Spring Boot gerado via Spring Initializr
 * Os seguintes módulos foram selecionados:
 *  - Spring Data JPA
 *  - Spring Web
 *  - H2 Database
 *  - OpenFeign
 *
 * @author joaov
 */

@EnableFeignClients
@SpringBootApplication
public class GofApplication {

	public static void main(String[] args) {
		SpringApplication.run(GofApplication.class, args);
	}

}
