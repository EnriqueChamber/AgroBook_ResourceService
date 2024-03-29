package es.agrobook.api.model.siembra;

import java.util.Set;

import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.enums.TipoMVR;
import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(MaterialVegetalReproduccionTipo.MaterialVegetalReproduccionTipoId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MaterialVegetalReproduccionTipo {

	@Id
	private byte id;

	@Id
    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoMVR tipo;

    @Column(nullable = false)
	private String descripcion;


	// Dependientes

	@OneToMany(mappedBy = "materialVegetalReproduccion")
	private Set<Cultivo> cultivos;

	

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class MaterialVegetalReproduccionTipoId {
        private byte id;
        private TipoMVR tipo;
    }


	/*
	Código del tipo	Tipo de material vegetal de reproducción	Código	Detalle del tipo
	1	Semilla	1	Certificada
	1	Semilla	2	Estándar
	1	Semilla	3	Comercial
	1	Semilla	4	Reempleo
	1	Semilla	6	Identificada
	1	Semilla	7	Seleccionada
	1	Semilla	8	Cualificada
	1	Semilla	9	Controlada
	1	Semilla	10	Prebase
	1	Semilla	11	Base
	1	Semilla	13	Sin categoría
	2	Planta	1	Certificada
	2	Planta	2	Estándar
	2	Planta	5	Conformitas Agrarias Communitatis
	2	Planta	6	Identificada
	2	Planta	7	Seleccionada
	2	Planta	8	Cualificada
	2	Planta	9	Controlada
	2	Planta	11	Base
	2	Planta	12	Inicial
	2	Planta	13	Sin categoría
	3	Parte de planta	1	Certificada
	3	Parte de planta	2	Estándar
	3	Parte de planta	5	Conformitas Agrarias Communitatis
	3	Parte de planta	7	Seleccionada
	3	Parte de planta	8	Cualificada
	3	Parte de planta	9	Controlada
	3	Parte de planta	11	Base
	3	Parte de planta	12	Inicial
	3	Parte de planta	13	Sin categoría

	 */
}