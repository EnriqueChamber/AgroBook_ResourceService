package es.agrobook.api.model.tratamiento;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.maquina.MaquinaUso;
import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.model.siembra.MaterialVegetalReproduccion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TratamientoFitosanitario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	//#region campos SIEX

    @Column(nullable = false)
	private String numeroRegistro; // Prod Fitosanitario / MDF

    @Column(nullable = false)
	private String nombreComercial;

	@ManyToOne(optional = false)
	private TratamientoFitosanitarioClasificacion clasificacion;

	@ManyToOne(optional = false)
	private Persona fabricante;

    @Column(nullable = false)
	private String formulado; // Solo para prod Fitos

    @Column(nullable = false)
	private String formulado;


	

	// Entidades enlazadas

	@OneToMany(mappedBy = "fitosanitario")
	private Set<Tratamiento> tratamientos;

}