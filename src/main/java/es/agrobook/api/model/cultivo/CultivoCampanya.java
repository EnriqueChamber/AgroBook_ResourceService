package es.agrobook.api.model.cultivo;

import java.util.Set;

import es.agrobook.api.model.actividad.riego.RiegoOrigenAgua;
import es.agrobook.api.model.actividad.riego.RiegoSistemaRiego;
import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.explotacion.ExplotacionCampanya;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cultivo_id", "campanya_id" }) })
public class CultivoCampanya{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(optional = false)
	private Cultivo cultivo;
	
	@ManyToOne(optional = false)
	private ExplotacionCampanya campanya;
	
	@ManyToOne(optional = false)
	private RiegoOrigenAgua origenAgua;
	
	@ManyToOne(optional = false)
	private RiegoSistemaRiego sistemaRiego;


	// Entidades enlazadas

	@ManyToMany(mappedBy = "cultivosCampanyas")
	private Set<Superficie> superficies;

}