package es.agrobook.api.model.tratamiento;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.cultivo.CultivoEstadofenologico;
import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.model.maquina.Maquina;
import es.agrobook.api.model.maquina.MaquinaUso;
import es.agrobook.api.model.siembra.MaterialVegetalReproduccion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tratamiento{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	//#region campos SIEX

    @Column(nullable = false)
	private Date fechaInicio;

    @Column(nullable = true)
	private Date fechaFin;
	
	@ManyToOne
	private Set<MaquinaUso> usosMaquinaria;

    @Column(nullable = false)
	private boolean simbraDirecta;

    @Column(nullable = false)
	private float cantidadSemillaArboles;

    @Column(nullable = false)
	private float dosisSemillaDensidad; // kg/ha ó planta/ha

    @Column(nullable = true)
	private String marcoPlantacion;


	/*@ManyToOne(optional = false)
    private Variedad variedad;*/ // Determinado por el materialVegetalReproduccion

	@ManyToOne(optional = false)
	private MaterialVegetalReproduccion materialVegetalReproduccion; // SIEX -> Contenido REA -> INFORMACION POR SUPERFICIES -> Datos de superficies -> Datos de Cultivos


	@ManyToOne(optional = false)
	private Cultivo cultivo;

	@ManyToOne(optional = false)
	private Superficie superficie;


}