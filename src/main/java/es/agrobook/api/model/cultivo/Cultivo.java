package es.agrobook.api.model.cultivo;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.AplicacionTratamiento;
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
	

	//#region campos SIEX

    /*@ManyToOne(optional = false)
	private CultivoTipo cultivo; */  // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies (No existe Catálogo)

	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> Variedad Especie y Tipo
	// Determinado por la/s siembra/s

	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> Fecha Inicio y fin
	// Determinado por la campaña -> primera fecha de actividad (Preparación o Siembra) y la úlitma (Cosecha/Recolección)

	@ManyToOne(optional = false)
    private CultivoSistemaExplotacion sistemaExplotacion;

	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> Coeficiente de Subvencionalidad de Pastos (CSP) y Superficie CSP
	// Determinado por los Recintos asociados a las superficies asociadas al cultivo

	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> Superficies y Elementos No productivos (Motivo No Productividad)
	// Determinado por los Recintos asociados a las superficies asociadas al cultivo. La superficie incluye el Catálogo SIEX

	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> causa Baja
	// Determinado por las superficies asociadas al cultivo. ¿En qué momento se le ocurrió a alguien asignar una causa de baja de Catastro a un cultivo y no a su superficie o recinto?

	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> fecha Baja
	// Determinado por las superficies asociadas al cultivo. Igual que Causa Baja

	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> fecha fin campaña agricola. ?¿?¿ Diferencia entre fecha fin ?¿?¿
	// Determinado por la campaña -> primera fecha de actividad (Preparación o Siembra) y la úlitma (Cosecha/Recolección)

	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos -> Material Vegetal de Reproducción y Tipo. Empresa produtora de semilla cert. Num Proveedor del material vegetal.
	// Determinado por la/s siembra/s

	//#endregion

	
	@OneToMany(mappedBy = "cultivo")
    private Set<Siembra> siembras; 


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
	//private String secanoRegadio; 			// Solo Doc     //Secano (SEC), aspersión (ASP), goteo o localizado (LOC), por gravedad (GRA).

    @Column(nullable = true)
	private float superficie;

	@OneToMany(mappedBy = "cultivo")
    private Set<CultivoSuperficieNoProductiva> superficiesNoProductivas;
	

	// DATOS AGRONOMICOS - Cultivo
    @Column(nullable = false)
	private String ventilacion; 			// Solo Doc //Aire libre (AL), malla (M), cubierta bajo plástico (BP), invernadero (INV)
    
    @ManyToOne(optional = false)
	private Explotacion explotacion;

	


	@OneToMany(mappedBy = "cultivo")
    private Set<AplicacionTratamiento> aplicacionesTratamientos;
	




	// Entidades enlazadas

	@OneToMany(mappedBy = "cultivo")
	private Set<CultivoCampanya> campanyas; // Determina Fecha inicio y fin: SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies
}