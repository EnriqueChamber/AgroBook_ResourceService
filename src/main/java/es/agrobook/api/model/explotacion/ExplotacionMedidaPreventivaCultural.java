package es.agrobook.api.model.explotacion;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExplotacionMedidaPreventivaCultural {
	// SIEX -> Catálogos -> Clasificacíon de la explotación -> CLASIFICACION_EXPLOTACION.csv
	
	@Id
	private byte id;

	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@ManyToMany(mappedBy = "medidasPreventivasCulturales")
	private Set<Explotacion> explotaciones;

	/*
	
	Código SIEX	Medida
1	Rotación de cultivos
2	Utilización de técnicas de cultivo adecuadas (técnica de la falsa siembra, fechas y densidades de siembra, baja dosis de siembra, mínimo laboreo, poda y siembra directa, etc.)
3	Utilización de variedades resistentes
4	Utilización de prácticas de fertilización adecuadas
5	Prevención de la propagación de organismos nocivos mediante medidas profilácticas (limpieza periódica de maquinaria y equipos, etc.)
6	Protección de los organismos beneficiosos (con medidas fitosanitarias específicas, utilizando infraestructuras ecológicas que aumenten la biodiversidad, estableciendo márgenes multifuncionales para la mejora de la biodiversidad y fomento de la fauna útil, etc.)
7	Monitoreo de plagas, enfermedades y malas hierbas.
8	Establecimiento de umbrales de intervención fitosanitaria.
9	Aplicación de medios no químicos (captura masiva, confusión sexual, lucha biológica, prácticas culturales para la desinfección de suelos, etc.).
10	Aplicación de productos fitosanitarios de bajo riesgo.
11	Seguimiento de una estrategia anti-resistencias en el uso de productos fitosanitarios.
12	Seguimiento de la efectividad de la intervención fitosanitaria.
13	Asesoramiento por un asesor en GIP o pertenencia a ATRIA, ADV o figuras equivalentes.
14	Inscripción en un sistema de avisos fitosanitarios (Estaciones de avisos) o mediante DSS (Decision Support System/ ayudas a la toma de decisión). 





	 */
	
}
