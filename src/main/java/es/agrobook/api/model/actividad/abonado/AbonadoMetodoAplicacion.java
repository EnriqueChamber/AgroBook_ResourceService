package es.agrobook.api.model.actividad.abonado;

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
public class AbonadoMetodoAplicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "abonadoMetodoAplicacion")
	private Set<Actividad> actividades;


/*
	Código SIEX	Método de fertilización
1	Esparcido general
2	Esparcido general y enterrado
3	Esparcido localizado
4	Esparcido localizado y enterrado
5	Riego por aspersión (fertirrigación)
6	Riego localizado (fertirrigación)
7	Aplicación foliar

 */


}