package es.agrobook.api.model.explotacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CausaBaja {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String descripcion;

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
