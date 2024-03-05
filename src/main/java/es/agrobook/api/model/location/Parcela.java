package es.agrobook.api.model.location;

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

	@OneToOne()@MapsId()
	private Municipio municipio;

	@Column(nullable = false)
	private int agregado; 					// Doc y Web

	@Column(nullable = false)
	private int zona;						// Doc y Web
	
	@Column(nullable = false)
	private int poligono;					// Doc y Web
	
	@Column(nullable = false)
	private int parcela;					// Doc y Web
	
	@Column(nullable = false)
	private float superficie;				// Doc y (Web -> Parcela = Recinto Sigpac)
	
	@Column(nullable = false)
	private String referenciaCatastral;		// Solo Web
	

	//private float superficieZonaEspecifica;			// Solo Web
	
    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "explotacion_parcela", joinColumns = @JoinColumn(name = "parcela"), inverseJoinColumns = @JoinColumn(name = "explotacion"))
	
	@JsonBackReference 
	@JsonIgnore
	private List<Explotacion> explotaciones;*/

	@ManyToMany(mappedBy = "parcela")
    private Set<Recinto> recintos;

}