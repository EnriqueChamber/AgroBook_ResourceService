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
public class FitosanitarioClasificacion {

	@Id
	private Short id;

    @Column(nullable = false)
	private String descripcion;



	// Entidades enlazadas

	@OneToMany(mappedBy = "clasificacion")
	private Set<Fitosanitario> fitosanitarios;

	


	/*
	Código SIEX	Tipo de producto fitosanitario
	1	Producto fitosanitario registrado
	2	Denominación común
	3	Importación paralela
	4	Autorización excepcional


	 */


}