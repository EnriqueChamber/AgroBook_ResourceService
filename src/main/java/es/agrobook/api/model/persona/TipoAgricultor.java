package es.agrobook.api.model.persona;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TipoAgricultor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String descripcion;

	/*
	
	Código SIEX	Tipo de agricultor
	1	Agricultor profesional
	2	Agricultor no pluriactivo
	3	Joven agricultor
	4	Agricultor a título principal (ATP)

	 */
	
}
