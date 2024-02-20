package es.agrobook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.agrobook.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos personalizados si es necesario
	
	@Query(value = "select us.* from usuario us where us.username = :username", nativeQuery = true)
	Usuario retrieveByName(@Param("username") String username);
}
