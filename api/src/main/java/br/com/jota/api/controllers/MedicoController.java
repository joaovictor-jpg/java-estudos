package br.com.jota.api.controllers;

import br.com.jota.api.domain.medico.dto_entrada_dados.DadosAtualizacaoMedico;
import br.com.jota.api.domain.medico.dto_entrada_dados.DadosCadastroMedico;
import br.com.jota.api.domain.medico.dto_saida_dados.DadoDetalhamentoMedico;
import br.com.jota.api.domain.medico.dto_saida_dados.DadosListagemMedicos;
import br.com.jota.api.domain.medico.entity.Medico;
import br.com.jota.api.domain.medico.repository.MedicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadoDetalhamentoMedico> cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder) {
        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadoDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable)
                .map(DadosListagemMedicos::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadoDetalhamentoMedico> atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadoDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);

        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadoDetalhamentoMedico> buscarPorId(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadoDetalhamentoMedico(medico));
    }
}
