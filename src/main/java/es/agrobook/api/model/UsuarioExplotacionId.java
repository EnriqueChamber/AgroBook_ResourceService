package es.agrobook.api.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioExplotacionId {
    private long usuario;
    private long explotacion;
    private String relacion;

}