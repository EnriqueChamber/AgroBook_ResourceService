package es.agrobook.api.model.explotacion;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActividadSecundaria1erNivel {
	
	@Id
	private byte id;

	@Column(nullable = false)
	private String descripcion;

	@OneToMany(mappedBy = "actividad1erNivel")
    private Set<ActividadSecundaria2doNivel> actividades2doNivel;

	/*
	
	Código SIEX	Descripción
	1	Actividad de transformación realizada en la explotación
	2	Calibrado o acondicionamiento de productos
	3	Actividad Agroturística y Cinegética
	4	Servicios
	5	Otras actividades complementarias

	 */
	
}
