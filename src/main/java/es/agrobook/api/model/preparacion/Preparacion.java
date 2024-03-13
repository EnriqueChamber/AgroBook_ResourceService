package es.agrobook.api.model.preparacion;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.maquina.MaquinaUso;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Preparacion{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	//#region campos SIEX

    @Column(nullable = false)
	private Date fechaInicio;

    @Column(nullable = true)
	private Date fechaFin;
	
	@ManyToOne
	private Set<MaquinaUso> usosMaquinaria;

	@ManyToOne(optional = false)
	private Cultivo cultivo;

	@ManyToOne(optional = false)
	private Superficie superficie;

	// Actividad: Entutorado, Nivelación de suelo, Creacion de canimas, riego, otras labores



}