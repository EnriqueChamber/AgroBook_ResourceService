package es.agrobook.api.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.model.persona.PersonaExplotacion;
import es.agrobook.api.model.enums.PersonaExplotacionRelacion;
import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.repository.PersonaExplotacionRepository;
import es.agrobook.api.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaExplotacionService {

    @Autowired
    private PersonaExplotacionRepository personaExplotacionRepository;

    @Autowired
    private PersonaRepository personaRepository;
    

    public PersonaExplotacion asociarPersonaConExplotacion(Persona persona, Explotacion explotacion, PersonaExplotacionRelacion relacion) {
        PersonaExplotacion personaExplotacion = PersonaExplotacion.builder()
			.persona(persona)
			.explotacion(explotacion)
			.relacion(relacion)
			.build();
        return personaExplotacionRepository.save(personaExplotacion);
    }

    public void eliminarAsociacion(Persona persona, Explotacion explotacion, PersonaExplotacionRelacion relacion) {
        PersonaExplotacion personaExplotacion = PersonaExplotacion.builder()
			.persona(persona)
			.explotacion(explotacion)
			.relacion(relacion)
			.build();
        personaExplotacionRepository.delete(personaExplotacion);
    }

    /*
    Desde el ExplotacionRepository si carga las explotaciones correctamente
    public Set<PersonaExplotacion> obtenerExplotacionesDePersona(Persona persona) {
        return persona.getPersonaExplotaciones();
    }*/

    public Set<PersonaExplotacion> getPersonasExplotacion(Explotacion explotacion) {
        return personaExplotacionRepository.findByExplotacion(explotacion).stream().collect(Collectors.toSet());
    }

    public List<Persona> obtenerPersonasDeExplotacion2(Explotacion explotacion) {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        return personaRepository.findByPersonaExplotaciones_Explotacion(explotacion, firstPageWithTwoElements);
    }


}
