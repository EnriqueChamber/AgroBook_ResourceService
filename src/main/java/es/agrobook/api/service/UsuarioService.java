package es.agrobook.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.agrobook.api.model.Usuario;
import es.agrobook.api.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodosUsuarios() {
    	return usuarioRepository.findAll();
    }
    
    public Usuario buscaKike() {
    	Usuario resUsuario = usuarioRepository.findByUsername("enrique_chamber");
    	System.out.println("UsuarioRepository.retrieveByName(\"enrique_chamber\") returns: " + resUsuario);
        return resUsuario;
    }

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario == null)
			throw new UsernameNotFoundException(username);
		return usuario;
	}

	public Usuario getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof Usuario) {
            return (Usuario) authentication.getPrincipal();
        } else {
            throw new UsernameNotFoundException("User is not authenticated; Found " + authentication.getPrincipal() + " of type " + authentication.getPrincipal().getClass() + "; Expected type User");
        }
	}

	public String getLoggedInUsername() {
		return getLoggedInUser().getUsername();
	}

}
