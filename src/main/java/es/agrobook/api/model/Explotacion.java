package es.agrobook.api.model;

import java.util.List;
import java.util.Set;

import es.agrobook.api.model.location.Municipio;
import es.agrobook.api.model.persona.PersonaContacto;
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
	private long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String nif;

	@Column(nullable = false)
	private String registroAutonomico; 			// Solo Doc

	private String registroNacional; 			// Solo Doc

	@Column(nullable = false)
	private String direccion; 					// Solo Doc
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
	private Municipio municipio;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
	private PersonaContacto contacto;

	
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "explotacion_parcela", joinColumns = @JoinColumn(name = "idexplotacion"), inverseJoinColumns = @JoinColumn(name = "idparcela"))
	//@JsonManagedReference 
	private List<Parcela> parcelas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "explotacion_maquina", joinColumns = @JoinColumn(name = "idexplotacion"), inverseJoinColumns = @JoinColumn(name = "idmaquina"))
	//@JsonManagedReference 
	private List<Maquina> maquinaria;
	


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "explotacion")
    private Set<PersonaExplotacion> personasExplotacion;

	
	
	private String rutaImagen;

	
}
