package es.agrobook.api.model.persona;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TipoAgricultor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String descripcion;

	/*
	
	Código SIEX	Tipo de agricultor
	1	Agricultor profesional
	2	Agricultor no pluriactivo
	3	Joven agricultor
	4	Agricultor a título principal (ATP)

	 */
	
}
