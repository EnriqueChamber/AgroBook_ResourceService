package es.agrobook.api.model.persona;

import java.util.*;

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

	@ManyToOne
	private PersonaGenero genero;

	@Column(nullable = false)
	private Date fechaNacimiento;

	@Column(nullable = false)
	private String direccion;

	@ManyToOne
	private Municipio municipio;

	@Column(nullable = false)
	private int codigoPostal;

	@ManyToOne
	private PersonaContacto contacto;

	@ManyToOne
	private TipoAgricultor tipoAgricultor;

	@ManyToOne
	private CapacitacionProfesional capacitacionProfesional;

	
	@Column(nullable = false)
	private String noInscripcionRopo;

	@Column(nullable = false)
	private boolean empresa;

	@Column(nullable = false)
	private boolean asesor;
	
    @OneToMany(mappedBy = "persona")
	private Set<PersonaExplotacion> personaExplotaciones;
	
}
