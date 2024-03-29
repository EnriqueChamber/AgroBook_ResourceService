package es.agrobook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.agrobook.api.model.location.ParcelaSigpac;

@Repository
public interface ParcelaRepository extends JpaRepository<ParcelaSigpac, Long> {
	
}
