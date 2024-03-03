package es.agrobook.api.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private int telefonoFijo;
	private int telefonoMovil;
	private String email;
	private String noInscripcionRopo;
	private boolean asesor;

    
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> authorities;

	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<UsuarioExplotacion> usuarioExplotaciones;
	
	
	
	// INICIO UserDetails methods
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
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
	
}
