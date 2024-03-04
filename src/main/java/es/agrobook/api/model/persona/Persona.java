package es.agrobook.api.model.persona;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.PersonaExplotacion;
import es.agrobook.api.model.location.Municipio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "codigo")
	private PersonaGenero genero;

	@Column(nullable = false)
	private Date fechaNacimiento;

	@Column(nullable = false)
	private String direccion;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
	private Municipio municipio;

	@Column(nullable = false)
	private int codigoPostal;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
	private PersonaContacto contacto;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
	private TipoAgricultor tipoAgricultor;



	@Column(nullable = false)
	private String noInscripcionRopo;


	@Column(nullable = false)
	private boolean empresa;

	private boolean asesor;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	private Set<PersonaExplotacion> personaExplotaciones;
	
}
