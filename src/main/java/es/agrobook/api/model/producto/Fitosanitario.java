package es.agrobook.api.model.producto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fitosanitario extends Producto {


	@ManyToOne(optional = false)
	private FitosanitarioTipo tipo; 

	@ManyToOne(optional = false)
	private FitosanitarioClasificacion clasificacion; 

	@Column(nullable =  true)
	private boolean vigente;
	
	// Más adelante se declararán Usos, donde se enlazarán el cultivo aplicable como especie y el agente a combatir como especie


	// Entidades enlazadas

}