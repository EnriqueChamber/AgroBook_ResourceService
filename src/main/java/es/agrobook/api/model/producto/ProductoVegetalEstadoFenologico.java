package es.agrobook.api.model.producto;

import java.util.Set;

import es.agrobook.api.model.cultivo.Cultivo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductoVegetalEstadoFenologico {

	@Id
	private Short id;

    @Column(nullable = false, unique = true)
	private String nombre;

    @Column(nullable = false)
	private String descripcion;


	// Dependientes

	@OneToMany(mappedBy = "estadoFenologico")
	private Set<ProductoVegetal> productosVegetales;

	@OneToMany(mappedBy = "estadoFenologico")
	private Set<Cultivo> cultivos;
	


	/*
	Germinación: La germinación es el proceso mediante el cual una semilla comienza a desarrollar una plántula. Este proceso comienza cuando la semilla absorbe agua y comienza a activar sus procesos metabólicos internos. La germinación generalmente implica la ruptura de la cubierta de la semilla y el inicio del crecimiento de la raíz primaria (radícula) y del tallo embrionario (hipocótilo o epicótilo).
	Brotación: La brotación es la fase en la que la plántula emergente comienza a producir y desarrollar brotes o yemas que se convertirán en tallos, hojas u otras estructuras vegetativas. Estos brotes pueden surgir directamente de la plántula o de yemas latentes presentes en la planta.
	Desarrollo de la yema: Una vez que se han formado los brotes, el desarrollo de la yema implica el crecimiento y la diferenciación de estas estructuras en tallos, hojas, flores u otras partes de la planta. Durante esta fase, las yemas pueden expandirse y dar lugar a nuevas ramificaciones, hojas o flores, dependiendo de la especie y las condiciones ambientales.
	Desarrollo de las hojas (brote o tallo principal): Crecimiento y maduración de las hojas en el tallo principal o brote principal.
	Formación de brotes laterales/macollamiento (ahijamiento): Producción de brotes laterales o macollos a partir del tallo principal.
	Crecimiento longitudinal del tallo: Este subestado se refiere al crecimiento continuo del tallo principal de la planta. Durante esta fase, el tallo puede alargarse y desarrollar nuevas ramificaciones.
	Formación de brotes (retoños): Durante este subestado, la planta puede producir brotes laterales a partir del tallo principal o de las axilas de las hojas. Estos brotes pueden convertirse en nuevas ramas o tallos, contribuyendo al crecimiento y la ramificación de la planta.
	Crecimiento en roseta: Algunas plantas pueden exhibir un patrón de crecimiento en roseta, donde las hojas emergen en espiral alrededor de un punto central. Este subestado implica el desarrollo de este patrón de crecimiento particular.
	Encañado (tallo principal): En ciertas especies, como las gramíneas, el encañado se refiere al alargamiento rápido y vertical del tallo principal, que es especialmente prominente durante la fase de floración. Este subestado implica el crecimiento vertical del tallo principal en preparación para la producción de flores y semillas.
	Desarrollo de las partes vegetativas cosechables de la planta o de órganos vegetativos de propagación/embuchamiento: Maduración y desarrollo de partes vegetativas de interés agronómico o para la propagación.
	Emergencia de la inflorescencia (tallo principal)/espigamiento: Aparición y crecimiento inicial de la estructura floral en el tallo principal.
	Desarrollo floral: Proceso de crecimiento y maduración de las flores.
	Plena floración: Periodo en el que la planta tiene la mayor cantidad de flores abiertas.
	Polinización: Etapa en la que ocurre la transferencia de polen a los órganos reproductores de la flor.
	Formación de frutos: Desarrollo de los órganos reproductores que contienen las semillas.
	Maduración de frutos: Proceso en el que los frutos alcanzan su pleno desarrollo y se vuelven aptos para la dispersión de las semillas.
	Dormancia o reposo invernal: Periodo de inactividad fisiológica durante el invierno, común en muchas plantas perennes.
	Despertar primaveral: Retorno del crecimiento activo después del reposo invernal.
	Maduración de semillas: Proceso en el que las semillas alcanzan su pleno desarrollo y están listas para la dispersión y germinación.

	 */
}