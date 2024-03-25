package es.agrobook.api.model.location;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AgrupacionPaises {
	
	@Id
	private Short id;

	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne(optional = false)
	private Continente continente;
	

	/*
	Id	Descripción
	01 Europa
	02 África
	03 América
	04 Asia
	05 Oceania
	 */
}
