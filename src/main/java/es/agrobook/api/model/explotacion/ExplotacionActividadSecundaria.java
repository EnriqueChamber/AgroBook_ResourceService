package es.agrobook.api.model.explotacion;

import java.util.Set;

import es.agrobook.api.model.RendimientoEconomico;
import es.agrobook.api.model.cultivo.Cultivo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

	@OneToMany
	private Set<RendimientoEconomico> rendimientosEconomicos;  // SIEX -> Contenido REA -> INFORMACION POR EXPLOTACION -> Rendimiento Económico

}
