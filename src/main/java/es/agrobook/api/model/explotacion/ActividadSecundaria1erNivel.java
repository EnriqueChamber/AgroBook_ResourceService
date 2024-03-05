package es.agrobook.api.model.explotacion;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActividadSecundaria1erNivel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private byte id;

	@Column(nullable = false)
	private String descripcion;

	/*
	
	Código SIEX	Descripción
	1	Actividad de transformación realizada en la explotación
	2	Calibrado o acondicionamiento de productos
	3	Actividad Agroturística y Cinegética
	4	Servicios
	5	Otras actividades complementarias

	 */
	
}
