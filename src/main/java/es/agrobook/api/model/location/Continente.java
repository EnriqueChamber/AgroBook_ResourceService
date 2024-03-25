package es.agrobook.api.model.location;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Continente {
	
	@Id
	private Short id;

	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "continente")
	private Set<AgrupacionPaises> agrupacionesPaises;
	

	/*
	Id	Descripción
	01 Europa
	02 África
	03 América
	04 Asia
	05 Oceania
	 */
}
