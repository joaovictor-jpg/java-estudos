package br.com.jota.api.controllers;

import br.com.jota.api.medico.dto_entrada_dados.DadosCadastroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @PostMapping
    public void cadastrarMedico(@RequestBody DadosCadastroMedico dados) {
        System.out.println(dados);
    }

}
