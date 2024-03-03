package es.agrobook.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.agrobook.api.model.Explotacion;
import es.agrobook.api.model.Usuario;
import es.agrobook.api.model.UsuarioExplotacion;
import es.agrobook.api.repository.UsuarioExplotacionRepository;
import es.agrobook.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioExplotacionService {

    @Autowired
    private UsuarioExplotacionRepository usuarioExplotacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    

    public UsuarioExplotacion asociarUsuarioConExplotacion(Usuario usuario, Explotacion explotacion, String relacion) {
        UsuarioExplotacion usuarioExplotacion = UsuarioExplotacion.builder()
			.usuario(usuario)
			.explotacion(explotacion)
			.relacion(relacion)
			.build();
        return usuarioExplotacionRepository.save(usuarioExplotacion);
    }

    public void eliminarAsociacion(Usuario usuario, Explotacion explotacion, String relacion) {
        UsuarioExplotacion usuarioExplotacion = UsuarioExplotacion.builder()
			.usuario(usuario)
			.explotacion(explotacion)
			.relacion(relacion)
			.build();
        usuarioExplotacionRepository.delete(usuarioExplotacion);
    }

    /*
    Desde el ExplotacionRepository si carga las explotaciones correctamente
    public Set<UsuarioExplotacion> obtenerExplotacionesDeUsuario(Usuario usuario) {
        return usuario.getUsuarioExplotaciones();
    }*/

    public Set<UsuarioExplotacion> getUsuariosExplotacion(Explotacion explotacion) {
        return usuarioExplotacionRepository.findByExplotacion(explotacion).stream().collect(Collectors.toSet());
    }

    public Set<Usuario> obtenerUsuariosDeExplotacion2(Explotacion explotacion) {
        return usuarioRepository.findByUsuarioExplotaciones_Explotacion(explotacion);
    }


}
