package es.agrobook.api.model.actividad.tratamiento;

import java.util.Set;

import es.agrobook.api.model.actividad.Actividad;
import es.agrobook.api.model.cultivo.CultivoCampanya;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TratamientoJustificacion {


	@Id
	private Short id;

    @Column(nullable = false)
	private String descripcion;


	
	// Entidades enlazadas
	
	@OneToMany(mappedBy = "tratamientoJustificacion")
	private Set<Actividad> actividades;


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