package es.agrobook.api.model.persona;

import java.util.*;

import es.agrobook.api.model.explotacion.RendimientoEconomico;
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

	@Column(nullable = false)
	private String nif;

	@Column(nullable = false)
	private String nombre;

	private String apellido1;

	private String apellido2;

	@ManyToOne(optional = false)
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

	@ManyToOne(optional = false)
	private TipoAgricultor tipoAgricultor;

	@ManyToOne(optional = false)
	private CapacitacionProfesional capacitacionProfesional;

	
	@Column(nullable = false)
	private String noInscripcionRopo;

	@Column(nullable = false)
	private boolean empresa;

	@Column(nullable = false)
	private boolean asesor;
	
    @OneToMany(mappedBy = "persona")
	private Set<PersonaExplotacion> personaExplotaciones;

	
    @OneToMany
	private Set<RendimientoEconomico> rendimientoEconomicos;
	
}
