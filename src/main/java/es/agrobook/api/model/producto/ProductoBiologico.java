package es.agrobook.api.model.producto;

import es.agrobook.api.model.eppo.Especie;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoBiologico extends Producto {


	@ManyToOne(optional = false)
    private Especie especie;

	@ManyToOne(optional = true)
	private ProductoVegetalEstadoFenologico estadoFenologico; 

	@ManyToOne(optional = true)
	private ProductoVegetalTipo tipo; 


	// Entidades enlazadas

}