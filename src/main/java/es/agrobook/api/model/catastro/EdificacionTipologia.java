package es.agrobook.api.model.catastro;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EdificacionTipologia{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "tipologia")
	private Set<EdificacionClasificacion> clasificaciones;

   /*
	* 
	Código	Tipología
	1	Naves y obras de edificación de entidad constructiva
	2	Obras de edificación de escasa entidad constructiva
	3	Construcciones singulares
	4	Espacios anejos y construcciones e instalaciones a cielo abierto
	5	Construcciones e instalaciones auxiliares
	6	Depósitos
	7	Construcciones tradicionales 
	8	Instalación eléctrica
	9	Instalación riego

    */

}