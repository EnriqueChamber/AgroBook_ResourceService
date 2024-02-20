package es.agrobook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.agrobook.api.model.Parcela;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
	
}
