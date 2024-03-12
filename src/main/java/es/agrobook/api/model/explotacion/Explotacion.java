package es.agrobook.api.model.explotacion;

import java.sql.Date;
import java.util.Set;

import es.agrobook.api.model.Maquina;
import es.agrobook.api.model.RendimientoEconomico;
import es.agrobook.api.model.catastro.CausaBaja;
import es.agrobook.api.model.catastro.Edificacion;
import es.agrobook.api.model.location.Municipio;
import es.agrobook.api.model.persona.PersonaContacto;
import es.agrobook.api.model.riego.RiegoComunidadRegantes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Explotacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nombre;

	//#region campos SIEX

	@Column(nullable = false)
	private String registroAutonomico; 

	@Column(nullable = false)
	private Date fechaInstripcionRea; 

	@Column(nullable = true)
	private boolean jovenAgricultor;

	@Column(nullable = true)
	private boolean inicioActividadAgraria;

	@Column(nullable = true)
	private boolean ocioAutoconsumo;

	@Column(nullable = true)
	private boolean autocontrol;

	@Column(nullable = true)
	private boolean ventaDirecta;

	@Column(nullable = true)
	private Date fechaBajaRea; 

	@ManyToOne(optional = true)
	private CausaBaja causaBaja;

	@ManyToOne(optional = false)
	private ExplotacionClasificacion clasificacion;

	@Column(nullable = false)
	private Date fechaClasificacion;

	@Column(nullable = true)
	private RiegoComunidadRegantes comunidadRegantes;

	/*@Column(nullable = true)
	private Persona entidadHabilitadaRea;

	@Column(nullable = true)
	private Persona entidadHabilitadaCue;

	@Column(nullable = true)
	private String cueComercial; -> AgroBook*/
	
	
    @OneToMany(mappedBy = "explotacion")
    private Set<ExplotacionActividadSecundaria> actividadesSecundarias;  // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Actividad Secundaria ligada a la actividad agraria

	@OneToMany //(mappedBy = "explotacion") Desacoplado para que sea aplicable a Actividades Secundarias
	private Set<RendimientoEconomico> rendimientosEconomicos;  // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Económico

	@OneToMany(mappedBy = "explotacion")
	private Set<Edificacion> edificaciones;  // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Datos de edificaciones e instalaciones

	@OneToMany(mappedBy = "explotacion")
	private Set<Maquina> maquinas;  // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Datos de maquinaria y equipos

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

}
