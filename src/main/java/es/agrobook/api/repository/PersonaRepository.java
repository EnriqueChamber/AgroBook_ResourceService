package es.agrobook.api.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.model.persona.Persona;
import java.util.Set;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	Set<Persona> findByPersonaExplotaciones_Explotacion(Explotacion explotacion, Pageable pageable);
}
