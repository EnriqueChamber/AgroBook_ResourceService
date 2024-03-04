package es.agrobook.api.model;

import java.io.Serializable;

import es.agrobook.api.model.persona.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(PersonaExplotacionId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaExplotacion implements Serializable {

	@Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona")
    private Persona persona;

	@Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_explotacion")
    private Explotacion explotacion;

	@Id
    private String relacion;

}