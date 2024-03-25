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
public class AbonadoTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "abonadoTipo")
	private Set<Actividad> actividades;


/*
	Código SIEX	Tipo de fertilización
	1	Abonado de fondo
	2	Abonado de cobertera
	3	Aplicación de enmienda

 */


}