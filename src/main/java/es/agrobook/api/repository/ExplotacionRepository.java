package es.agrobook.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.Explotacion;
import es.agrobook.api.model.Usuario;

@Repository
public interface ExplotacionRepository extends JpaRepository<Explotacion, Long> {
	
	List<Explotacion> findByExplotacionesUsuarios_Usuario(Usuario usuario);
}
