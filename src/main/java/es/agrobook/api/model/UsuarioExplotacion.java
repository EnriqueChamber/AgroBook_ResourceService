package es.agrobook.api.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(UsuarioExplotacionId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioExplotacion implements Serializable {

	@Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

	@Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idexplotacion")
    private Explotacion explotacion;

	@Id
    private String relacion;

}