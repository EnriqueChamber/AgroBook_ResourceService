package es.agrobook.api.model.catastro;

import java.sql.Date;
import java.util.Set;

import es.agrobook.api.model.enums.SuperficieTipo;
import es.agrobook.api.model.location.RecintoSigpac;
import es.agrobook.api.model.siembra.Siembra;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

	@ManyToOne(optional = true)
    private SuperficieTipo tipo; //DETALLE_ACTIVIDAD_AGRARIA.csv -> Ambito

    @Column(nullable = false)
	private boolean pastosComunes;

    @Column(nullable = false)
	private boolean dehesasComunes;

    @ManyToOne(optional = false)
	private RegimenTenencia regimenTenencia;

    @Column(nullable = true)
	private String nifArrendador;

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

	//#endregion

	


	// Entidades enlazadas

	@ManyToMany(mappedBy = "parcelasSigpac")
	private Set<SuperficieAgrupacion> agrupaciones;
	
	@OneToMany(mappedBy = "superficie")
    private Set<Siembra> siembras; 



	
}
