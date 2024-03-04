package es.agrobook.api.model.location;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ComunidadAutonoma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private int id;

	@Column(nullable = false)
	private String descripcion;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
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
