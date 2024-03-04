package es.agrobook.api.model.location;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Continente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private int id;

	@Column(nullable = false)
	private String descripcion;
	

	/*
	Id	Descripción
	01 Europa
	02 África
	03 América
	04 Asia
	05 Oceania
	 */
}
