package es.agrobook.api.model.explotacion;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExplotacionClasificacion {
	
	@Id
	private byte id;

	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "clasificacion")
	private Set<Explotacion> explotaciones;

	/*
	
	Código SIEX	Descripción
	2	Prioritaria
	3	Titularidad Compartida
	4	Cotitularidad
	5	Preferentes
	6	Ocio y Autoconsumo
	7	Singulares




	 */
	
}
