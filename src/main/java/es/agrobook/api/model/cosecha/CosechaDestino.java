package es.agrobook.api.model.cosecha;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CosechaDestino {

	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;



	// Entidades enlazadas

	@OneToMany(mappedBy = "destino")
	private Set<Cosecha> cosechas;

	


	/*
	Código SIEX	Declaración de cosecha / producción
	1	Entregada a bodega cooperativa
	2	Entregada a explotación agrícola para su cultivo
	3	Vendidas a un vinificador
	4	Vinificación y/o conservación por el declarante.
	5	Bebidas
	6	Conservas
	7	Mermelada
	8	Mosto concentrado
	9	Pasificado
	10	Zumo
	11	Azúcar
	12	Melaza
	13	Bagazo
	14	Molturación torta
	15	Encurtidos
	16	Alcohol



	 */
}