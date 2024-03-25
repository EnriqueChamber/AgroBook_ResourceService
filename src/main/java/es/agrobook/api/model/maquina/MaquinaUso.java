package es.agrobook.api.model.maquina;

import es.agrobook.api.model.actividad.Actividad;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MaquinaUso{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(nullable = false)
	private float horas;

    @ManyToOne(optional = false)
	private Maquina maquina;


	// Entidades enlazadas

    @ManyToOne(optional = false)
	private Actividad actividad;

}