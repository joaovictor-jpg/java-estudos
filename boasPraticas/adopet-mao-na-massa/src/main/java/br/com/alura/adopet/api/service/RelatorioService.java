package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 0 1 * *")
    public void relatorio() {
        List<Pet> pets = petRepository.findAllByAdotadoFalse();
        emailService.enviarEmail(
                "jota@gmail.com",
                "Relatorio mensal de Pets",
                """
                            Olá!
                            Aqui está o relatorio de pet não adotados
                            %s
                        """.formatted(pets)
        );
    }

}
