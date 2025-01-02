package br.com.jota.exercicios_fillstack.controllers;

import br.com.jota.exercicios_fillstack.DTOs.FraseDTO;
import br.com.jota.exercicios_fillstack.services.FraserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraseController {

    @Autowired
    private FraserService services;

    @GetMapping("/series/frases")
    public FraseDTO obterFrase() {
        return services.obterFraseAleatoria();
    }

}
