package es.agrobook.api.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Parcela{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idparcela")
	private long id;
	private String nombre;

	// REFERENCIAS SIGPAC
	//@OneToOne(mappedBy = "id")
	//private Municipio municipio; // Integra Código Provincia, codigo Municipio, nombre Municipio
	private int agregado; 					// Doc y Web
	private int zona;						// Doc y Web
	private int poligono;					// Doc y Web
	private int parcela;					// Doc y Web
	private int recinto;					// Doc y (Web -> Parcela = Recinto Sigpac)
	private float superficie;				// Doc y (Web -> Parcela = Recinto Sigpac)
	private float pendiente;				// Solo Web -> Parcela = Recinto Sigpac
	private String referenciaCatastral;		// Solo Web
	private String uso;						// Doc y (Web -> Parcela = Recinto Sigpac)
	private float subvencionalidad;			// Solo Web
	private int coeficienteRegadio;			// Solo Web
	// pendientes en Web: pjeSubvencionado, supSubvencionada, coefRegadio, incidencias, región
	// FIN REFERENCIAS SIGPAC

	// DATOS AGRONOMICOS
    @Column(name="secano")
	private String secanoRegadio; 			// Solo Doc     //Secano (SEC), aspersión (ASP), goteo o localizado (LOC), por gravedad (GRA).
	private String ventilacion; 			// Solo Doc //Aire libre (AL), malla (M), cubierta bajo plástico (BP), invernadero (INV)

	// los siguientes datos serán de la clase cultivo, el cual tendrá asociado una parcela
	//private float superficieCultivada; 		// Solo Doc
	//private String especie; 				// Solo Doc
	//private String variedad; 				// Solo Doc
	// FIN DATOS AGRONOMICOS

    
	// CONSTRUCTORS
	
	public Parcela() {

	}

	public Parcela(long id, String nombre, Municipio municipio, int agregado, int zona, int poligono,
			int parcela, int recinto, float superficie, float pendiente, String referenciaCatastral, String uso,
			float subvencionalidad, int coeficienteRegadio, String secanoRegadio, String ventilacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		//this.municipio = municipio;
		this.agregado = agregado;
		this.zona = zona;
		this.poligono = poligono;
		this.parcela = parcela;
		this.recinto = recinto;
		this.superficie = superficie;
		this.pendiente = pendiente;
		this.referenciaCatastral = referenciaCatastral;
		this.uso = uso;
		this.subvencionalidad = subvencionalidad;
		this.coeficienteRegadio = coeficienteRegadio;
		this.secanoRegadio = secanoRegadio;
		this.ventilacion = ventilacion;
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

	/*public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}*/

	public int getAgregado() {
		return agregado;
	}

	public void setAgregado(int agregado) {
		this.agregado = agregado;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public int getPoligono() {
		return poligono;
	}

	public void setPoligono(int poligono) {
		this.poligono = poligono;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public int getRecinto() {
		return recinto;
	}

	public void setRecinto(int recinto) {
		this.recinto = recinto;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public float getPendiente() {
		return pendiente;
	}

	public void setPendiente(float pendiente) {
		this.pendiente = pendiente;
	}

	public String getReferenciaCatastral() {
		return referenciaCatastral;
	}

	public void setReferenciaCatastral(String referenciaCatastral) {
		this.referenciaCatastral = referenciaCatastral;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public float getSubvencionalidad() {
		return subvencionalidad;
	}

	public void setSubvencionalidad(float subvencionalidad) {
		this.subvencionalidad = subvencionalidad;
	}

	public int getCoeficienteRegadio() {
		return coeficienteRegadio;
	}

	public void setCoeficienteRegadio(int coeficienteRegadio) {
		this.coeficienteRegadio = coeficienteRegadio;
	}

	public String getSecanoRegadio() {
		return secanoRegadio;
	}

	public void setSecanoRegadio(String secanoRegadio) {
		this.secanoRegadio = secanoRegadio;
	}

	public String getVentilacion() {
		return ventilacion;
	}

	public void setVentilacion(String ventilacion) {
		this.ventilacion = ventilacion;
	}

	/*public float getSuperficieCultivada() {
		return superficieCultivada;
	}

	public void setSuperficieCultivada(float superficieCultivada) {
		this.superficieCultivada = superficieCultivada;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}*/



}
