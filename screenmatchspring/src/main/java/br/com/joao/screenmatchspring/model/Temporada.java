package br.com.joao.screenmatchspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Temporada(@JsonAlias("Title") String titulo, @JsonAlias("Season") Integer temporada,
                        @JsonAlias("totalSeasons") Integer totalDeEpisiodios,
                        @JsonAlias("Episodes") List<DadosEpisodio> episodios) {
}
