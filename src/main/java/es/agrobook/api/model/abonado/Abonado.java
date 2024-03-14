package es.agrobook.api.model.abonado;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.maquina.MaquinaUso;
import es.agrobook.api.model.persona.Persona;
import es.agrobook.api.model.riego.Riego;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Abonado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	//#region campos SIEX

    @Column(nullable = false)
	private Date fechaInicio;

    @Column(nullable = true)
	private Date fechaFin;
	
	@ManyToMany
	private Set<MaquinaUso> usosMaquinaria;

	@ManyToOne(optional = false)
	private Cultivo cultivo;

	@ManyToOne(optional = false)
	private Superficie superficie;

	@ManyToOne
	private AbonadoBuenasPracticas buenasPracticas;

	@ManyToOne(optional = false)
	private Abono abono;

    @Column(nullable = true)
	private Float dosis;

	@ManyToOne(optional = false)
	private AbonadoTipo tipo; 

	@ManyToOne(optional = false)
	private AbonadoMetodoAplicacion metodoAplicacion; 

    @Column(nullable = true)
	private String albaran;

    @Column(nullable = true)
	private boolean docAplicacionLodos;

	@ManyToOne(optional = false)
	private Persona aplicador; 
	

	@OneToOne(optional = false)
	private Riego riego; 

	@ManyToOne(optional = false)
	private AbonadoPlan planAbonado; 



}