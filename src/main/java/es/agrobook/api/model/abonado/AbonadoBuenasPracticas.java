package es.agrobook.api.model.abonado;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AbonadoBuenasPracticas {

	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;



	// Entidades enlazadas

	@OneToMany(mappedBy = "buenasPracticas")
	private Set<Abonado> abonados;

	


	/*
	Código SIEX	Buenas prácticas fertilizantes
1	Aplicación de purines mediante sistema de bandas con mangueras o tubos rígidos
2	Aplicación de purines mediante sistema de bandas de discos o rejas
3	Aplicación de purines mediante inyección
4	Dilución de purines, seguida de técnicas tales como un sistema de riego de baja presión
5	Acidificación de los purines
6	Dosis y momento de aplicación
7	Fraccionamiento de los aportes de acuerdo con las necesidades del cultivo, siempre que sea técnicamente posible
8	Incorporación de los fertilizantes en el suelo por sistemas de inyección en profundidad 
9	Incorporación de los fertilizantes en el suelo mediante mezcla de los gránulos del fertilizante con el suelo
10	Emplear gránulos de urea recubiertos de un polímero
11	Aplicar un riego inmediatamente después de la fertilización con abonos a base de urea
12	Realizar la fertilización nitrogenada mediante fertirrigación (Sólo cuando haya necesidades de regadío)
13	En el cultivo de arroz, realizar el abonado nitrogenado con el terreno seco
14	Empleo de inhibidores de la ureasa con productos fertilizantes a base de urea
15	Enterrado de purines y, productos y materiales líquidos lo antes posible y siempre en las primeras 4 horas tras su aplicación
16	Empleo de inhibidores de la ureasa o de la nitrificación aplicados a purines, con supervisión profesional en caso de aplicación directa de los purines al suelo o a la balsa de purín
17	Aplicación de la tecnología de dosificación variable dentro de una misma parcela
18	Enterrado de la urea, en el momento de su aplicación al suelo o, por lo menos, en las 4 horas siguientes
19	Empleo de productos fertilizantes nitrogenados con inhibidores de la nitrificación
20	Abonado en verde



	 */
}