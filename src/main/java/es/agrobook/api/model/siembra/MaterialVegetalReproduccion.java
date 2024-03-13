package es.agrobook.api.model.siembra;

import java.util.Date;

import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.cultivo.CultivoEstadofenologico;
import es.agrobook.api.model.enums.TipoCertificacionEcologica;
import es.agrobook.api.model.maquina.Maquina;
import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.model.tratamiento.Tratamiento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MaterialVegetalReproduccion{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	//#region campos SIEX

	@ManyToOne(optional = false)
	private MaterialVegetalReproduccionTipo tipo; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos

	@ManyToOne(optional = false)
    private Persona productor; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies-> Datos adicionales de Cultivos

	@ManyToOne(optional = true)
    private Persona proveedor; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies-> Datos adicionales de Cultivos

	@ManyToOne(optional = true)
	private MaterialVegetalReproduccionProcedencia procedencia; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos

    @Column(nullable = true)
	private String noLote; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos adicionales de Cultivos

    @Column(nullable = true)
	private String pasaporte; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos adicionales de Cultivos

    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoCertificacionEcologica produccionEcologica; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies-> Datos adicionales de Cultivos

	@OneToOne
	private Tratamiento tratamiento;

	//#endregion

	@ManyToOne(optional = false)
    private Variedad variedad;

	//@ManyToOne(optional = false)
	//private CultivoEstadofenologico estadofenologico; 
	// Contemplado para crear un único ProductoVegetal que evolucione en estado fenológico y referencie el origen.
	// Por ejemplo: Producto vegetal comprado (Semilla), evoluciona su estado fenologico hasta generar una cosecha en su último estado fenologico.
	// En caso de que en la cosecha o previamente se haya obtenido material vegetal de reproducción del producto vegetal del cultivo, se crea un producto vegetal derivado.
	// Dependiendo del estado fenologico del producto obtenido derivado, puede ser semilla, parte de planta o planta.

}