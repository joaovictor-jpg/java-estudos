package br.com.joao.screenmatchspring.respository;

import br.com.joao.screenmatchspring.model.Serie;
import br.com.joao.screenmatchspring.model.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String titulo);

    Optional<List<Serie>> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAutor, Double avaliacao);

    Optional<List<Serie>> findTop5ByOrderByAvaliacaoDesc();

    Optional<List<Serie>> findByGenero(Categoria categoria);

    Optional<List<Serie>> findByTotalTemporadaLessThanEqualAndAvaliacaoGreaterThanEqual(Integer temporadas, Double avaliacao);
}
