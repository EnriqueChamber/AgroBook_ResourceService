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
public class TipoTitular {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descripcion;

	/*
	
	Código SIEX	Forma jurídica
	1	SAT
	2	Cooperativa agroalimentaria
	3	Sociedad civil sin objeto mercantil
	4	Comunidad de bienes
	5	Otras personas jurídicas
	6	Herencia yacente
	7	Persona física
	8	Cooperativa Uso en común de la tierra
	9	Cooperativa trabajo asociado
	10	Cooperativa de otro tipo
	11	Sociedad civil con objeto mercantil
	12	Sociedad mercantil
	13	Titularidad compartida
	14	Otra agrupación de personas fisicas
	15	Sociedad limitada
	16	Sociedad anónima
	17	Administración
	18	Asociación 



	 */
	
}
