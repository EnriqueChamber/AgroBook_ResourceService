package es.agrobook.api.model.location;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ComunidadAutonoma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne(optional = false)
	private Pais pais;
	

	/*
	Id	Descripción
	1	ANDALUCIA
	2	ARAGÓN
	3	PRINCIPADO DE ASTURIAS
	4	ISLAS BALEARES
	5	ISLAS CANARIAS
	6	CANTABRIA
	7	CASTILLA LA MANCHA
	8	CASTILLA Y LEÓN
	9	CATALUÑA
	10	EXTREMADURA
	11	GALICIA
	12	COMUNIDAD DE MADRID
	13	REGION DE MURCIA
	14	COMUNIDAD FORAL DE NAVARRA
	15	PAIS VASCO
	16	LA RIOJA
	17	COMUNIDAD VALENCIANA
	 */
}
