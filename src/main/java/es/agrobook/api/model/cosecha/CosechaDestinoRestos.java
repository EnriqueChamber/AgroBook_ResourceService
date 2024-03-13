package es.agrobook.api.model.cosecha;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CosechaDestinoRestos {

	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;



	// Entidades enlazadas

	@OneToMany(mappedBy = "destinoRestos")
	private Set<Cosecha> cosechas;

	


	/*
	Código SIEX	Destino del resto vegetal
	1	Incorporación al suelo o distribución en parcela (previo picado o no)
	2	Venta a terceros
	3	Autoconsumo para alimentación animal
	4	Autoconsumo como combustible
	5	Autocompostaje
	6	Traslado a planta de gestión de restos vegetales
	7	Traslado a planta de compostaje
	8	Quema controlada con arreglo a normativa vigente
	9	Trituración de restos de poda y depositado sobre el terreno de los mismos




	 */
}