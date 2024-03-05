package es.agrobook.api.model;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.explotacion.Explotacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cultivo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private Date fechaInicio;

    @Column(nullable = true)
	private Date fechaFinalizacion;

    @Column(nullable = false)
	private String especie;

    @Column(nullable = false)
	private String variedad;

    @Column(nullable = true)
	private float superficie;

    @Column(nullable = true)
	private Date fechaSiembra;

    @Column(nullable = true)
	private float cantidadSemilla;

	// DATOS AGRONOMICOS - Cultivo
    @Column(nullable = false)
	private String secanoRegadio; 			// Solo Doc     //Secano (SEC), aspersión (ASP), goteo o localizado (LOC), por gravedad (GRA).

    @Column(nullable = false)
	private String ventilacion; 			// Solo Doc //Aire libre (AL), malla (M), cubierta bajo plástico (BP), invernadero (INV)
    
    @ManyToOne(optional = false)
	private Explotacion explotacion;

	@OneToMany(mappedBy = "cultivo")
    private Set<Tratamiento> tratamientos;
	

}