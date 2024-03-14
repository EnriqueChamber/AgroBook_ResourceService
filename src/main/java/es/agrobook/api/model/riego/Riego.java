package es.agrobook.api.model.riego;

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
public class Riego{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
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

	@ManyToOne(optional = false)
	private RiegoSistemaRiego sistemaRiego;

    @Column(nullable = false)
	private float cantidad;

	@ManyToOne(optional = false)
	private RiegoOrigenAgua origenAgua;

    @Column(nullable = false)
	private String contador;

    @Column(nullable = false)
	private float nNitricoEnAgua;

    @Column(nullable = false)
	private float p2o5SolubleAgua;

}