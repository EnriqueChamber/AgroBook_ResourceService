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
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 1. NIF del titular
	// Excel -> Descripción: Número de documento de identificación fiscal del titular de la explotación
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del cónyuge -> 16. NIF
	// Excel -> Descripción: Número de documento de identificación fiscal o del cónyuge del titular de la explotación 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 21. NIF Representante
	// Excel -> Descripción: Número de documento de identificación fiscal del representante de la explotación 
	// Aclaración: 

	@Column(nullable = false)
	private String nombre;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 2. Nombre / Razón Social
	// Excel -> Descripción: Nombre del titular de la explotación o razón social de la empresa
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del cónyuge -> 17.Nombre
	// Excel -> Descripción: Nombre del  cónyuge del titular de la explotación 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 22. Nombre Representante
	// Excel -> Descripción: Nombre del representante legal de la explotación 
	// Aclaración: 

	@Column(nullable = true)
	private String apellido1;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 3. Primer Apellido
	// Excel -> Descripción: Primer apellido del titular de la explotación
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del cónyuge -> 18. Primer Apellido
	// Excel -> Descripción: Primer apellido del cónyuge del titular de la explotación 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 23. Primer Apellido Representante
	// Excel -> Descripción: Primer apellido del representante legal de la explotación 
	// Aclaración: 

	@Column(nullable = true)
	private String apellido2;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 4. Segundo Apellido
	// Excel -> Descripción: Segundo apellido del titular de la explotación
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del cónyuge -> 19. Segundo Apellido
	// Excel -> Descripción: Segundo apellido del cónyuge del titular de la explotación 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 24. Segundo Apellido Representante
	// Excel -> Descripción: Segundo apellido del representante legal de la explotación 
	// Aclaración: 

	@ManyToOne(optional = true)
	private PersonaGenero genero;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 5. Género
	// Excel -> Descripción: Géenro del titular de la explotación, en caso de ser persona física
	// Aclaración: 

	@Column(nullable = false)
	private Date fechaNacimiento;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 6. Fecha de nacimiento
	// Excel -> Descripción: Fecha de nacimiento del titular de la explotación
	// Aclaración: 

	@Column(nullable = false)
	private String direccion;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 7. Direccion completa
	// Excel -> Descripción: Domicilio fiscal del titular de la explotación. Para personas físicas que no desarrollen su actividad por cuenta propia: en este caso, sería la residencia habitual.Para Autónomos: se trataría también de la residencia habitual o de una dirección donde gestionen las actividades del negocio y su relación con Hacienda.Para Empresas: es la dirección donde se gestiona la actividad económica, que puede coincidir (o no) con el domicilio social.
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 25. Direccion Completa
	// Excel -> Descripción: Domicilio del representante legal de la explotación 
	// Aclaración: PTE REVISAR. Posibilidad de que una misma persona tenga registrada varias direcciones.

	@ManyToOne(optional = false)
	private Municipio municipio;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 8. Provincia (listado INE)
	// Excel -> Descripción: Provincia del domicilio del titular de la explotación. En función del listado INE
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 9. Municipio (listado INE)
	// Excel -> Descripción: Código del municipio del domicilio del titular de la explotación. En función del listado INE
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 11. País
	// Excel -> Descripción: País de residencia del titular de la explotación
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 26. Provincia (listado INE)
	// Excel -> Descripción: Provincia del representante legal de la explotación. En función del listado INE
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 27.  Municipio (listado INE)
	// Excel -> Descripción: Código del municipio del representante legal de la explotación. En función del listado INE
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 29. País
	// Excel -> Descripción: País de residencia del representante legal de la explotación
	// Aclaración: 

	@Column(nullable = false)
	private int codigoPostal;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 10. Código Postal
	// Excel -> Descripción: Código postal del domicilio del titular de la explotación
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 28. Código Postal
	// Excel -> Descripción: Código postal del representante legal de la explotación
	// Aclaración: 

	@ManyToOne(optional = false)
	private PersonaContacto contacto;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 12. Teléfono
	// Excel -> Descripción: Número de teléfono del titular de la explotación
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 13. Correo Electrónico
	// Excel -> Descripción: Dirección de correo electrónico del titular de la explotación
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 30. Teléfono
	// Excel -> Descripción: Número de teléfono del representante de la explotación
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos del representante autorizado -> 31. Correo Electrónico
	// Excel -> Descripción: Dirección de correo electrónico del representante legal de la explotación
	// Aclaración: 

	@ManyToOne(optional = true)
	private PersonaTipoAgricultor tipoAgricultor; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 14. Tipo de agricultor (según catálogo) 
	// Excel -> Descripción: Indica el tipo de agricultor del titular de la explotación según el catálogo correspondiente. Ratificado por el agricultor al menos una vez al año.
	// Aclaración: Figuras recogidas en la Ley 19/1995, de 4 de julio, de Modernizacion de las Explotaciones Agrarias.

	@ManyToOne(optional = false)
	private PersonaFormaJuridica formaJuridica; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del titular -> 15. Tipo de titular (según catálogo)
	// Excel -> Descripción: Modalidad legal de la empresa agraria según catálogo SIEX correspondiente.
	// Aclaración: 

	@ManyToOne(optional = true)
	private PersonaRegimenMatrimonial regimenMatrimonial; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 2. Datos del titular -> Datos personales del cónyuge -> 20. Régimen matrimonial
	// Excel -> Descripción: Se deberá indicar si el titular está casado en régimen de gananciales, de separación de bienes o de participación 
	// Aclaración: 

	@ManyToOne(optional = true)
	private PersonaCapacitacionProfesional capacitacionProfesional; // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Datos del Gerente
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 
	// Aclaración: 
	// Excel -> Descripción: 
	
	@Column(nullable = false)
	private String noInscripcionRopveg; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos adicionales de Cultivos
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 
	// Aclaración: 
	// Excel -> Descripción: 

	//#endregion
	
	@Column(nullable = false)
	private String noInscripcionRopo;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 
	// Aclaración: 
	// Excel -> Descripción: 

	@Column(nullable = false)
	private boolean empresa;

	@Column(nullable = false)
	private boolean asesor;



	@ManyToOne(optional = true)
	private PersonaTipoAsociacion tipoAsociacion;

	@ManyToOne(optional = true)
	private String codigoSiex;


	
    @OneToMany(mappedBy = "persona")
	private Set<PersonaExplotacion> personaExplotaciones;

	
    @OneToMany
	private Set<RendimientoEconomico> rendimientosEconomicos;
	
}
