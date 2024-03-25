package es.agrobook.api.model.catastro;

import java.util.Set;

import es.agrobook.api.model.cultivo.Cultivo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SuperficieAprovechamiento {

	@Id
	private Short id;

    @Column(nullable = false)
	private String aprovechamiento;

    @Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "aprovechamiento")
	private Set<Superficie> superficies;


	/*
	Código SIEX	Aprovechamiento	Descripción
	1	Subproductos Pastables	Superficie destinada a la alimentación del ganado mediante consumo directo en el campo de cultivo (Rastrojo de cereal, hortofrutícolas, barbechos)
	2	Forestal de la dehesa (vuelo)	Actividad forestal realizada en los árboles que se encuentran asociados a superficies de cultivo (tierra arable con árboles dispersos) o de pasto. 
	3	Corredores	Superficie destinada a mejorar las condiciones de alimentación y reproducción de la fauna en superficies agrarias 
	4	Cinegético 	Aprovechamiento relacionado con la caza
	5	Ni agrario ni forestal	Antiguo código de producto “150 OTRAS UTILIZACIONES NO AGRARIAS NI FORESTALES”
	6	Frutales en prados de siega	
	7	Actividad agraria realizada por un tercero	


	
	 */
}