package es.agrobook.api.model.persona;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaTipoAsociacion {
	
	@Id
	private long id;

	@Column(nullable = false)
	private String descripcion;

	/*
	
	Código SIEX	Forma jurídica
	1	Autorizadas de algodón
	2	Organización de productores de frutas y hortalizas
	3	Entidad de asesoramiento
	4	Entidad de certificación
	5	Asociación de razas
	6	Asociación de protección de variedades con riesgo de erosión genética
	7	Desmotadora
	9	Agrupaciones para la Gestión Integrada de Plagas
	10	Entidades representativas
	11	Agrupaciones de Defensa Sanitaria (ADS)
	12	Asesoramiento en Proyecto de lucha alternativa
	13	Formación que establezca la autoridad competente
	14	Empresas productoras de semillas certificadas
	15	Organizaciones de productores de plátanos
	16	Cooperativas agroalimentarias

	 */
	
}
