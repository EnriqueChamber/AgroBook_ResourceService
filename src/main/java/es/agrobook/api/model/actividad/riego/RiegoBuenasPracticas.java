package es.agrobook.api.model.actividad.riego;

import java.util.Set;

import es.agrobook.api.model.actividad.Actividad;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RiegoBuenasPracticas{


	@Id
	private Short id;

    @Column(nullable = false)
	private String descripcion;


	
	// Entidades enlazadas
	
	@OneToMany(mappedBy = "riegoBuenasPracticas")
	private Set<Actividad> actividades;


	/*
	Código SIEX	Buenas prácticas de riego en la fertilización
	1	Dosis y frecuencia de riego ajustadas a las necesidades del cultivo y a la capacidad de retención de humedad del suelo, tomando como referencia las recomendaciones de los servicios de asesoramiento al regante (SIAR) de la comunidad autónoma o el Sistema de Información Agroclimática para el Regadío (SiAR) del Ministerio de Agricultura, Pesca y Alimentación, y/o empleo de sensores de contenido de humedad del suelo.
	2	En el caso de que el propio material usado en el abonado aporte agua en una cantidad considerable al cultivo (como cuando se utilizan estiércoles líquidos), se tendrá en cuenta el volumen de agua incorporado por el mismo para el cálculo.
	3	Riego localizado.
	4	En cultivos con riego por inundación, el abonado nitrogenado se aplicará cuando el suelo se encuentre en sazón y se enterrará inmediatamente mediante una labor.
	5	En los cultivos con riego localizado, la fertilización se efectuará disolviendo los abonos en el agua de riego y aplicándolos al suelo a través de ésta. Éstos se dosificarán fraccionadamente, durante el periodo de actividad vegetativa del cultivo, pudiéndose adaptar las concentraciones y las cantidades parciales aportadas a los momentos de mayor requerimiento dentro del ciclo del cultivo.
	6	En el riego localizado, el número de emisores por árbol, el volumen de agua aportado por cada uno de ellos y la frecuencia de riego se recomienda que se establezcan en función de la textura del terreno, de forma que se consiga ajustar la superficie mojada a la profundidad radicular efectiva suficiente para el cultivo y así evitar problemas de saturación, de humedad o de pérdidas de agua en profundidad.
	7	El aporte de nutrientes conjuntamente con el agua de riego se deberá ajustar de modo que la concentración de nutrientes sea lo más baja posible, adaptándose a su vez a las necesidades hídricas del cultivo. Así mismo, los nutrientes deberán aplicarse en los momentos de máximo requerimiento de cada nutriente, de modo que se maximice el aprovechamiento por parte del cultivo y la efectividad del abonado y se reduzca, así, la acumulación en el suelo de nutrientes en forma de sales.
	*/

}