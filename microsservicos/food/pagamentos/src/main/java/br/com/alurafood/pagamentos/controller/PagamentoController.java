package br.com.alurafood.pagamentos.controller;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.services.PagamentoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping
    public ResponseEntity<Page<PagamentoDto>> listar(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(pagamentoService.obterTodos(pageable));
    }

    @GetMapping("/port")
    public ResponseEntity<String> retornPort(@Value("${local.server.port}")String port) {
        return ResponseEntity.ok(String.format("Requisição respondida pela instância executando na porta %s", port));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> detalhar(@PathVariable @NotNull Long id) {
        PagamentoDto dto = pagamentoService.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto dto, UriComponentsBuilder uriComponentsBuilder) {
        PagamentoDto pagamentoDto = pagamentoService.criarPagamento(dto);
        var url = uriComponentsBuilder.path("/pagamentos/{id}").buildAndExpand(pagamentoDto.getId()).toUri();
        return ResponseEntity.created(url).body(pagamentoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDto> alterar(@PathVariable @NotNull Long id, @RequestBody PagamentoDto dto) {
        PagamentoDto pagamentoDto = pagamentoService.atualizarPagamento(id, dto);
        return ResponseEntity.ok(pagamentoDto);
    }

    @PatchMapping("/{id}/confirmar")
    @CircuitBreaker(name = "atualizaPedido", fallbackMethod = "pagamentoAutorizadoComIntegracaoPendente")
    public void confirmaPagamento(@PathVariable @NotNull Long id) {
        pagamentoService.confirmarPagamento(id);
    }

    public void pagamentoAutorizadoComIntegracaoPendente(Long id, Exception e) {
        pagamentoService.alterarStatus(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable @NotNull Long id) {
        pagamentoService.excluirPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
