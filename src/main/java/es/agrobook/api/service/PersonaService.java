package es.agrobook.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.repository.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
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
