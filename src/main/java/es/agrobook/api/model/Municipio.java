package es.agrobook.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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

}
