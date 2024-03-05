package es.agrobook.api.model;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.explotacion.Explotacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name="secano", nullable = false)
	private String secanoRegadio; 			// Solo Doc     //Secano (SEC), aspersión (ASP), goteo o localizado (LOC), por gravedad (GRA).

    @Column(nullable = false)
	private String ventilacion; 			// Solo Doc //Aire libre (AL), malla (M), cubierta bajo plástico (BP), invernadero (INV)
    

    @ManyToOne() @MapsId()
	private Explotacion explotacion;

	
	@OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tratamiento> tratamientos;
	

}