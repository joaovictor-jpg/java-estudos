package br.com.alura.adopet.api.services;

import br.com.alura.adopet.api.dto.*;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {
    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private PetRepository petRepository;

    public List<AbrigoDetalhesDto> listar() {
        return abrigoRepository
                .findAll()
                .stream()
                .map(AbrigoDetalhesDto::new)
                .toList();
    }

    @Transactional
    public void cadatrar(CadastroAbrigoDto dto) {
        boolean existAbrigo = abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        if (existAbrigo) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }

        Abrigo abrigo = new Abrigo(dto);

        abrigoRepository.save(abrigo);
    }

    public List<PetDetails> listarPetsDoAbrigo(String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);

        return petRepository
                .findByAbrigo(abrigo)
                .stream()
                .map(PetDetails::new)
                .toList();
    }

    @Transactional
    public void cadastrarPet(String idouName, CadastroPetDto dto) {
        Abrigo abrigo = carregarAbrigo(idouName);
        Pet pet = new Pet(dto, abrigo);
        abrigo.getPets().add(pet);
        abrigoRepository.save(abrigo);
    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = abrigoRepository.findById(id);
        } catch (NumberFormatException exception) {
            optional = abrigoRepository.findByNome(idOuNome);
        }

        return optional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado"));
    }
}
