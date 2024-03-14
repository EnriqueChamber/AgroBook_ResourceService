package es.agrobook.api.model.maquina;

import java.util.Date;

import es.agrobook.api.model.tratamiento.Tratamiento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MaquinaUso{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(nullable = false)
	private String descripcion;
	
	

	//#region campos SIEX

    @Column(nullable = false)
	private String noInscripcionRoma;
	// SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Datos de maquinaria y equipos

	//#endregion

    @ManyToOne(optional = false)
	private Maquina maquina;


	// Entidades enlazadas

    @ManyToOne(optional = true)
	private Tratamiento tratamiento;

}