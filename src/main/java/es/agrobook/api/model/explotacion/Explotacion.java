package es.agrobook.api.model.explotacion;

import java.sql.Date;
import java.util.Set;

import es.agrobook.api.model.CausaBaja;
import es.agrobook.api.model.Maquina;
import es.agrobook.api.model.RendimientoEconomico;
import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.edificacion.Edificacion;
import es.agrobook.api.model.location.Municipio;
import es.agrobook.api.model.location.ParcelaSigpac;
import es.agrobook.api.model.persona.Contacto;
import es.agrobook.api.model.persona.PersonaExplotacion;
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

	@Column(nullable = false)
	private String nif;

	@Column(nullable = false)
	private String registroAutonomico; 

	@Column(nullable = false)
	private Date fechaInstripcionRea; 

	private String registroNacional; 

	@Column(nullable = false)
	private String direccion; 		
	
	@ManyToOne(optional = false)
	private Municipio municipio;

	@ManyToOne(optional = false)
	private Contacto contacto;

	// Indicadores REA
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
	


	@ManyToOne(optional = true)
	private CausaBaja causaBaja;

	@Column(nullable = true)
	private Date fechaBajaRea;

	

	@ManyToOne(optional = false)
	private ExplotacionClasificacion clasificacion;

	@Column(nullable = true)
	private Date fechaClasificacion;

    @ManyToMany
	private Set<ParcelaSigpac> parcelasSigpac;

    @OneToMany(mappedBy = "explotacion")
    private Set<PersonaExplotacion> personasExplotacion;
	
    @OneToMany(mappedBy = "explotacion")
	private Set<Cultivo> cultivos;

    @ManyToMany
	private Set<Maquina> maquinas;

    @ManyToMany
	private Set<Edificacion> edificaciones;

	

    @OneToMany(mappedBy = "explotacion")
    private Set<ExplotacionActividadSecundaria> actividadesSecundarias;

    @OneToMany //(mappedBy = "explotacion") Desacoplado para que sea aplicable en el futuro a Actividades Secundarias
	private Set<RendimientoEconomico> rendimientosEconomicos;

	
	
	private String rutaImagen;

	
}
