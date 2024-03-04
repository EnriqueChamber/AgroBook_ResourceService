package es.agrobook.api.model;

import java.util.Date;
import java.util.Set;

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
	private Date fechaInicio;
	private Date fechaFinalizacion;
	private String especie;
	private String variedad;
	private float superficie;

	private Date fechaSiembra;
	private float cantidadSemilla;

    @ManyToOne
    @JoinColumn(name = "idparcela")
	private Parcela parcela;

	
	@OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tratamiento> tratamientos;
	
    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "explotacion_parcela", joinColumns = @JoinColumn(name = "idparcela"), inverseJoinColumns = @JoinColumn(name = "idexplotacion"))
	@JsonBackReference 
	@JsonIgnore
	private List<Explotacion> explotaciones;*/

}