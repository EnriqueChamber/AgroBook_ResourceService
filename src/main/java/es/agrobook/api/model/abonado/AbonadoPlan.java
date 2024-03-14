package es.agrobook.api.model.abonado;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

	

	@OneToMany(mappedBy = "planAbonado")
	private Set<Abonado> abonados;

}