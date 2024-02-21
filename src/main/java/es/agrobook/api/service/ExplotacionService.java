package es.agrobook.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.agrobook.api.model.Explotacion;
import es.agrobook.api.model.Usuario;
import es.agrobook.api.repository.ExplotacionRepository;

@Service
public class ExplotacionService{
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ExplotacionRepository explotacionRepository;

    public List<Explotacion> getExplotaciones() {
        Usuario usuario = usuarioService.getLoggedInUser();
    	return explotacionRepository.findByExplotacionesUsuarios_Usuario(usuario);
    }

	public Optional<Explotacion> findById(Long id) {
		return explotacionRepository.findById(id);
	}

	public Explotacion saveAndFlush(Explotacion explotacion) {
		return explotacionRepository.saveAndFlush(explotacion);
	}
}