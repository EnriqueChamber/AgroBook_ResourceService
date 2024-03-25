package es.agrobook.api.model.producto;

import es.agrobook.api.model.especie.Especie;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoVegetal extends Producto {


	@ManyToOne(optional = false)
    private Especie variedad;

	@ManyToOne(optional = false)
	private ProductoVegetalEstadoFenologico estadoFenologico; 

	@ManyToOne(optional = false)
	private ProductoVegetalTipo tipo; 


	// Entidades enlazadas

}