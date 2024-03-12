package es.agrobook.api.model.siembra;

import java.util.Date;

import es.agrobook.api.model.Maquina;
import es.agrobook.api.model.cultivo.Cultivo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Siembra{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	//#region campos SIEX

    @Column(nullable = false)
	private Date fechaInicio;

    @Column(nullable = true)
	private Date fechaFin;

    @Column(nullable = true)
	private Maquina maquina;

    @Column(nullable = true)
	private float horasUsoMaquina;

    @Column(nullable = false)
	private boolean simbraDirecta;

    @Column(nullable = false)
	private float cantidadSemillaArboles;

    @Column(nullable = false)
	private float dosisSemillaDensidad; // kg/ha ó planta/ha

    @Column(nullable = true)
	private String marcoPlantacion;


	@ManyToOne(optional = false)
    private Variedad variedad;

	@ManyToOne(optional = false)
	private MaterialVegetalReproduccion materialVegetalReproduccion;


	@ManyToOne(optional = false)
	private Cultivo cultivo;

}