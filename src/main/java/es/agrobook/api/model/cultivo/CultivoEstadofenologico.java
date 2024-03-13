package es.agrobook.api.model.cultivo;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CultivoEstadofenologico {

	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "estadoFenologico")
	private Set<Cultivo> cultivos;


	/*
	Código SIEX	Estadio bibliografía	Estado fenológico
	1	0	Germinación, brotación, desarrollo de la yema
	2	1	Desarrollo de las hojas (brote o tallo principal)
	3	2	Formación de brotes laterales/ macollamiento (ahijamiento)
	4	3	Crecimiento longitudinal del tallo o crecimiento en roseta, desarrollo de brotes (retoños)/ encañado (tallo principal)
	5	4	Desarrollo de las partes vegetativas cosechables de la planta o de órganos vegetativos de propagación/ embuchamiento
	6	5	Emergencia de la inflorescencia (tallo principal)/ espigamiento
	7	6	Floración (tallo principal)
	8	7	Desarrollo del fruto
	9	8	Coloración o maduración de frutos y semillas
	10	9	Senescencia, comienzo de la dormancia




	
	 */
}