package es.agrobook.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.Explotacion;
import es.agrobook.api.model.Usuario;
import java.util.Set;
import es.agrobook.api.model.UsuarioExplotacion;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
	
	Set<Usuario> findByUsuarioExplotaciones_Explotacion(Explotacion explotacion);
}
