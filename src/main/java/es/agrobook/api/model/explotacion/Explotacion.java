package es.agrobook.api.model.explotacion;

import java.sql.Date;
import java.util.Set;

import es.agrobook.api.model.RendimientoEconomico;
import es.agrobook.api.model.actividad.riego.RiegoComunidadRegantes;
import es.agrobook.api.model.catastro.CausaBaja;
import es.agrobook.api.model.catastro.Edificacion;
import es.agrobook.api.model.location.Municipio;
import es.agrobook.api.model.location.ParcelaSigpac;
import es.agrobook.api.model.maquina.Maquina;
import es.agrobook.api.model.persona.PersonaContacto;
import es.agrobook.api.model.persona.PersonaExplotacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Explotacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nombre;

    @ManyToMany
	private Set<ParcelaSigpac> parcelasSigpac;



	//#region campos SIEX

	@Column(nullable = false)
	private String registroAutonomico; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 1. Código (del REA correspondiente)
	// Excel -> Descripción: Código de explotación asignado en el Registro de explotaciones de la CA. Este código lo da la CAR a sus explotaciones. Una vez se carga en SIEX, la plataforma asignará el código SIEX y lo devolverá a la CAR como resultado de la carga. En el caso de que una explotación cambie de CA, mantendrá su código SIEX pero cambiará su código REA.
	// Aclaración: 

	@Column(nullable = false)
	private Date fechaInstripcionRea; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 2. Fecha de inscripción (entrada en el registro correspondiente)
	// Excel -> Descripción: Fecha de inscripción de la explotación en el registro. Será la fecha en la que la CA registró por primera vez la información de esta explotación en su REA
	// Aclaración: 

	@Column(nullable = true)
	private boolean jovenAgricultor;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 3. Indicadores (casillas de verificación) - Instalación de joven agrigultor
	// Excel -> Descripción: Indica si la explotación pertenece a un joven agricultor. 
	// Aclaración: Este campo será autocompletado según Explotación -> Persona Titular -> Tipo Agricultor == Joven Agricultor

	@Column(nullable = true)
	private boolean inicioActividadAgraria;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 3. Indicadores (casillas de verificación) - Inicio Actividad Agraria
	// Excel -> Descripción: Indica que el titular de la explotación se incorpora por primera vez a la actividad agraria
	// Aclaración: 

	@Column(nullable = true)
	private boolean ocioAutoconsumo;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 3. Indicadores (casillas de verificación) - Ocio/Autoconsumo
	// Excel -> Descripción: Indica si la explotación tiene una actividad dirigida al ocio o a una producción para el autoconsumo
	// Aclaración: Este campo será autocompletado según ExplotacionClasificación -> Ocio y Autoconsumo

	@Column(nullable = true)
	private boolean autocontrol;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 3. Indicadores (casillas de verificación) - Autocontrol
	// Excel -> Descripción: Indica si el titular ha realizado autocontrol en la explotación
	// Aclaración: PTE REVISAR si se refiere a algún tipo de actividad realizada sobre un cultivo

	@Column(nullable = true)
	private boolean ventaDirecta;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 3. Indicadores (casillas de verificación) - Venta directa
	// Excel -> Descripción: Indica si la explotación realiza venta directa de su producción agraria al consumidor
	// Aclaración: PTE REVISAR. Aparentemente no se diferencia en la cosecha comercializada (Cultivo -> Actividad de Cosecha -> Genera entidad Cosecha -> Cosecha.ventaDirecta)

	@Column(nullable = true)
	private Date fechaBaja; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 4. Fecha de baja
	// Excel -> Descripción: Fecha de baja de la explotación en el registro
	// Aclaración: 

	@ManyToOne(optional = true)
	private CausaBaja causaBaja;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 5. Causa de baja de explotación (según catálogo, en función de la tipología)
	// Excel -> Descripción: Causa de baja de la explotación en el registro. A elegir de entre las ofrecidas según catálogo.
	// Aclaración: PTE REVISAR. Aparentemente hace referencia a la causa de baja de la explotación o su superficie en la Dirección General de Catastro.

	@ManyToOne(optional = false)
	private ExplotacionClasificacion clasificacion;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 6. Clasificacion de la explotación (casillas de verificación)
	// Excel -> Descripción: Indica la clasificación de la explotación según el catálogo SIEX correspondiente. Campo multirregistro
	// Aclaración: No parece tener nada que ver con las casillas de verificación.

	@Column(nullable = false)
	private Date fechaClasificacion;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 7. Fecha Inicio adquisición clasificación
	// Excel -> Descripción: Fecha en que una explotación empieza a tener una clasificación concreta
	// Aclaración: 

	@ManyToOne(optional = true)
	private RiegoComunidadRegantes comunidadRegantes;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> Datos generales de la explotación -> 8. Comunidades de usuarios de agua (según catálogo)
	// Excel -> Descripción: Indica el nombre de la comunidad de regantes según catálogo SIEX correspondiente (multirregistro)
	// Aclaración: Una comunidad de regantes hace referencia a una Persona con Forma Jurídica: 14	Otra agrupación de personas fisicas

	//@Column(nullable = true)
	//private Persona entidadHabilitadaRea;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> DatosEntidades habilitadas -> 9. Entidad habilitada REA (según catálogo "Entidad habilitada")
	// Excel -> Descripción: Indicar la entidad habilitada, según el catálogo SIEX correspondiente
	// Aclaración: PTE REVISAR. Catálogo Inexistente

	//@Column(nullable = true)
	//private Persona entidadHabilitadaCue;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> DatosEntidades habilitadas -> 10. Entidad habilitada CUE (según catálogo "Entidad habilitada")
	// Excel -> Descripción: Indicar la entidad habilitada, según el catálogo SIEX correspondiente
	// Aclaración: PTE REVISAR. Catálogo Inexistente

	//@Column(nullable = true)
	//private String cueComercial;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 1. Datos generales de la explotación -> DatosEntidades habilitadas -> 11. CUE-Comercial (según catálogo)
	// Excel -> Descripción: Indicar el cuaderno comercial utilizado, según el catálogo SIEX correspondiente
	// Aclaración: PTE REVISAR. Catálogo Inexistente. AgroBook
	


	
    @OneToMany(mappedBy = "explotacion")
    private Set<ExplotacionActividadSecundaria> actividadesSecundarias; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 
	// Aclaración: 
	// Excel -> Descripción: 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Actividad Secundaria ligada a la actividad agraria

	@OneToMany(mappedBy = "explotacion")
	private Set<RendimientoEconomico> rendimientosEconomicos;  
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 
	// Aclaración: 
	// Excel -> Descripción: 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Económico

	@OneToMany(mappedBy = "explotacion")
	private Set<Edificacion> edificaciones;  
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 
	// Aclaración: 
	// Excel -> Descripción: 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Datos de edificaciones e instalaciones

	@OneToMany(mappedBy = "explotacion")
	private Set<Maquina> maquinas;  
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> 
	// Aclaración: 
	// Excel -> Descripción: 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Datos de maquinaria y equipos

	@ManyToMany
	private Set<ExplotacionMedidaPreventivaCultural> medidasPreventivasCulturales;

	//#endregion

	

	//#region campos Cuaderno Campo Junta de Andalucia

	@Column(nullable = true)
	private String registroNacional; 

	@Column(nullable = true)
	private String direccion; 		
	
	@ManyToOne(optional = false)
	private Municipio municipio;

	@ManyToOne(optional = true)
	private PersonaContacto contacto;

	//#endregion

	

	
    @OneToMany(mappedBy = "explotacion")
	private Set<PersonaExplotacion> personasExplotacion;

}
