package es.agrobook.api.model.especie;

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

	@ManyToOne(optional = false)
	private Especie especie;

	@Column(nullable = false)
	private String nombre;





	// Entidades enlazadas

}