package es.agrobook.api.model.location;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Parcela{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nombre;

	@ManyToOne
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

	@OneToMany(mappedBy = "parcela")
    private Set<Recinto> recintos;

}