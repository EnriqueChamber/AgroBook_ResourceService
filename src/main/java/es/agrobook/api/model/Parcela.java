package es.agrobook.api.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Parcela{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;

	// REFERENCIAS SIGPAC
	//@OneToOne(mappedBy = "id")
	//private Municipio municipio; // Integra Código Provincia, codigo Municipio, nombre Municipio
	private int agregado; 					// Doc y Web
	private int zona;						// Doc y Web
	private int poligono;					// Doc y Web
	private int parcela;					// Doc y Web
	private int recinto;					// Doc y (Web -> Parcela = Recinto Sigpac)
	private float superficie;				// Doc y (Web -> Parcela = Recinto Sigpac)
	private float pendiente;				// Solo Web -> Parcela = Recinto Sigpac
	private String referenciaCatastral;		// Solo Web
	private String uso;						// Doc y (Web -> Parcela = Recinto Sigpac)
	private float subvencionalidad;			// Solo Web
	private int coeficienteRegadio;			// Solo Web
	// pendientes en Web: pjeSubvencionado, supSubvencionada, coefRegadio, incidencias, región
	// FIN REFERENCIAS SIGPAC

	// DATOS AGRONOMICOS
    @Column(name="secano")
	private String secanoRegadio; 			// Solo Doc     //Secano (SEC), aspersión (ASP), goteo o localizado (LOC), por gravedad (GRA).
	private String ventilacion; 			// Solo Doc //Aire libre (AL), malla (M), cubierta bajo plástico (BP), invernadero (INV)

	private float superficieZonaEspecifica;			// Solo Web
	
    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "explotacion_parcela", joinColumns = @JoinColumn(name = "idparcela"), inverseJoinColumns = @JoinColumn(name = "idexplotacion"))
	
	@JsonBackReference 
	@JsonIgnore
	private List<Explotacion> explotaciones;*/

	@OneToMany(mappedBy = "parcela", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cultivo> cultivos;

	// los siguientes datos serán de la clase cultivo, el cual tendrá asociado una parcela
	//private float superficieCultivada; 		// Solo Doc
	//private String especie; 				// Solo Doc
	//private String variedad; 				// Solo Doc
	// FIN DATOS AGRONOMICOS

}