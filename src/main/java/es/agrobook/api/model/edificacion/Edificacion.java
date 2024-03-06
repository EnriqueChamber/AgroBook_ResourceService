package es.agrobook.api.model.edificacion;

import java.util.Set;

import es.agrobook.api.model.explotacion.Explotacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Edificacion{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private String nombre;

	@ManyToOne(optional = false)
	private EdificacionClasificacion clasificacion;

	@ManyToOne(optional = false)
	private EdificacionTipologia tipologia;

    @Column(nullable = false)
	private String referenciaCatastral;

    @Column(nullable = false)
	private boolean edificacionPropia;

    @Column(nullable = false)
	private String coordenadas;

    @Column(nullable = false)
	private float superficie;

    @Column(nullable = false)
	private int anyoConstruccion;

    

    @ManyToMany
	private Set<Explotacion> explotaciones;
	

}