package es.agrobook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.Cultivo;

@Repository
public interface CultivoRepository extends JpaRepository<Cultivo, Long> {
	
}
