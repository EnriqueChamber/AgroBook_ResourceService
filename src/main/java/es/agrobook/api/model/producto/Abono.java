package es.agrobook.api.model.producto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Abono extends Producto {


	@ManyToOne(optional = false)
	private AbonoTipo tipo; 

	@Column(nullable = true)
	private Integer codigoFertilizanteSiex;

	



	// Entidades enlazadas

}