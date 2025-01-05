package br.com.jota.api.medico.repository;

import br.com.jota.api.medico.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
