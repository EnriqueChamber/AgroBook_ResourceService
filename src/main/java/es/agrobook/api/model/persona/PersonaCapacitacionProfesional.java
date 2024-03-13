package es.agrobook.api.model.persona;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaCapacitacionProfesional {
	// SIEX -> Catálogos -> Capacitacion Profesional -> CAPACITACION_PROFESIONAL.csv
	
	@Id
	private byte id;

	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "capacitacionProfesional")
	private Set<Persona> personas;

	/*
	
	Código SIEX	Capacitación profesional
	1	Sólo experiencia práctica agraria
	2	Cursos de formación agraria
	3	Formación profesional agraria
	4	Estudios universitarios y/o Superiores agrarios


	 */
	
}
