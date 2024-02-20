package es.agrobook.api.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Explotacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idexplotacion")
	private long id;
	private String nombre;
	private String registroNacional; 			// Solo Doc
	private String registroAutonomico; 			// Solo Doc
	private String direccion; 					// Solo Doc
	private String localidad; 					// Solo Doc
	private int codigoPostal; 					// Solo Doc
	private String provincia; 					// Solo Doc
	private int telefonoFijo; 					// Solo Doc
	private int telefonoMovil; 					// Solo Doc
	private String email; 						// Solo Doc
	private String rutaImagen;
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "explotacion_parcela",
        joinColumns = @JoinColumn(name = "idexplotacion"),
        inverseJoinColumns = @JoinColumn(name = "idparcela")
    )
	private List<Parcela> parcelas;
	

    @OneToMany(mappedBy = "explotacion")
    private Set<ExplotacionUsuario> explotacionesUsuarios;

	// CONSTRUCTORS
	
	public Explotacion() {
		
	}
	

	// GETTERS AND SETTERS 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegistroNacional() {
		return registroNacional;
	}

	public void setRegistroNacional(String registroNacional) {
		this.registroNacional = registroNacional;
	}

	public String getRegistroAutonomico() {
		return registroAutonomico;
	}

	public void setRegistroAutonomico(String registroAutonomico) {
		this.registroAutonomico = registroAutonomico;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
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


	public Set<ExplotacionUsuario> getExplotacionesUsuarios() {
		return explotacionesUsuarios;
	}


	public void setExplotacionesUsuarios(Set<ExplotacionUsuario> explotacionesUsuarios) {
		this.explotacionesUsuarios = explotacionesUsuarios;
	}

}
