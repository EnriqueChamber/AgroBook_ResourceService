package es.agrobook.api.model.persona;

import java.util.*;

import es.agrobook.api.model.RendimientoEconomico;
import es.agrobook.api.model.location.Municipio;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//#region campos SIEX

	@Column(nullable = false)
	private String nif;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = true)
	private String apellido1;

	@Column(nullable = true)
	private String apellido2;

	@ManyToOne(optional = true)
	private PersonaGenero genero;

	@Column(nullable = false)
	private Date fechaNacimiento;

	@Column(nullable = false)
	private String direccion;

	@ManyToOne(optional = false)
	private Municipio municipio;

	@Column(nullable = false)
	private int codigoPostal;

	@ManyToOne(optional = false)
	private PersonaContacto contacto;

	@ManyToOne(optional = true)
	private PersonaTipoAgricultor tipoAgricultor; // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Datos del Titular / Datos asociaciones, socios...

	@ManyToOne(optional = true)
	private PersonaTipoTitular tipoTitular; // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Datos del Titular

	@ManyToOne(optional = true)
	private PersonaRegimenMatrimonial regimenMatrimonial; // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Datos del Titular

	@ManyToOne(optional = true)
	private PersonaCapacitacionProfesional capacitacionProfesional; // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Datos del Gerente

	//#endregion
	
	@Column(nullable = false)
	private String noInscripcionRopo;

	@Column(nullable = false)
	private boolean empresa;

	@Column(nullable = false)
	private boolean asesor;



	@ManyToOne(optional = true)
	private PersonaTipoAsociacion tipoAsociacion;


	
    @OneToMany(mappedBy = "persona")
	private Set<PersonaExplotacion> personaExplotaciones;

	
    @OneToMany
	private Set<RendimientoEconomico> rendimientosEconomicos;
	
}
