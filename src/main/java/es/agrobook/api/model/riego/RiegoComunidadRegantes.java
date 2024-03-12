package es.agrobook.api.model.riego;

import java.util.Set;

import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.model.persona.Persona;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RiegoComunidadRegantes {
	
	@Id
	@Column(length = 16)
	private String codigo;

	@Column(nullable = false)
	private Persona persona;

	@Column(nullable = false)
	private RiegoOrigenAgua origenAgua;

	@Column(nullable = false)
	private float caudalMaximoInstantaneo;

	@Column(nullable = false)
	private float volumenMaximoAnual;

	@Column(nullable = false)
	private float superficieDerechoRiego;

	@Column(nullable = false)
	private String uso; // PTE REVISAR ENLACE CON ENUM / CATÁLOGO


	// Entidades enlazadas


	/*
	
	CARGAR DATOS DE REGANTES.csv

	 */
	
}
