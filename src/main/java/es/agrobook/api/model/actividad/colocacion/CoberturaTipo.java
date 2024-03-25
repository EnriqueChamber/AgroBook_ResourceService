package es.agrobook.api.model.actividad.colocacion;

import java.util.Set;

import es.agrobook.api.model.actividad.Actividad;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CoberturaTipo {

	@Id
	private Short id;

    @Column(nullable = false)
	private String descripcion;



	// Entidades enlazadas

	@OneToMany(mappedBy = "coberturaTipo")
	private Set<Actividad> actividades;

	


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