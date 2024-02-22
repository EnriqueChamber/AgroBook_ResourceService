package es.agrobook.api.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements UserDetails, CredentialsContainer{

	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
	private long id;
	private String username;
	private String password;
	private boolean enabled;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nif;
	private String direccion;
	private String localidad;
	private int codigoPostal;
	private String provincia;
	private Integer telefonoFijo = 0;
	private Integer telefonoMovil = 0;
	private String email;
	private String noInscripcionRopo;
	/*@OneToMany(mappedBy = "post")
	private List tiposCarnet;*/
	private boolean asesor;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<ExplotacionUsuario> explotacionesUsuarios;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore
    private Set<Authority> authorities;	
	
	// CONSTRUCTORS
	
	public Usuario() {
		
	}
	

	// GETTERS AND SETTERS 
	public Long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellidos) {
		this.apellido1 = apellidos;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(int telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	
	public int getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(int telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNoInscripcionRopo() {
		return noInscripcionRopo;
	}

	public void setNoInscripcionRopo(String noInscripcionRopo) {
		this.noInscripcionRopo = noInscripcionRopo;
	}

	/*public String[] getTiposCarnet() {
		return tiposCarnet;
	}

	public void setTiposCarnet(String[] tiposCarnet) {
		this.tiposCarnet = tiposCarnet;
	}*/

	public boolean isAsesor() {
		return asesor;
	}

	public void setAsesor(boolean asesor) {
		this.asesor = asesor;
	}

	
	
	// INICIO UserDetails methods
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	// FIN UserDetails methods


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nif=" + nif
				+ ", direccion=" + direccion + ", localidad=" + localidad + ", codigoPostal=" + codigoPostal
				+ ", provincia=" + provincia + ", telefonoFijo=" + telefonoFijo + ", telefonoMovil=" + telefonoMovil
				+ ", email=" + email + ", noInscripcionRopo=" + noInscripcionRopo + ", asesor=" + asesor + "]";
	}


	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'eraseCredentials'");
	}
	
}
