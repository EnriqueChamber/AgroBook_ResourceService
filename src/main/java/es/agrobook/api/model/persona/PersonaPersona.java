package es.agrobook.api.model.persona;

import java.io.Serializable;
import java.util.Date;

import es.agrobook.api.model.enums.PersonaPersonaRelacion;
import es.agrobook.api.model.explotacion.Explotacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(PersonaPersona.PersonaPersonaId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonaPersona implements Serializable {

	@Id
    @ManyToOne(optional = false)
    private Persona persona;

	@Id
    @ManyToOne(optional = false)
    private Persona personaRef;

	@Id
    @Enumerated(EnumType.STRING)
    private PersonaPersonaRelacion relacion;

	@Column(nullable = true)
    private Date fechaInicio;

	@Column(nullable = true)
    private float participacion;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Data
    @Builder
    public static class PersonaPersonaId {
        private long persona;
        private long personaRef;
        private PersonaPersonaRelacion relacion;

    }
}