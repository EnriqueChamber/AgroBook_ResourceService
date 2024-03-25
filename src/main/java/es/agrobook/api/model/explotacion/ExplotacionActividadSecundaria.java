package es.agrobook.api.model.explotacion;

import java.util.Set;

import es.agrobook.api.model.RendimientoEconomico;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExplotacionActividadSecundaria {
	
	@Id
	private long id;

	@Column(nullable = false)
	private String descripcion;

	@ManyToOne(optional = false)
	private ActividadSecundaria3erNivel actividad;

    @ManyToOne(optional = false)
	private Explotacion explotacion;

	@OneToMany(mappedBy = "actividadSecundaria")
	private Set<RendimientoEconomico> rendimientosEconomicos;  // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Económico

}
