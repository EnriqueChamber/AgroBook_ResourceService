package es.agrobook.api.model.cultivo;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CultivoDestino {

	@Id
	private byte codigo;

    @Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "destino")
	private Set<Cultivo> cultivos;


	/*
	Código SIEX	Destino del cultivo
	1	Consumo humano en fresco
	2	Consumo humano en seco
	3	Consumo animal 
	4	Forrajero
	5	Forraje deshidratado
	6	Semillas para siembra
	7	Semillas certificadas para siembra
	8	Plantas, plantones o partes de planta para cultivo y/o reproducción
	9	Ensilado
	10	Semillas destinadas a la producción de brotes
	11	Semillas germinadas excepto brotes (shoots o cress)
	12	Leña
	13	Corcho
	14	Resina
	15	Sidra
	16	Pimentón
	17	Fibra
	18	Aceite
	19	Medicinal
	20	Industria cosmética 
	21	Energía renovable
	22	Vinificación
	23	Otro procesamiento industrial
	24	Henificado 
	25	Uso experimental
	26	Biomasa
	27	Madera
	28	Secado de la planta por comercialización
	29	Combinado: Industrial u otros más secado




	
	 */
}