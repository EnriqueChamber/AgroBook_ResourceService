package es.agrobook.api.model;

import java.util.Date;

import es.agrobook.api.model.explotacion.Explotacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Maquina{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(nullable = false)
	private String descripcion;
	
	

	//#region campos SIEX

    @Column(nullable = false)
	private String noInscripcionRoma; // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Datos de maquinaria y equipos

	//#endregion
	

    @Column(nullable = false)
	private Date fechaAdquisicion;

    @Column(nullable = false)
	private Date fechaUltimaInspeccion;

    @ManyToOne(optional = false)
	private Explotacion explotacion;


	// Entidades enlazadas

}