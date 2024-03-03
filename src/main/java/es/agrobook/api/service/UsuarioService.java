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

import es.agrobook.api.model.Usuario;
import es.agrobook.api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService{
	
    private final UsuarioRepository usuarioRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	

    public List<Usuario> obtenerTodosUsuarios() {
    	return usuarioRepository.findAll();
    }
	
    @Override
	public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario == null)
			throw new UsernameNotFoundException("username \"" + username + "\" not found");
		return usuario;
	}
	
	public Usuario loadUserByUId(long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(!usuario.isPresent())
			throw new EntityNotFoundException("user with id: \"" + id + "\" not found");
		return usuario.get();
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

    public Usuario registrar(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.saveAndFlush(usuario);
    }

	public Usuario checkCredentials(Usuario usuario) {
		Usuario usuarioRes = loadUserByUsername(usuario.getUsername());
		if(usuarioRes.getPassword() != bCryptPasswordEncoder.encode(usuarioRes.getPassword()))
			return null;
		else
			return usuarioRes;
	}

}
