package br.com.jota.api.controllers;

import br.com.jota.api.domain.paciente.dto_entrada_dados.DadosAtualizacaoPaciente;
import br.com.jota.api.domain.paciente.dto_entrada_dados.DadosCadastroPaciente;
import br.com.jota.api.domain.paciente.dto_saida_dados.DadosDetalhadoDoPaciente;
import br.com.jota.api.domain.paciente.dto_saida_dados.DadosListagemPaciente;
import br.com.jota.api.domain.paciente.entity.Paciente;
import br.com.jota.api.domain.paciente.repository.PacienteRepository;
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
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadoDoPaciente> cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder) {

        Paciente paciente = new Paciente(dados);

        repository.save(paciente);

        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadoDoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listagem(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadoDoPaciente> atualizarPaciente(@RequestBody DadosAtualizacaoPaciente dados) {
        Paciente paciente = repository.getReferenceById(dados.id());
        paciente.atualizadados(dados);

        return ResponseEntity.ok(new DadosDetalhadoDoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirPaciente(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhadoDoPaciente> buscarPorId(@PathVariable Long id) {
        var dados = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhadoDoPaciente(dados));
    }

}
