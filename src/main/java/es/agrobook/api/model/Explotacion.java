package es.agrobook.api.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Explotacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idexplotacion")
	private long id;
	@Column(nullable = false)
	private String nombre;
	private String registroNacional; 			// Solo Doc
	private String registroAutonomico; 			// Solo Doc
	@Column(nullable = false)
	private String direccion; 					// Solo Doc
	private String localidad; 					// Solo Doc
	private int codigoPostal; 					// Solo Doc
	private String provincia; 					// Solo Doc
	private int telefonoFijo; 					// Solo Doc
	private int telefonoMovil; 					// Solo Doc
	private String email; 						// Solo Doc
	private String rutaImagen;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "explotacion_parcela", joinColumns = @JoinColumn(name = "idexplotacion"), inverseJoinColumns = @JoinColumn(name = "idparcela"))
	//@JsonManagedReference 
	private List<Parcela> parcelas;
	

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "explotacion")
    private Set<ExplotacionUsuario> usuarios;

	
}
