package es.agrobook.api.model.cultivo;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CultivoSistemaCultivo {

	@Id
	private Short id;

    @Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "sistemaCultivo")
	private Set<Cultivo> cultivos;


	/*
	Código SIEX	Sistema de cultivo
	1	Aire libre
	2	Malla
	3	Cubierta no accesible
	4	Invernadero (cubierta accesible)
	5	Forestales en rotacion corta
	6	Micorrizado
	7	Acolchado
	8	Enarenado
	9	Bodega Sacos
	10	Bodega Bandejas
	11	Bodega Botellas
	12	Bodega Otros
	13	Nave Sacos
	14	Nave Bandejas
	15	Nave Botellas
	16	Nave Otros
	17	Hoyos
	18	Zanjas
	19	Invernadero (cubierta accesible)+ enarenado



	
	 */
}