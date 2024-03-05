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

	@OneToOne()@MapsId
	private PersonaGenero genero;

	@Column(nullable = false)
	private Date fechaNacimiento;

	@Column(nullable = false)
	private String direccion;

	@OneToOne()@MapsId()
	private Municipio municipio;

	@Column(nullable = false)
	private int codigoPostal;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
	private PersonaContacto contacto;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
	private TipoAgricultor tipoAgricultor;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
	private CapacitacionProfesional capacitacionProfesional;

	
	@Column(nullable = false)
	private String noInscripcionRopo;


	@Column(nullable = false)
	private boolean empresa;

	private boolean asesor;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	private Set<PersonaExplotacion> personaExplotaciones;
	
}
