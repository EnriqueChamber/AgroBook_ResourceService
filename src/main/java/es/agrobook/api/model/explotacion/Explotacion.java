package es.agrobook.api.model.explotacion;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import es.agrobook.api.model.Cultivo;
import es.agrobook.api.model.Maquina;
import es.agrobook.api.model.location.Municipio;
import es.agrobook.api.model.location.Parcela;
import es.agrobook.api.model.persona.PersonaContacto;
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
	private PersonaContacto contacto;

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

	@Column(nullable = true)
	private Date fechaBajaRea;
	
	@ManyToOne(optional = false)
	private CausaBaja causaBaja;

	@ManyToOne(optional = false)
	private TipoExplotacion clasificacion;

	@Column(nullable = true)
	private Date fechaClasificacion;

    @ManyToMany
	private Set<Parcela> parcelas;

    @OneToMany(mappedBy = "explotacion")
    private Set<PersonaExplotacion> personasExplotacion;
	
    @OneToMany(mappedBy = "explotacion")
	private Set<Cultivo> cultivos;

    @ManyToMany
	private Set<Maquina> maquinaria;

	

    @OneToMany(mappedBy = "explotacion")
    private Set<ActividadSecundaria> actividadesSecundarias;

    @OneToMany //(mappedBy = "explotacion") Desacoplado para que sea aplicable en el futuro a Actividades Secundarias
	private Set<RendimientoEconomico> rendimientoEconomicos;

	
	
	private String rutaImagen;

	
}
