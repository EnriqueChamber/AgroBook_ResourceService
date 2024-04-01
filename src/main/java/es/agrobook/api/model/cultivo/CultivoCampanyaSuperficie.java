package es.agrobook.api.model.cultivo;

import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.producto.Producto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cultivo_campanya_id", "superficie_id" }) })
public class CultivoCampanyaSuperficie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(optional = false)
	private CultivoCampanya cultivoCampanya;
	
	@ManyToOne(optional = false)
	private Superficie superficie;
	
	@ManyToOne(optional = false)
	private Producto producto;


	// Entidades enlazadas

}