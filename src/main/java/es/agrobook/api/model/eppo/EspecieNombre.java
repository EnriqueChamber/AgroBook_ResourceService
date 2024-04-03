package es.agrobook.api.model.eppo;

import es.agrobook.api.model.enums.EppoLanguage;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "especie_id", "nombre", "eppo_language" }) })
public class EspecieNombre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre", columnDefinition = "VARCHAR(255) NOT NULL, FULLTEXT INDEX nombreFulltext (nombre)")
	private String nombre;

	@Column(nullable = false)
	private Boolean preferred;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EppoLanguage eppoLanguage;


	// Entidades enlazadas

	@ManyToOne(optional = false)
	private Especie especie;

}