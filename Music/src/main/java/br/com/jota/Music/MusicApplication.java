package br.com.jota.Music;

import br.com.jota.Music.principal.Principal;
import br.com.jota.Music.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository artistaRepository;

    @Value("${GPT}")
    private String openAIToken;

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(artistaRepository, openAIToken);

        principal.exibeMenu();
    }
}
