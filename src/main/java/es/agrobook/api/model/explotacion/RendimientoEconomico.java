package es.agrobook.api.model.explotacion;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RendimientoEconomico {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private int anyo;

	@Column(nullable = false)
	private float ingresosTitular;

	@Column(nullable = false)
	private float ingresosExplotacion;

	
    @ManyToOne
	private Explotacion explotacion;


	/*
	
	Código SIEX	Descripción
	1	Cambio de titularidad
	2	Desistimiento
	3	Fusión de explotaciones
	4	Baja de oficio
	5	Error material
	6	Incidencia en controles
	7	Cambio a aprovechamiento
	8	Error material
	9	Cambio de geometría
	10	Venta
	11	Arrendamiento a un tercero
	12	Finalización del arrendamiento
	13	Incidencia en controles
	14	Error material
	15	Baja de oficio
	16	Baja de oficio





	 */
	
}
