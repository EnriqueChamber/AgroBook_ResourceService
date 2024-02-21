package es.agrobook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.agrobook.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
