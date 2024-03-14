package es.agrobook.api.model.tratamiento;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.cosecha.Cosecha;
import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.maquina.MaquinaUso;
import es.agrobook.api.model.siembra.MaterialVegetalReproduccion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TratamientoFitosanitarioClasificacion {

	@Id
	private byte id;

    @Column(nullable = false)
	private String descripcion;



	// Entidades enlazadas

	@OneToMany(mappedBy = "clasificacion")
	private Set<TratamientoFitosanitario> fitosanitarios;

	


	/*
	Código SIEX	Tipo de producto fitosanitario
	1	Producto fitosanitario registrado
	2	Denominación común
	3	Importación paralela
	4	Autorización excepcional


	 */


}