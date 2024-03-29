package es.agrobook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.maquina.Maquina;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
	
}
