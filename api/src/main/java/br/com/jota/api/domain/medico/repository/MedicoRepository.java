package br.com.jota.api.domain.medico.repository;

import br.com.jota.api.domain.medico.entity.Medico;
import br.com.jota.api.domain.medico.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            SELECT m from Medico m WHERE m.ativo = true AND m.especialidade = :especialidade
            AND m.id not in(SELECT c.medico.id FROM Consulta c WHERE c.data = :data)
            ORDER BY rand() LIMIT 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, @NotNull @Future LocalDateTime data);

    @Query("""
            SELECT m.ativo FROM Medico m WHERE id = :id
            """)
    Boolean findAtivoById(Long id);
}
