package es.agrobook.api.model.cultivo;

import java.util.Set;

import es.agrobook.api.model.enums.TipoCertificacionEcologica;
import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.model.producto.ProductoVegetalEstadoFenologico;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cultivo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	//#region campos SIEX

    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoCertificacionEcologica produccionEcologica; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Regímenes de Calidad -> Certificado Produccion Ecológica

	@ManyToOne(optional = false)
	private Persona empresaCertificadoraProduccionEcologica; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Regímenes de Calidad -> Certificado Produccion Ecológica

    @Column(nullable = true)
	private boolean produccionIntegrada; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Regímenes de Calidad -> Producción Integrada

	@ManyToOne(optional = false)
	private Persona empresaCertificadoraProduccionIntegrada; 
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Regímenes de Calidad -> Producción Integrada

	@ManyToOne(optional = true)
	private DenominacionOrigen denominacionOrigen; 

	@ManyToOne(optional = true)
	private Persona certificadorDenominacionOrigen; 

	/*@Column(nullable = false)
	private String codigoSiex;*/
	// Cultivo.Especie.CódigoSIEX
	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies (No existe Catálogo)

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

	@ManyToOne(optional = false)
	private CultivoDestino destino; 
	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos adicionales de Cultivos

	@ManyToOne(optional = false)
	private CultivoSistemaCultivo sistemaCultivo; 
	// SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos adicionales de Cultivos

	//#endregion


	

	@ManyToOne(optional = true)
	private ProductoVegetalEstadoFenologico estadoFenologico; 
	
	//#region campos Cuaderno Campo Junta de Andalucia
	//private String secanoRegadio; 			// Solo Doc     //Secano (SEC), aspersión (ASP), goteo o localizado (LOC), por gravedad (GRA).

    @Column(nullable = true)
	private float superficie;
	

	// DATOS AGRONOMICOS - Cultivo
    @Column(nullable = false)
	private String ventilacion; 			// Solo Doc //Aire libre (AL), malla (M), cubierta bajo plástico (BP), invernadero (INV)
	
	//#endregion


	// Entidades enlazadas

	@OneToMany(mappedBy = "cultivo")
	private Set<CultivoCampanya> cultivosCampanyas;
}