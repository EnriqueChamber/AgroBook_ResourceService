package es.agrobook.api.model.abonado;

import es.agrobook.api.model.persona.Persona;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Abono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(optional = false)
	private AbonoTipo tipo; 
	
    @Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private AbonoFertilizanteClasificacion clasificacion; // Solo inorgánicos / fertilizantes

	@Column(nullable = false)
	private String nombreComercial;

	@Column(nullable = true)
	private String grupoConsumo; // Solo inorgánicos / fertilizantes

	@Column(nullable = false)
	private Persona suministrador;

	@Column(nullable = true)
	private Persona fabricante;


	// Macronutrientes
	
	@Column(nullable = true)
	private Float nTotal;
	
	@Column(nullable = true)
	private Float nOrganico;
	
	@Column(nullable = true)
	private Float nNitrico;
	
	@Column(nullable = true)
	private Float nAmoniacal;
	
	@Column(nullable = true)
	private Float nUreino;
	
	@Column(nullable = true)
	private Float p2o5Total;
	
	@Column(nullable = true)
	private Float p2o5SolubleAgua;
	
	@Column(nullable = true)
	private Float p2o5SolubleCitrato;
	
	@Column(nullable = true)
	private Float k2oTotal;
	
	@Column(nullable = true)
	private Float k2oSolubleAgua;
	
	@Column(nullable = true)
	private Float materiaOrganica;
	

	// Mesonutrientes
	
	@Column(nullable = true)
	private Float calcio;
	
	@Column(nullable = true)
	private Float magnesio;
	
	@Column(nullable = true)
	private Float azufre;
	

	// Micronutrientes
	
	@Column(nullable = true)
	private Float boro;
	
	@Column(nullable = true)
	private Float cobalto;
	
	@Column(nullable = true)
	private Float cobre;
	
	@Column(nullable = true)
	private Float manganeso;
	
	@Column(nullable = true)
	private Float molibdemo;
	
	@Column(nullable = true)
	private Float zinc;
	
	@Column(nullable = true)
	private Float hierro;
	

	// Metales pesados / excluidos los considerados también como micronutrientes (Cobre y Zinc)
	
	@Column(nullable = true)
	private Float cadmio;
	
	@Column(nullable = true)
	private Float plomo;
	
	@Column(nullable = true)
	private Float niquel;
	
	@Column(nullable = true)
	private Float mercurio;
	
	@Column(nullable = true)
	private Float cromo;



}