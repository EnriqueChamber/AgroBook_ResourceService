package es.agrobook.api.model.catastro;

import es.agrobook.api.model.explotacion.Explotacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Edificacion{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(nullable = false)
	private String nombre;
	

	//#region campos SIEX

	@ManyToOne(optional = false)
	private EdificacionClasificacion clasificacion;

    @Column(nullable = false)
	private String referenciaCatastral;

    @Column(nullable = false)
	private boolean edificacionPropia;

    @Column(nullable = false)
	private String coordenadas;

    /*@Column(nullable = false)
	private String cota;*/

    @Column(nullable = false)
	private float dimension;

    @Column(nullable = false)
	private int edificaciones;

    @Column(nullable = false)
	private int anyoConstruccion;

    @ManyToOne(optional = false)
	private RegimenTenencia regimenTenencia;

    @Column(nullable = true)
	private String nifArrendador;

    @Column(nullable = true)
	private float plazasMaximasAlojamientosGanaderos;

    @Column(nullable = true)
	private float volumenMaximo;

	//#endregion


    @ManyToOne(optional = false)
	private Explotacion explotacion;


	// Entidades enlazadas
	

}