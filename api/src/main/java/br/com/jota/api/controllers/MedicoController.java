package br.com.jota.api.controllers;

import br.com.jota.api.medico.dto_entrada_dados.DadosCadastroMedico;
import br.com.jota.api.medico.entity.Medico;
import br.com.jota.api.medico.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

}
