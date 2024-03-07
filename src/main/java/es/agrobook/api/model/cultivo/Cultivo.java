package es.agrobook.api.model.cultivo;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.AplicacionTratamiento;
import es.agrobook.api.model.CausaBaja;
import es.agrobook.api.model.enums.TipoCertificacionEcologica;
import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.model.siembra.Siembra;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cultivo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(optional = false)
    private CultivoActividadAgraria actividadAgraria;

    @Column(nullable = false)
	private Date fechaInicio;

    @Column(nullable = true)
	private Date fechaFinalizacion;

    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoCertificacionEcologica certificacionEcologica;

    @Column(nullable = true)
	private boolean produccionIntegrada;

	@ManyToOne(optional = false)
	private CultivoSistemaCultivo sistemaCultivo;

	@ManyToOne(optional = false)
	private CultivoDestino destino;

	@ManyToOne(optional = false)
	private CultivoCoberturaSuelo coberturaSuelo;

	@ManyToOne(optional = false)
	private CultivoAprovechamiento aprovechamiento;

	@ManyToOne(optional = false)
    private CultivoSistemaExplotacion sistemaExplotacion;
	//private String secanoRegadio; 			// Solo Doc     //Secano (SEC), aspersión (ASP), goteo o localizado (LOC), por gravedad (GRA).

    @Column(nullable = true)
	private float superficie;

	@OneToMany(mappedBy = "cultivo")
    private Set<CultivoSuperficieNoProductiva> superficiesNoProductivas;



	@ManyToOne(optional = true)
	private CausaBaja causaBaja;

	@Column(nullable = true)
	private Date fechaBajaRea;
	

	// DATOS AGRONOMICOS - Cultivo
    @Column(nullable = false)
	private String ventilacion; 			// Solo Doc //Aire libre (AL), malla (M), cubierta bajo plástico (BP), invernadero (INV)
    
    @ManyToOne(optional = false)
	private Explotacion explotacion;

	

	@OneToMany(mappedBy = "cultivo")
    private Set<Siembra> siembras;

	@OneToMany(mappedBy = "cultivo")
    private Set<AplicacionTratamiento> aplicacionesTratamientos;
	



}