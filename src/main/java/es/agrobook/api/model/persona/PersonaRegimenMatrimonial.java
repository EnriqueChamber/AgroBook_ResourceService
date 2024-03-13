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
	// SIEX -> Catálogos -> NO DEFINIDO EN ANEXO VII SIEX DOCUMENTO SEGUIMIENTO -> REG_MATR.csv
	
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
