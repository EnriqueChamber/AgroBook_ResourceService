package es.agrobook.api.model.riego;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RiegoSistemaRiego{


	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;


	
	// Entidades enlazadas
	
	@OneToMany(mappedBy = "sistemaRiego")
	private Set<Riego> riegos;


	/*
	 * 
	Código SIEX	Sistema de riego
	1	Superficie o Gravedad
	2	Aspersión fija
	3	Aspersión móvil
	4	Microaspersión
	5	Nebulización
	6	Goteo
	7	Hidropónico a solución perdida 
	8	Hidropónico con recirculación de solución

	 */

}