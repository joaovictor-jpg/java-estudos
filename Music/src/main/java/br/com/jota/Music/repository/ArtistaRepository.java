package br.com.jota.Music.repository;

import br.com.jota.Music.model.Artista;
import br.com.jota.Music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNameContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.music m where a.name ILIKE %:nome%")
    List<Music> buscarMusicaPorArtista(String nome);
}
