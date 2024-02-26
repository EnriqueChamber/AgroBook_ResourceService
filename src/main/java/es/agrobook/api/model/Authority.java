package es.agrobook.api.model;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority{

    
	@Id
    @ManyToOne
    @JoinColumn(name = "idusuario")
    @JsonIgnore
    private Usuario usuario;
    
	@Id
    private String authority;

    public Authority(){
        
    }
    
    public Authority(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
    
}
