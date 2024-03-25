package es.agrobook.api.model.actividad.abonado;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.actividad.Actividad;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AbonadoPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	//#region campos SIEX

    @Column(nullable = false)
	private String nombre;

    @Column(nullable = false)
	private Date fechaInicio;

    @Column(nullable = true)
	private Date fechaFin;

	

	@OneToMany(mappedBy = "abonadoPlan")
	private Set<Actividad> actividades;

}