package br.com.alura.adopetstore.controller;

import br.com.alura.adopetstore.dto.RelatorioEstoque;
import br.com.alura.adopetstore.dto.RelatorioFaturamento;
import br.com.alura.adopetstore.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("admin/relatorios")
public class RelatorioController {
    @Autowired
    private RelatorioService service;

    @GetMapping("estoque")
    public ResponseEntity<RelatorioEstoque> obterInfoEstoque() throws ExecutionException, InterruptedException {
        var relatorio = service.infoEstoque().get();
        return ResponseEntity.ok(relatorio);
    }

    @GetMapping("faturamento")
    public ResponseEntity<RelatorioFaturamento> obterInfoFaturamento() throws ExecutionException, InterruptedException {
        var relatorio = service.faturamentoObtido().get();
        return ResponseEntity.ok(relatorio);
    }
}