package es.agrobook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.model.persona.PersonaExplotacion;

import java.util.List;


@Repository
public interface PersonaExplotacionRepository extends JpaRepository<PersonaExplotacion, PersonaExplotacion.PersonaExplotacionId> {
	
    public List<PersonaExplotacion> findByExplotacion(Explotacion explotacion);
    public List<PersonaExplotacion> findByPersona(Persona persona);
}
