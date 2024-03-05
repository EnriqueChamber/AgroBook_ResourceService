package es.agrobook.api.model.explotacion;

import org.hibernate.annotations.Collate;

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
public class ActividadSecundaria1erNivel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private int codigoIne;

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
