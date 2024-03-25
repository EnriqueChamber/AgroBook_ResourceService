package es.agrobook.api.model.especie;

import java.util.Set;

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
	private long id;



	// Entidades enlazadas
	@OneToMany(mappedBy = "especie")
	private Set<EspecieNombre> nombres;

}