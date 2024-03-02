package es.agrobook.api.model;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.*;

@Entity
@Table(name = "explotacion_usuario")
public class ExplotacionUsuario {

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