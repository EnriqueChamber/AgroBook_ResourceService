package es.agrobook.api.model.eppo;

import java.util.Set;

import es.agrobook.api.model.actividad.Actividad;
import es.agrobook.api.model.enums.EppoDataType;
import es.agrobook.api.model.enums.EppoTaxonomicMainGroup;
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

	@Column(name = "eppo_code", columnDefinition = "VARCHAR(255) NOT NULL, FULLTEXT INDEX eppo_codeFulltext (eppo_code)")
	private String eppoCode;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EppoDataType eppoDataType;

	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private EppoTaxonomicMainGroup eppoTaxonomicMainGroup;

	@OneToMany(mappedBy = "especie")
	private Set<EspecieNombre> nombres;

	
	// Entidades enlazadas

	@ManyToMany(mappedBy = "problematicas")
	private Set<Actividad> actividades;

	@OneToMany(mappedBy = "especie")
	private Set<ProductoBiologico> productosBiologicos;

}