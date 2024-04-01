package es.agrobook.api.model.eppo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "especie_id", "nombre" }) })
public class EspecieNombre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre", columnDefinition = "VARCHAR(255) NOT NULL, FULLTEXT INDEX nombreFulltext (nombre)")
	private String nombre;

	@Column(nullable = false)
	private Boolean prefered;


	// Entidades enlazadas

	@ManyToOne(optional = false)
	private Especie especie;

}