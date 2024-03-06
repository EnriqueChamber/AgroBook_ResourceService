package es.agrobook.api.model;

import java.util.Date;
import java.util.Set;

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

    @Column(nullable = false)
	private String noInscripcionRoma;

    @Column(nullable = false)
	private Date fechaAdquisicion;

    @Column(nullable = false)
	private Date fechaUltimaInspeccion;


	// Entidades enlazadas

	@ManyToMany
	private Set<Explotacion> explotaciones;

}