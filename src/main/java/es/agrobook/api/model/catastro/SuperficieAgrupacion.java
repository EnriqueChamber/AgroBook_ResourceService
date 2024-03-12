package es.agrobook.api.model.catastro;

import java.util.Set;

import es.agrobook.api.model.cultivo.CultivoCampanya;
import es.agrobook.api.model.persona.Persona;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SuperficieAgrupacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


    @Column(nullable = false)
	private String nombre;

	@ManyToMany
    private Set<Persona> personas;

	@OneToMany(mappedBy = "agrupacion")
    private Set<Superficie> superficies;

	@OneToMany(mappedBy = "agrupacion")
    private Set<SuperficieAgrupacion> agrupaciones;


	// Entidades enlazadas

	@ManyToOne(optional = true)
    private SuperficieAgrupacion agrupacion;

	@OneToMany(mappedBy = "superficie")
	private Set<CultivoCampanya> campanhas;



	



	
}
