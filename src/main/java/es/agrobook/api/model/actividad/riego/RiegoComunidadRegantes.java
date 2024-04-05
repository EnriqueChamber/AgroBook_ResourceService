package es.agrobook.api.model.actividad.riego;

import es.agrobook.api.model.persona.Persona;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RiegoComunidadRegantes {
	
	@Id
	@Column(length = 16)
	private String codigo;

	@ManyToOne(optional = false)
	private Persona persona;

	@ManyToOne(optional = true)
	private RiegoOrigenAgua origenAgua;

	@Column(nullable = true)
	private float caudalMaximoInstantaneo;

	@Column(nullable = true)
	private float volumenMaximoAnual;

	@Column(nullable = true)
	private float superficieDerechoRiego;

	@Column(nullable = false)
	private String uso; // PTE REVISAR ENLACE CON ENUM / CATÁLOGO


	// Entidades enlazadas


	/*
	
	CARGAR DATOS DE REGANTES.csv

	 */
	
}
