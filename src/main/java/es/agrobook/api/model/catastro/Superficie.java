package es.agrobook.api.model.catastro;

import java.sql.Date;
import java.util.Set;

import es.agrobook.api.model.cultivo.CultivoCampanya;
import es.agrobook.api.model.enums.SuperficieTipo;
import es.agrobook.api.model.location.RecintoSigpac;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Superficie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private String nombre;


	//#region campos SIEX

	@ManyToOne(optional = true)
    private RecintoSigpac recintoSigpac; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies

    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
    private SuperficieTipo tipo; //DETALLE_ACTIVIDAD_AGRARIA.csv -> Ambito

	@ManyToOne(optional = false)
	private SuperficieAprovechamiento aprovechamiento;

    @Column(nullable = false)
	private boolean pastosComunes;

    @Column(nullable = false)
	private boolean dehesasComunes;

    @ManyToOne(optional = false)
	private RegimenTenencia regimenTenencia;

    @Column(nullable = true)
	private String nifArrendador;
	// Reemplazable posteriormente por Persona

    @Column(nullable = false)
	private float superficie;

    @Column(nullable = false)
	private String geometría;

    @Column(nullable = false)
	private Date fechaAltaDgc;

    @Column(nullable = true)
	private Date fechaBajaDgc;

	@ManyToOne(optional = true)
	private CausaBaja causaBaja;

	@ManyToOne(optional = true)
	private SuperficieMotivoNoProductividad motivoNoProductividad; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> Superficies y Elementos No productivos

	@ManyToOne(optional = true)
	private Superficie superficiePadre;

	//#endregion

	@ManyToMany
	private Set<CultivoCampanya> cultivosCampanyas;
	


	// Entidades enlazadas

	@OneToMany(mappedBy = "superficiePadre")
	private Set<Superficie> superficiesHijas;



	
}
