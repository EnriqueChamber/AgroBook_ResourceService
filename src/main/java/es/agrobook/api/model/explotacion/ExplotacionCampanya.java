package es.agrobook.api.model.explotacion;

import java.sql.Date;
import java.util.Set;

import es.agrobook.api.model.cultivo.CultivoCampanya;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExplotacionCampanya {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Date fechaInicio;

	@Column(nullable = false)
	private Date fechaFin;


	// Entidades enlazadas

	@OneToMany(mappedBy = "campanya")
	private Set<CultivoCampanya> cultivosCampanyas;

}
