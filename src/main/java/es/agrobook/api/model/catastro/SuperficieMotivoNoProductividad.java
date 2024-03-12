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
	
	Código SIEX	Descripción
	1	Cambio de titularidad De la explotación
	2	Desistimiento De la explotación
	3	Fusión de explotaciones De la explotación
	4	Baja de oficio De la explotación
	5	Error material De la explotación
	6	Incidencia en controles Del cultivo
	7	Cambio a aprovechamiento Del cultivo
	8	Error material Del cultivo
	9	Cambio de geometría De la DGC
	10	Venta De la DGC
	11	Arrendamiento a un tercero De la DGC
	12	Finalización del arrendamiento De la DGC
	13	Incidencia en controles De la DGC
	14	Error material De la DGC
	15	Baja de oficio Del cultivo
	16	Baja de oficio De la DGC






	 */
	
}
