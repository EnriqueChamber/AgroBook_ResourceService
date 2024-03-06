package es.agrobook.api.model.cultivo;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoberturaSuelo {

	@Id
	private int id;

    @Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "coberturaSuelo")
	private Set<Cultivo> cultivos;


	/*
	Código SIEX	Tipo de cobertura del suelo
	1	Suelo desnudo 
	2	Cubierta vegetal sembrada
	3	Cubierta vegetal espontánea.
	4	Cubierta inerte de restos de poda
	5	Cubierta inerte de otros materiales (cáscaras de frutos secos, piedras, otros restos vegetales, etc.)
	6	Regeneración Pastos permanentes

	
	 */
}