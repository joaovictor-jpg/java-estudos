package br.com.jota.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Boolean existsByMedicoIdAndData(Long id, @NotNull @Future LocalDateTime data);

    Boolean existsByPacienteIdAndDataBetween(@NotNull Long id, LocalDateTime primeiraHorario, LocalDateTime ultimaHorario);
}
