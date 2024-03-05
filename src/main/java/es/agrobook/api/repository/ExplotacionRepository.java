package es.agrobook.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.model.persona.Persona;

@Repository
public interface ExplotacionRepository extends JpaRepository<Explotacion, Long> {
	
	List<Explotacion> findByPersonasExplotacion_Persona(Persona persona);
}
