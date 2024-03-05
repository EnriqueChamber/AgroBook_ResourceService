package es.agrobook.api.model;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import es.agrobook.api.model.persona.Persona;
import jakarta.persistence.*;
import lombok.*;

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

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private boolean enabled;

	@Column(nullable = false)
	private boolean expiredAccount;

	@Column(nullable = false)
	private boolean locked;

	@Column(nullable = false)
	private boolean expiredCredentials;

	@OneToOne
	private Persona persona;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return !expiredAccount;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return !expiredCredentials;
	}
	
}
