package br.com.jota.exercicios_fillstack.services;

import br.com.jota.exercicios_fillstack.DTOs.FraseDTO;
import br.com.jota.exercicios_fillstack.repository.FraseRepository;
import br.com.jota.exercicios_fillstack.utils.Converso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraserService {
    @Autowired
    private FraseRepository repository;
    public FraseDTO obterFraseAleatoria() {
        return Converso.converso(repository.buscarFraseAleatoria());
    }
}
