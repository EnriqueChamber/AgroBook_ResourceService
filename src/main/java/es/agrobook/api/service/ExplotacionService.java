package es.agrobook.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.agrobook.api.model.Usuario;
import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.repository.ExplotacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExplotacionService{
    
    private final UsuarioService usuarioService;
    private final ExplotacionRepository explotacionRepository;


    
    public List<Explotacion> getExplotaciones() {
        Usuario usuario = usuarioService.getLoggedInUser();
    	return explotacionRepository.findByPersonasExplotacion_Persona(usuario.getPersona());
    }

	public Optional<Explotacion> findById(Long id) {
		return explotacionRepository.findById(id);
	}

	public Explotacion saveAndFlush(Explotacion explotacion) {
		return explotacionRepository.saveAndFlush(explotacion);
	}
}
