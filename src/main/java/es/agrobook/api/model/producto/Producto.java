package es.agrobook.api.model.producto;

import es.agrobook.api.model.persona.Persona;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable =  true)
	private String nombreComercial;

	@Column(nullable =  true)
	private String noRegistro;

	@ManyToOne(optional = false)
	private Persona fabricante;

	@ManyToOne(optional = false)
	private Persona suministrador;
	



	// Entidades enlazadas

}