package es.agrobook.api.model.catastro;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SuperficieMotivoNoProductividad {
	
	@Id
	private short id;

    @Column(nullable = false, unique = true, length = 3)
	private String codigo;

    @Column(nullable = false)
	private String descripcion;



	// Entidades enlazadas

	@OneToMany(mappedBy = "areaNoProductiva")
	private Set<Superficie> superficies;

	/*
	
	Código SIEX	Código	Tipo
	1	ZNC	Zonas de no cosechado de cereal y oleaginosa (por 1m2)
	2	IB	Islas de biodiversidad (por 1 m2)
	3	MB	Márgenes de biodiversidad (por 1 m)
	4	LF	Lindes forestales (por 1 m)
	5	FP	Franjas de protección (por 1 m)
	6	ST	Setos/franjas arboladas (por 1 m)
	7	AB1	Árbol aislado
	8	AB2	Árboles en hilera
	9	AB3	Grupo de Árboles
	10	LD	Lindes de campo (1 m)
	11	CH	Charcas (charcas, lagunas, estanques y abrevaderos naturales) (por 1 m2)
	12	IS	Islas o Enclaves (Islas o enclaves de vegetación natural o roca) y majanos (por 1 m2)
	13	TR	Terrazas (terrazas de retención, bancales, ribazos) (por 1 m)
	14	MU	Muros de piedra
	15	CO	Pequeñas construcciones de arquitectura tradicional
	16	TBB	Tierras en barbecho de biodiversidad (incluidos los barbechos melíferos) (por 1 m2)
	17	TB	Tierras en barbecho (por 1 m2)
	18	ANS	Áreas de no siega
	19	ZNA	Zonas de no cosechado de aromáticas (por 1m2)







	 */
	
}
