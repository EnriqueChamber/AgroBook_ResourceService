package es.agrobook.api.model.location;

import java.util.Set;

import es.agrobook.api.model.edificacion.Edificacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Continente {
	
	@Id
	private int id;

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
