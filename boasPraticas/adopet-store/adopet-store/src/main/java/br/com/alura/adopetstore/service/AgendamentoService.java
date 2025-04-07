package br.com.alura.adopetstore.service;

import br.com.alura.adopetstore.email.EmailRelatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AgendamentoService {

    @Autowired
    private RelatorioService relatorioService;
    @Autowired
    private EmailRelatorio emailRelatorio;

    @Scheduled(cron = "0 44 21 * * *")
    private void relatorioService() {
        var estoqueZero = relatorioService.infoEstoque();
        var faturamento = relatorioService.faturamentoObtido();

        CompletableFuture.allOf(estoqueZero, faturamento).join();

        try {
            emailRelatorio.enviar(estoqueZero.get(), faturamento.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName());
    }
}
