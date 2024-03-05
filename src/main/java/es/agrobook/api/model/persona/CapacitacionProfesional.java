package es.agrobook.api.model.persona;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CapacitacionProfesional {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descripcion;

	/*
	
	Código SIEX	Capacitación profesional
	1	Sólo experiencia práctica agraria
	2	Cursos de formación agraria
	3	Formación profesional agraria
	4	Estudios universitarios y/o Superiores agrarios


	 */
	
}
