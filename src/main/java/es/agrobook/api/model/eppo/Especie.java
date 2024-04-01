package es.agrobook.api.model.eppo;

import java.util.Set;

import es.agrobook.api.model.actividad.Actividad;
import es.agrobook.api.model.enums.EppoDataType;
import es.agrobook.api.model.producto.ProductoBiologico;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Especie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "especie")
	private Set<EspecieNombre> nombres;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EppoDataType eppoDataType;

	
	// Entidades enlazadas

	@ManyToMany(mappedBy = "problematicas")
	private Set<Actividad> actividades;

	@OneToMany(mappedBy = "variedad")
	private Set<ProductoBiologico> productosBiologicos;

}