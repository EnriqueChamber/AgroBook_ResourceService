package es.agrobook.api.model.cultivo;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActividadAgraria {

	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;


	
	// Entidades enlazadas
	
	@OneToMany(mappedBy = "actividadAgraria")
	private Set<Cultivo> cultivos;


	/*
	Código SIEX	Actividad agraria
	1	Producción en Tierras de Cultivo y Cultivos Permanentes
	2	Mantenimiento 
	3	Pastoreo
	4	Siega Producción
	5	Sin actividad agraria por razones medioambientales

	
	 */
}