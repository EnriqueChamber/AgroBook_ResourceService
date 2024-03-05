package es.agrobook.api.model.explotacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActividadSecundaria2doNivel {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private int codigoIne;

	@Column(nullable = false)
	private String descripcion;

	@OneToOne()
	private ActividadSecundaria1erNivel actividad;

	/*
	
	Código: primer nivel	Tipo de actividad: primer nivel	Código: segundo nivel	Tipo de actividad: segundo nivel
	1	Actividad de transformación realizada en la explotación	1	Productos Agrarios
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos
	1	Actividad de transformación realizada en la explotación	3	Productos Cárnicos
	1	Actividad de transformación realizada en la explotación	4	Trenzados e hilados
	1	Actividad de transformación realizada en la explotación	5	Otros Productos
	2	Calibrado o acondicionamiento de productos	1	Calibrado y acondicionamiento de productos
	3	Actividad Agroturística y Cinegética	1	Restauración
	3	Actividad Agroturística y Cinegética	2	Alojamiento
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas
	3	Actividad Agroturística y Cinegética	4	Caza
	4	Servicios	1	A terceros
	4	Servicios	2	Conservación del paisaje
	5	Otras actividades complementarias	1	Energías Renovables
	5	Otras actividades complementarias	2	Otras actividades en que se utilizan la tierra y los medios de producción agraria




	3	Actividad Agroturística y Cinegética	1	Restauración






	 */
	
}
