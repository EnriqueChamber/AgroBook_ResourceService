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
public class CultivoSistemaExplotacion {

	@Id
	@Column(length = 1)
	private String codigo;

    @Column(nullable = false)
	private String sistemaExplotacion;


	// Entidades enlazadas

	@OneToMany(mappedBy = "sistemaExplotacion")
	private Set<Cultivo> cultivos;


	/*
	Código SIEX	Sistema de explotación
	R	Regadío
	S	Secano


	
	 */
}