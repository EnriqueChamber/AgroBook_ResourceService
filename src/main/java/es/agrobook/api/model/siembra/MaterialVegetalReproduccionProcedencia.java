package es.agrobook.api.model.siembra;

import java.util.Set;

import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.enums.TipoMVR;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MaterialVegetalReproduccionProcedencia {

	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;


	// Dependientes

	


	/*
	Código SIEX	Procedencia del material vegetal
	1	Banco de germoplasma/recursos fitogenéticos
	2	Material de la propia explotación
	3	Material de un obtentor no registrado en ROPVEG


	 */
}