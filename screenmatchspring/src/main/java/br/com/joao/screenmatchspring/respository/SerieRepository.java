package br.com.joao.screenmatchspring.respository;

import br.com.joao.screenmatchspring.model.Episodio;
import br.com.joao.screenmatchspring.model.Serie;
import br.com.joao.screenmatchspring.model.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String titulo);

    Optional<List<Serie>> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAutor, Double avaliacao);

    Optional<List<Serie>> findTop5ByOrderByAvaliacaoDesc();

    Optional<List<Serie>> findByGenero(Categoria categoria);

    Optional<List<Serie>> findByTotalTemporadaLessThanEqualAndAvaliacaoGreaterThanEqual(Integer temporadas, Double avaliacao);

//    @Query(value = "SELECT * FROM series WHERE series.total_temporada <= 5 AND series.avaliacao >= 7.5", nativeQuery = true)
    @Query("SELECT s FROM Serie s WHERE s.totalTemporada <= :temporadas AND s.avaliacao >= :avaliacao")
    List<Serie> seriesPorTemporadaEAvaliacao(Integer temporadas, Double avaliacao);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
    List<Episodio> episodiosPorTrecho(String trechoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e where s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> TopEpisodiosPorSerie(Serie serie);

    @Query("SELECT e from Serie s JOIN s.episodios e where s = :serie AND YEAR(e.dataLancamento) >= :anoLançamento")
    List<Episodio> episodiosPorSerieEAno(Serie serie, int anoLançamento);
}
