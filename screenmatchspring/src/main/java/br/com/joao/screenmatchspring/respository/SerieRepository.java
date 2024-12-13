package br.com.joao.screenmatchspring.respository;

import br.com.joao.screenmatchspring.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
