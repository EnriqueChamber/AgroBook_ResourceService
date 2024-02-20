package es.agrobook.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Municipio {

	@Id
	@PrimaryKeyJoinColumn(name="idmunicipipo")
	private int id;
	private int condigoCA;
	private String nombreCA;
	private int codigoProvincia;
	private String nombreProvincia;
	private int codigoMunicipioIne;
	private int codigoMunicipio;
	private String nombreMunicipio;


	// CONSTRUCTORS
	
	public Municipio() {

	}
	public Municipio(int id, int condigoCA, String nombreCA, int codigoProvincia, String nombreProvincia,
			int codigoMunicipioIne, int codigoMunicipio, String nombreMunicipio) {
		super();
		this.id = id;
		this.condigoCA = condigoCA;
		this.nombreCA = nombreCA;
		this.codigoProvincia = codigoProvincia;
		this.nombreProvincia = nombreProvincia;
		this.codigoMunicipioIne = codigoMunicipioIne;
		this.codigoMunicipio = codigoMunicipio;
		this.nombreMunicipio = nombreMunicipio;
	}


	// GETTERS AND SETTERS 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCondigoCA() {
		return condigoCA;
	}
	public void setCondigoCA(int condigoCA) {
		this.condigoCA = condigoCA;
	}
	public String getNombreCA() {
		return nombreCA;
	}
	public void setNombreCA(String nombreCA) {
		this.nombreCA = nombreCA;
	}
	public int getCodigoProvincia() {
		return codigoProvincia;
	}
	public void setCodigoProvincia(int condigoProvincia) {
		this.codigoProvincia = condigoProvincia;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	public int getCodigoMunicipioIne() {
		return codigoMunicipioIne;
	}
	public void setCodigoMunicipioIne(int codigoMunicipioIne) {
		this.codigoMunicipioIne = codigoMunicipioIne;
	}
	public int getCodigoMunicipio() {
		return codigoMunicipio;
	}
	public void setCodigoMunicipio(int codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
}
