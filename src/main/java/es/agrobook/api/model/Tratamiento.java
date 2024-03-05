package es.agrobook.api.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tratamiento{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String plaga;

	private String justificacionActuacion;

	// ALTERNATIVAS NO QUIMICAS
	// Tipo de Medida
	// Intensidad de la medida
	// Rango de fechas de actuacion

	// ALTERNATIVAS QUIMICAS
	// Nombre comercial
	// Numero de Registro
	// Dosis empleada + unidad de Medida (KG/L)
	// Rango de fechas de actuacion

	private String eficacia;
	private String observaciones;


    @ManyToOne
	@MapsId()
	private Cultivo cultivo;

}