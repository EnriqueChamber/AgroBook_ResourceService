package es.agrobook.api.model.persona;

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
public class PersonaGenero {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 1)
	private String codigo;
	@Column(nullable = false, length = 64)
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
