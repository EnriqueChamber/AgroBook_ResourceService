package es.agrobook.api.model.actividad;

import java.sql.Date;
import java.util.Set;

import es.agrobook.api.model.actividad.abonado.AbonadoBuenasPracticas;
import es.agrobook.api.model.actividad.abonado.AbonadoMetodoAplicacion;
import es.agrobook.api.model.actividad.abonado.AbonadoPlan;
import es.agrobook.api.model.actividad.abonado.AbonadoTipo;
import es.agrobook.api.model.actividad.colocacion.CoberturaTipo;
import es.agrobook.api.model.actividad.cosecha.CosechaDestino;
import es.agrobook.api.model.actividad.cosecha.CosechaDestinoRestos;
import es.agrobook.api.model.actividad.riego.RiegoBuenasPracticas;
import es.agrobook.api.model.catastro.Edificacion;
import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.enums.ActividadTipo;
import es.agrobook.api.model.maquina.MaquinaUso;
import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.model.producto.ProductoUso;
import es.agrobook.api.model.producto.ProductoVegetal;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Actividad{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
    @Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = ActividadTipo.class)
	@Column(nullable = false)
	private Set<ActividadTipo> tipos; //COLOCACION, RECOLECCION, RIEGO, ABONADO, TRATAMIENTO, LABOREO, VENTA, ANALISIS

	@Column(nullable = false)
	private Date fechaInicio;

	@Column(nullable = true)
	private Date fechafin;

	@ManyToOne(optional = true)
	private Persona realizador; // Aplicador, 

	@ManyToOne(optional = true)
	private Persona implicado; // Asesor, comprador, 

    @OneToMany(mappedBy = "actividad")
	private Set<MaquinaUso> usosMaquinas;




	//#region Datos de Colocacion

	@ManyToOne(optional = true)
	private ProductoUso colocacionProductoUso; // Producto genérico en caso de ser cubierta

	@Column(nullable = true)
	private String marcoPlantacion;

	@ManyToOne(optional = true)
	private CoberturaTipo coberturaTipo; // Producto genérico en caso de ser cubierta

	// Siembra directa como Tratamiento Fitosanitario

	//#endregion


	
	//#region Datos de Recoleccion

	@ManyToOne(optional = true)
	private ProductoUso recoleccionProductoUso;

	@ManyToOne(optional = true)
	private CosechaDestino destinoCosecha;

	@ManyToOne(optional = true)
	private CosechaDestinoRestos destinoCosechaRestos;

	//#endregion



	//#region Datos de Riego

	// Comunidad de Regantes -> asociado a explotacion
	// Sistema de riego asociado a CultivoCampaña
	// Procedencia del agua asociada a CultivoCampaña
	// Contador de sistema de riego asociado a CultivoCampaña

	@Column(nullable = true)
	private float riegoCantidad;

	@Column(nullable = true)
	private float nNitricoEnAgua;

	@Column(nullable = true)
	private float p2o5EnAgua;

	@ManyToOne(optional = false)
	private RiegoBuenasPracticas riegoBuenasPracticas;
	
	//#endregion



	//#region Datos de Abonado

	@ManyToOne(optional = true)
	private ProductoUso abonadoProductoUso;

	@ManyToOne(optional = false)
	private AbonadoBuenasPracticas abonadoBuenasPracticas;

	@ManyToOne(optional = false)
	private AbonadoMetodoAplicacion abonadoMetodoAplicacion;

	@ManyToOne(optional = false)
	private AbonadoPlan abonadoPlan;

	@ManyToOne(optional = false)
	private AbonadoTipo abonadoTipo;

	//#endregion



	//#region Datos de Tratamiento

	@ManyToOne(optional = true)
	private ProductoUso tratamientoProductoUso;

	//#endregion



	//#region Entidades sobre las que se realiza la Actividad

	@ManyToOne(optional = true)
	private ProductoVegetal productoVegetal;

	@ManyToOne(optional = true)
	private Superficie superficie;

	@ManyToOne(optional = true)
	private Edificacion edificacion;

	//#endregion




	// Entidades enlazadas

}