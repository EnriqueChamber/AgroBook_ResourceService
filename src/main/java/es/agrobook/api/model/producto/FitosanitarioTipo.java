package es.agrobook.api.model.producto;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FitosanitarioTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "tipo")
	private Set<Fitosanitario> fitosanitarios;


/*
	Código SIEX	Tipo de medida fitosanitaria
	1	Suelta de OCB
	2	Plantas banker o reservorio
	3	Colocación mallas anti-insectos
	4	Instalación de setos, márgenes funcionales o cubiertas temporales
	5	Falsa siembra
	6	Siembra directa
	7	Siembra en seco (arroz)
	8	Siega mecánica malas hierbas
	9	Laboreo eliminación de malas hierbas
	10	Solarización o biofumigación
	11	Usos de sustancias básicas
	12	Captura masiva a base de trampas luminosas 
	14	Trampas  y otros
	15	Feromonas y atrayentes para monitoreo

 */


}