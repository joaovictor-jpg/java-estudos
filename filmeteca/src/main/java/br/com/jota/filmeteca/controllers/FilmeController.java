package br.com.jota.filmeteca.controllers;

import br.com.jota.filmeteca.model.dto.DadosCadastroFilme;
import br.com.jota.filmeteca.model.entity.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmeController {
    private List<Filme> filmes = new ArrayList<>();

    @GetMapping("/formulario")
    public String carregaPaginaFormulario() {
        return "formulario";
    }

    @GetMapping("/listagem")
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", filmes);
        return "listagem";
    }

    @PostMapping("/filmes")
    public String cadastraFilme(DadosCadastroFilme dados) {
        System.out.println(dados);
        var filme = new Filme(dados);
        filmes.add(filme);

        return "redirect:/listagem";
    }
}
