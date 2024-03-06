package es.agrobook.api.model;

import es.agrobook.api.model.cultivo.Cultivo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AplicacionTratamiento{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private String plaga;

    @Column(nullable = false)
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

	@ManyToOne(optional = false)
	private Cultivo cultivo;

}