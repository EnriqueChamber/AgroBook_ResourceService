package es.agrobook.api.model;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.*;

@Entity
@Table(name = "explotacion_usuario")
public class ExplotacionUsuario {

	@Id
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

	@Id
    @ManyToOne
    @JoinColumn(name = "idexplotacion")
    private Explotacion explotacion;

	@Id
    private String relacion;



	// CONSTRUCTORS
	
	public ExplotacionUsuario() {
		
	}



	public ExplotacionUsuario(Long id, Usuario usuario, Explotacion explotacion, String relacion) {
		super();
		this.usuario = usuario;
		this.explotacion = explotacion;
		this.relacion = relacion;
	}

	

	// GETTERS AND SETTERS 


	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Explotacion getExplotacion() {
		return explotacion;
	}



	public void setExplotacion(Explotacion explotacion) {
		this.explotacion = explotacion;
	}


	@JsonValue
	public String getRelacion() {
		return relacion;
	}



	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	
}