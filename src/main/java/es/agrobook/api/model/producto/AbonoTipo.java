package es.agrobook.api.model.producto;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AbonoTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "tipo")
	private Set<Abono> abonos;


/*
	Código SIEX	Tipo de material
	1	Estiercol líquido de aves
	2	Estiércol líquido de bovino
	3	Estiércol líquido de porcino
	4	Estiércol sólido de aves
	5	Estiércol sólido de bovino
	6	Estiércol sólido de caprino
	7	Estiércol sólido de equino
	8	Estiércol sólido de ovino
	9	Inhibidores
	10	Otros tipos de estiércol sólido: conejo, visón, zorro…
	11	Productos fertilizantes bioestimulantes
	12	Productos fertilizantes enmiendas calizas
	13	Productos fertilizantes enmiendas orgánicas
	14	Productos fertilizantes: abonos inorgánicos
	15	Productos fertilizantes: abonos orgánicos
	16	Productos fertilizantes: abonos organominerales
	17	Productos fertilizantes otras enmiendas (retenedoras humedad, ácidas, etc.)
	18	Residuos: Materiales que, sin haberse empleado en la elaboración de un producto fertilizante, cumplan con todos los requisitos de las CMCS 3, 4, 5, 6, 12, 13 y 14 del Anexo II del Reglamento (UE) 2019/1009. 
	19	Residuos: Subproductos de origen animal no aptos para consumo humano, que hayan sido tratados conforme al artículo 20 del Reglamento (CE) 1069/2009. 
	20	Residuos: compost de alperujo
	21	Residuos: alperujo desecado
	22	Residuos: Lodos de tratamiento de aguas residuales urbanas (lodos EDAR), incluidos en el Real Decreto 1310/1990, de 29 de octubre. siempre que hayan sido tratados. 
	23	Residuos: Lodos calizos procedentes del proceso Kraft de fabricación de pasta de papel, para elevar el pH de suelos ácidos

 */


}