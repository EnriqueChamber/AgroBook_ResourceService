package es.agrobook.api.model.persona;

import java.io.Serializable;
import java.util.Date;

import es.agrobook.api.model.enums.PersonaExplotacionRelacion;
import es.agrobook.api.model.explotacion.Explotacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(PersonaExplotacion.PersonaExplotacionId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaExplotacion implements Serializable {

	@Id
    @ManyToOne
    private Persona persona;

	@Id
    @ManyToOne
    private Explotacion explotacion;

	@Id
    @Enumerated
    private PersonaExplotacionRelacion relacion;

	@Column(nullable = false)
    private Date fechaInicio;

    private float participacion;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class PersonaExplotacionId {
        private long persona;
        private long explotacion;
        private PersonaExplotacionRelacion relacion;

    }
}