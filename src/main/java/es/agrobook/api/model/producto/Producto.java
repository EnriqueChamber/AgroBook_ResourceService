package es.agrobook.api.model.producto;

import java.util.Date;

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

	@Column(nullable =  false)
	private String nombre;

	//#region fitosanitarios registrados (También fitosanitaios no químicos, trampas...). Ampliable a abonos cuando
	@Column(nullable =  true)
	private String noRegistro;

	@Column(nullable =  true)
	private Date fechaRegistro;

	@Column(nullable =  true)
	private Date fechaCaducidadRegistro;

	@Column(nullable =  true)
	private Date fechaCancelacionRegistro;

	@Column(nullable =  true)
	private Date fechaLimiteVenta;
	//#endregion

	@ManyToOne(optional = true)
	private Persona titular;
	



	// Entidades enlazadas

}