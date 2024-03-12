package es.agrobook.api.model.catastro;

import java.util.Set;

import es.agrobook.api.model.explotacion.Explotacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegimenTenencia {
	
	@Id
	private byte id;

	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "regimenTenencia")
	private Set<Edificacion> edificaciones;

	@OneToMany(mappedBy = "regimenTenencia")
	private Set<Superficie> superficies;

	@OneToMany(mappedBy = "regimenTenencia")
	private Set<Explotacion> explotaciones;

	/*
	
	Código SIEX	Régimen de tenencia
	1	Propiedad
	2	Arrendamiento
	3	Aparcería
	4	Asignación superficie comunal
	5	Usufructo
	6	Aparcería comunal







	 */
	
}
