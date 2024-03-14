package es.agrobook.api.model.abonado;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AbonadoTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String descripcion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "tipo")
	private Set<Abonado> abonados;


/*
	Código SIEX	Tipo de fertilización
1	Abonado de fondo
2	Abonado de cobertera
3	Aplicación de enmienda

 */


}