package es.agrobook.api.model.persona;

import java.util.Set;

import es.agrobook.api.model.catastro.Edificacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonaGenero {
	// SIEX -> Catálogos -> NO DEFINIDO EN ANEXO VII SIEX DOCUMENTO SEGUIMIENTO -> SEXO.csv
	
	@Id
	@Column(length = 1)
	private String codigo;
	
	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "genero")
	private Set<Persona> personas;
	

	/*
	Código	Descripción
	I	Intersexual
	M	Mujer
	V	Varón
	0	Hombre
	1	Mujer
	2	no binario
	3	Priefiero no decirlo
	4	Sin prevalencia

	 */
}
