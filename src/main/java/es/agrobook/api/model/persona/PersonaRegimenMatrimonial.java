package es.agrobook.api.model.persona;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaRegimenMatrimonial {
	
	@Id
	@Column(length = 2)
	private String codigo;

	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "regimenMatrimonial")
	private Set<Persona> personas;

	/*
	
	Código	Descripción
	PA	Participación
	SB	Separación de bienes
	SG	Sociedad de gananciales


	 */
	
}
