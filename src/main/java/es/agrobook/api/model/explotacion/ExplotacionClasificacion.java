package es.agrobook.api.model.explotacion;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExplotacionClasificacion {
	// SIEX -> Catálogos -> Clasificacíon de la explotación -> CLASIFICACION_EXPLOTACION.csv
	
	@Id
	private Short id;

	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "clasificacion")
	private Set<Explotacion> explotaciones;

	/*
	
	Código SIEX	Descripción
	2	Prioritaria
	3	Titularidad Compartida 							Relaciones Explotacion-Persona
	4	Cotitularidad 									Relaciones Explotacion-Persona
	5	Preferentes
	6	Ocio y Autoconsumo 								Explotación Ocio y Autoconsumo Check
	7	Singulares




	 */
	
}
