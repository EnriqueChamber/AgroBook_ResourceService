package es.agrobook.api.model.persona;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonaTipoAgricultor {
	
	@Id
	private Short id;

	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "tipoAgricultor")
	private Set<Persona> personas;

	/*
	
	Código SIEX	Tipo de agricultor
	1	Agricultor profesional
	2	Agricultor no pluriactivo
	3	Joven agricultor
	4	Agricultor a título principal (ATP)

	 */
	
}
