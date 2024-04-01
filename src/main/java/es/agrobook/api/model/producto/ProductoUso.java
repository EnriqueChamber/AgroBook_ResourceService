package es.agrobook.api.model.producto;

import es.agrobook.api.model.actividad.Actividad;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductoUso{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @ManyToOne(optional = false)
	private Producto producto;

    @Column(nullable = true)
	private String noLote; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos adicionales de Cultivos
	
    @Column(nullable = false)
	private float cantidad; // Dosis, Semillas, Kg de Semillas, Árboles...
	
    /*@Column(nullable = false)
	private UnidadMedida unidadMedida;*/


	// Entidades enlazadas

    @ManyToOne(optional = false)
	private Actividad actividad;

}