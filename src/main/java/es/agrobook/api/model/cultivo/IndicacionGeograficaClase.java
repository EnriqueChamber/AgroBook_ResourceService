package es.agrobook.api.model.cultivo;

import java.util.Set;

import es.agrobook.api.model.enums.IndicacionGeograficaCategoria;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class IndicacionGeograficaClase {

	@Id
	private int id;

    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private IndicacionGeograficaCategoria categoria;

    @Column(nullable = false)
	private String clase;


	// Entidades enlazadas

	@OneToMany(mappedBy = "clase")
    private Set<IndicacionGeograficaSubclase> subClases;



	/*
	Categoría	ID_Clase	Clase
	Alimentarios	1	CLASE 1.1. CARNES FRESCAS
	Alimentarios	2	CLASE 1.2. PRODUCTOS CÁRNICOS
	Alimentarios	3	CLASE 1.3. QUESOS
	Alimentarios	4	CLASE 1.4. OTROS PRODUCTOS DE ORIGEN ANIMAL
	Alimentarios	5	CLASE 1.5. ACEITES Y GRASAS
	Alimentarios	6	CLASE 1.6. FRUTAS, HORTALIZAS Y CEREALES FRESCOS O TRANSFORMADOS
	Alimentarios	7	CLASE 1.7. PESCADOS, MOLUSCOS, Y CRUSTÁCEOS FRESCOS Y PRODUCTOS DERIVADOS DE ELLOS
	Alimentarios	8	CLASE 1.8. OTROS PRODUCTOS DEL ANEXO I DEL TRATADO
	Alimentarios	9	CLASE 2.3. PRODUCTOS DE PANADERÍA, PASTELERÍA, REPOSTERÍA Y GALLETERÍA
	Alimentarios	10	CLASE 2.12. COCHINILLA
	Espirituosos	11	ESPIRITUOSOS
	Vinos	19	VINOS DOP
	Aromatizados	20	VINOS AROMATIZADOS
	Vinos	21	VINOS IGP



	
	 */
}