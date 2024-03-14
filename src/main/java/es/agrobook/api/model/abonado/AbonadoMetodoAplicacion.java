package es.agrobook.api.model.abonado;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AbonadoMetodoAplicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "tipo")
	private Set<Abono> abonos;


/*
	Código SIEX	Método de fertilización
1	Esparcido general
2	Esparcido general y enterrado
3	Esparcido localizado
4	Esparcido localizado y enterrado
5	Riego por aspersión (fertirrigación)
6	Riego localizado (fertirrigación)
7	Aplicación foliar

 */


}