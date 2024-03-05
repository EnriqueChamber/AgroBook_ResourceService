package es.agrobook.api.model.explotacion;

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
public class TipoExplotacion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

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
