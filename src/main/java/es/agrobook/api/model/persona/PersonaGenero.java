package es.agrobook.api.model.persona;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaGenero {
	
	@Id
	@Column(length = 1)
	private String codigo;
	
	@Column(nullable = false)
	private String descripcion;
	

	/*
	Código	Descripción
	I	Intersexual
	M	Mujer
	V	Varón
	0	Hombre
	1	Mujer
	2	no binario
	3	Priefiero no decirlo
	4	Sin prevalencia

	 */
}
