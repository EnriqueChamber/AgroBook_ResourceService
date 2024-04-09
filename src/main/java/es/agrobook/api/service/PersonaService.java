package es.agrobook.api.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {
	
    private final PersonaRepository personaRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	

    public List<Persona> findAll() {
    	return personaRepository.findAll();
    }
	
}
