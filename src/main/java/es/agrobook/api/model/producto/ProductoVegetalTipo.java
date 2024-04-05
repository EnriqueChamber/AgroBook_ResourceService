package es.agrobook.api.model.producto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductoVegetalTipo {

	@Id
	private Short id;

    @Column(nullable = false)
	private String descripcion;


	// Dependientes

	


	/*
	Código del tipo	Tipo de material vegetal de reproducción	Código	Detalle del tipo
	1	Certificada
	2	Estándar
	3	Comercial
	4	Reempleo
	5	Conformitas Agrarias Communitatis
	6	Identificada
	7	Seleccionada
	8	Cualificada
	9	Controlada
	10	Prebase
	11	Base
	12	Inicial
	13	Sin categoría


	 */
}