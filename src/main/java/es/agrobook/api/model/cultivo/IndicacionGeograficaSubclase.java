package es.agrobook.api.model.cultivo;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class IndicacionGeograficaSubclase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @ManyToOne(optional = false)
	private IndicacionGeograficaClase clase;

    @Column(nullable = false)
	private String subclase;


	// Entidades enlazadas

	@OneToMany(mappedBy = "subclase")
    private Set<DenominacionOrigen> denominacionesOrigen;



	/*
	ID_Clase	Clase	ID_Subclase	Subclase
	1	CLASE 1.1. CARNES FRESCAS	1	1.1 Aves de corral
	1	CLASE 1.1. CARNES FRESCAS	2	1.1 Vacuno
	1	CLASE 1.1. CARNES FRESCAS	3	1.1 Ovino
	2	CLASE 1.2. PRODUCTOS CÁRNICOS	4	1.2 Jamones Ibéricos
	2	CLASE 1.2. PRODUCTOS CÁRNICOS	5	1.2 Jamones no ibéricos
	2	CLASE 1.2. PRODUCTOS CÁRNICOS	6	1.2 Jamones y paletas no ibéricas
	2	CLASE 1.2. PRODUCTOS CÁRNICOS	7	1.2 Embutidos
	2	CLASE 1.2. PRODUCTOS CÁRNICOS	8	1.2 Otros productos cárnicos
	3	CLASE 1.3. QUESOS	9	1.3 Quesos
	4	CLASE 1.4. OTROS PRODUCTOS DE ORIGEN ANIMAL	10	1.4 Miel
	5	CLASE 1.5. ACEITES Y GRASAS	11	1.5 Aceites  de Oliva Virgen
	5	CLASE 1.5. ACEITES Y GRASAS	12	1.5 Mantequillas
	6	CLASE 1.6. FRUTAS, HORTALIZAS Y CEREALES FRESCOS O TRANSFORMADOS	13	1.6 Frutas
	6	CLASE 1.6. FRUTAS, HORTALIZAS Y CEREALES FRESCOS O TRANSFORMADOS	14	1.6 Hortalizas
	6	CLASE 1.6. FRUTAS, HORTALIZAS Y CEREALES FRESCOS O TRANSFORMADOS	15	1.6 Legumbres
	6	CLASE 1.6. FRUTAS, HORTALIZAS Y CEREALES FRESCOS O TRANSFORMADOS	16	1.6 Arroces
	6	CLASE 1.6. FRUTAS, HORTALIZAS Y CEREALES FRESCOS O TRANSFORMADOS	17	1.6 Aceitunas
	6	CLASE 1.6. FRUTAS, HORTALIZAS Y CEREALES FRESCOS O TRANSFORMADOS	18	1.6 Cereales frescos o transformados
	6	CLASE 1.6. FRUTAS, HORTALIZAS Y CEREALES FRESCOS O TRANSFORMADOS	19	1.6 Otros vegetales (frutos secos)
	7	CLASE 1.7. PESCADOS, MOLUSCOS, Y CRUSTÁCEOS FRESCOS Y PRODUCTOS DERIVADOS DE ELLOS	20	1.7 Pescados
	7	CLASE 1.7. PESCADOS, MOLUSCOS, Y CRUSTÁCEOS FRESCOS Y PRODUCTOS DERIVADOS DE ELLOS	21	1.7 Moluscos
	8	CLASE 1.8. OTROS PRODUCTOS DEL ANEXO I DEL TRATADO	22	1.8 Especias
	8	CLASE 1.8. OTROS PRODUCTOS DEL ANEXO I DEL TRATADO	23	1.8 Frutos diversos (tubérculos, raíces, etc)
	8	CLASE 1.8. OTROS PRODUCTOS DEL ANEXO I DEL TRATADO	24	1.8 Vinagres
	8	CLASE 1.8. OTROS PRODUCTOS DEL ANEXO I DEL TRATADO	25	1.8 Sidra
	9	CLASE 2.3. PRODUCTOS DE PANADERÍA, PASTELERÍA, REPOSTERÍA Y GALLETERÍA	26	2.3  Turrones
	9	CLASE 2.3. PRODUCTOS DE PANADERÍA, PASTELERÍA, REPOSTERÍA Y GALLETERÍA	27	2.3 Panes
	9	CLASE 2.3. PRODUCTOS DE PANADERÍA, PASTELERÍA, REPOSTERÍA Y GALLETERÍA	28	2.3 Productos de pastelería y repostería
	10	CLASE 2.12. COCHINILLA	29	2.12 Cochinilla
	1	CLASE 1.1. CARNES FRESCAS	31	1.1 Porcino
	11	ESPIRITUOSOS	32	5. Brandy o Weinbrand
	11	ESPIRITUOSOS	33	6. Aguardiente de orujo u orujo
	11	ESPIRITUOSOS	34	10. Aguardiente de sidra y aguardiente de perada
	11	ESPIRITUOSOS	35	19. Bebidas espirituosas aromatizadas con enebro
	11	ESPIRITUOSOS	36	25. Bebidas espirituosas anisadas
	11	ESPIRITUOSOS	37	32. Licor
	11	ESPIRITUOSOS	38	37bis. Bebida espirituosa aromatizada a base de endrinas o pacharán
	11	ESPIRITUOSOS	39	47. Otras bebidas espirituosas
	20	VINOS AROMATIZADOS	40	Vinos aromatizados
	19	VINOS DOP	41	DOCa: “Vino de Denominación de Origen Calificada”
	19	VINOS DOP	42	DO: “Vino de Denominación de Origen”
	19	VINOS DOP	43	VP: “Vino de Pago”
	19	VINOS DOP	44	VC: "Vino de Calidad”
	21	VINOS IGP	45	VT: “Vino de la Tierra”




	
	 */
}