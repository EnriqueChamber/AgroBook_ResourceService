package es.agrobook.api.model;

import java.util.Date;

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
public class Maquina{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descripcion;
	private String noInscripcionRoma;
	private Date fechaAdquisicion;
	private Date fechaUltimaInspeccion;

	
    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "explotacion_parcela", joinColumns = @JoinColumn(name = "idparcela"), inverseJoinColumns = @JoinColumn(name = "idexplotacion"))
	@JsonBackReference 
	@JsonIgnore
	private List<Explotacion> explotaciones;*/


}