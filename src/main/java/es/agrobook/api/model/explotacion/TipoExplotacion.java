package es.agrobook.api.model.explotacion;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TipoExplotacion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String descripcion;

	/*
	
	Código SIEX	Descripción
	2	Prioritaria
	3	Titularidad Compartida
	4	Cotitularidad
	5	Preferentes
	6	Ocio y Autoconsumo
	7	Singulares




	 */
	
}
