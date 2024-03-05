package es.agrobook.api.model.persona;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CapacitacionProfesional {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String descripcion;

	/*
	
	Código SIEX	Capacitación profesional
	1	Sólo experiencia práctica agraria
	2	Cursos de formación agraria
	3	Formación profesional agraria
	4	Estudios universitarios y/o Superiores agrarios


	 */
	
}
