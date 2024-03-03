package es.agrobook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.Explotacion;
import es.agrobook.api.model.Usuario;
import es.agrobook.api.model.UsuarioExplotacion;
import es.agrobook.api.model.UsuarioExplotacionId;
import java.util.List;


@Repository
public interface UsuarioExplotacionRepository extends JpaRepository<UsuarioExplotacion, UsuarioExplotacionId> {
	
    public List<UsuarioExplotacion> findByExplotacion(Explotacion explotacion);
    public List<UsuarioExplotacion> findByUsuario(Usuario usuario);
}
