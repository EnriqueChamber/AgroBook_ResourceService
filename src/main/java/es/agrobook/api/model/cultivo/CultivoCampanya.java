package es.agrobook.api.model.cultivo;

import java.util.Date;

import es.agrobook.api.model.catastro.SuperficieAgrupacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CultivoCampanya{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private String nombre;

    @Column(nullable = false)
	private Date fechaInicio;

    @Column(nullable = true)
	private Date fechaFinalizacion;

    @ManyToOne(optional = false)
	private Cultivo cultivo;

    @ManyToOne(optional = false)
	private SuperficieAgrupacion superficie;

    @Column(nullable = false)
	private float produccionEstimada; // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Datos de maquinaria y equipos


}