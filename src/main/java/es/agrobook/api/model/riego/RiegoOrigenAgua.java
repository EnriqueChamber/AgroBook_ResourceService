package es.agrobook.api.model.riego;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RiegoOrigenAgua{


	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;


	
	// Entidades enlazadas
	
	@OneToMany(mappedBy = "origenAgua")
	private Set<Riego> riegos;


	/*
	 * 
	Código SIEX	Procedencia del agua de riego
	1	Superficial
	2	Subterránea
	3	Pluvial
	4	Regeneración
	5	Desalinización
	6	Recursos alternativos (distintos de la regeneración y desalinización)


	 */

}