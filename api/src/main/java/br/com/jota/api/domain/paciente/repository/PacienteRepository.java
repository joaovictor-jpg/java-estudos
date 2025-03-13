package br.com.jota.api.domain.paciente.repository;

import br.com.jota.api.domain.paciente.entity.Paciente;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable pageable);

    @Query("SELECT p.ativo FROM Paciente p WHERE id = :id")
    Boolean findAtivoById(@NotNull Long id);
}
