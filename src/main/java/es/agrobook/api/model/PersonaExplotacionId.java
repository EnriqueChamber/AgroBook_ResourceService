package es.agrobook.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaExplotacionId {
    private long persona;
    private long explotacion;
    private String relacion;

}