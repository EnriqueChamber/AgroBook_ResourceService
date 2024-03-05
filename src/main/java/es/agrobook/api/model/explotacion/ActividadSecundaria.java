package es.agrobook.api.model.explotacion;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActividadSecundaria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String descripcion;

	@ManyToOne(optional = false)
	private ActividadSecundaria3erNivel actividad;

    @ManyToOne(optional = false)
	private Explotacion explotacion;


    @OneToOne
	private RendimientoEconomico rendimientoEconomicos;




	/*
	
	Código: primer nivel	Tipo de actividad: primer nivel	Código: segundo nivel	Tipo de actividad: segundo nivel	Código: tercer nivel	Tipo de actividad: tercer nivel
	1	Actividad de transformación realizada en la explotación	1	Productos Agrarios	1	Zumos de fruta
	1	Actividad de transformación realizada en la explotación	1	Productos Agrarios	2	Conservas
	1	Actividad de transformación realizada en la explotación	1	Productos Agrarios	3	Mermelada
	1	Actividad de transformación realizada en la explotación	1	Productos Agrarios	4	Bebidas alcohólicas
	1	Actividad de transformación realizada en la explotación	1	Productos Agrarios	5	Uva mosto vino en productos alcohólicos
	1	Actividad de transformación realizada en la explotación	1	Productos Agrarios	6	Otros productos agrarios
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos	1	Leche de consumo
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos	2	Nata
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos	3	Mantequilla
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos	4	Queso sin mezcla
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos	5	Queso con mezcla
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos	6	Yogurt
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos	7	Otros equivalentes de la leche
	1	Actividad de transformación realizada en la explotación	2	Productos Lácteos	8	Otros productos lácteos
	1	Actividad de transformación realizada en la explotación	3	Productos Cárnicos	1	Paté
	1	Actividad de transformación realizada en la explotación	3	Productos Cárnicos	2	Foi gras
	1	Actividad de transformación realizada en la explotación	3	Productos Cárnicos	3	Embutido
	1	Actividad de transformación realizada en la explotación	3	Productos Cárnicos	4	Otros productos cárnicos
	1	Actividad de transformación realizada en la explotación	4	Trenzados e hilados	1	Trenzado de materiales
	1	Actividad de transformación realizada en la explotación	4	Trenzados e hilados	2	Textiles
	1	Actividad de transformación realizada en la explotación	4	Trenzados e hilados	3	Tejido de Lanas
	1	Actividad de transformación realizada en la explotación	5	Otros Productos	0	Sin descripción
	2	Calibrado o acondicionamiento de productos	1	Calibrado y acondicionamiento de productos	0	Sin descripción
	3	Actividad Agroturística y Cinegética	1	Restauración	2	Degustación
	3	Actividad Agroturística y Cinegética	1	Restauración	3	Tienda de comercio al por menor
	3	Actividad Agroturística y Cinegética	2	Alojamiento	1	Hotel
	3	Actividad Agroturística y Cinegética	2	Alojamiento	2	Alojamiento rural
	3	Actividad Agroturística y Cinegética	2	Alojamiento	3	Camping
	3	Actividad Agroturística y Cinegética	2	Alojamiento	4	 Refugio
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas	1	Excursiones
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas	2	Senderismo
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas	3	Escalada
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas	4	Espeleología
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas	5	Rutas en bicicleta
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas	6	Equitación
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas	7	Golf
	3	Actividad Agroturística y Cinegética	3	Otras actividades agroturísticas	8	Pesca
	3	Actividad Agroturística y Cinegética	4	Caza	0	Sin descripción
	4	Servicios	1	A terceros	1	Alquiler y reparación de maquinaria agraria
	4	Servicios	1	A terceros	2	Proyectos de regadío
	4	Servicios	1	A terceros	3	Asesoramiento agrario
	4	Servicios	1	A terceros	4	Almacenamiento de productos
	4	Servicios	1	A terceros	5	Mantenimiento de edificios agrarios
	4	Servicios	1	A terceros	6	Agentes comerciales de productos agrarios
	4	Servicios	1	A terceros	7	Transporte de productos agrarios
	4	Servicios	2	Conservación del paisaje	1	Corte de hierba y setos
	4	Servicios	2	Conservación del paisaje	2	Eliminación de nieve
	4	Servicios	2	Conservación del paisaje	3	Diseño paisajístico
	4	Servicios	2	Conservación del paisaje	4	Conservación y plantación de espacios verdes
	5	Otras actividades complementarias	1	Energías Renovables	1	Solar
	5	Otras actividades complementarias	1	Energías Renovables	2	Eólica
	5	Otras actividades complementarias	1	Energías Renovables	3	Hidraúlica
	5	Otras actividades complementarias	1	Energías Renovables	4	Biomasa
	5	Otras actividades complementarias	1	Energías Renovables	5	Bioetanol
	5	Otras actividades complementarias	1	Energías Renovables	6	Biodiésel
	5	Otras actividades complementarias	2	Otras actividades en que se utilizan la tierra y los medios de producción agraria	0	Sin descripción






	 */
	
}
