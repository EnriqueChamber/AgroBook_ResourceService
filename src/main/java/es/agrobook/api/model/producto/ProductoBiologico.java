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
    private Especie variedad;

	@ManyToOne(optional = false)
	private ProductoVegetalEstadoFenologico estadoFenologico; 

	@ManyToOne(optional = false)
	private ProductoVegetalTipo tipo; 


	// Entidades enlazadas

}