package es.agrobook.api.model.location;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ComunidadAutonoma {
	
	@Id
	private Short idCatastro;

	@Column(nullable = true)
	private Short idINE;

	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne(optional = false)
	private Pais pais;


	// Entidades enlazadas

	@OneToMany(mappedBy = "comunidadAutonoma")
	private Set<Provincia> provincias;
	

	/*
	Código catastro	Código INE	Descripción
	0		Comunidad Desconocida
	1	1	Comunidad Autónoma de Andalucía
	2	2	Comunidad Autónoma de Aragón
	3	3	Principado de Asturias
	4	4	Comunidad Autónoma de Illes Balears
	5	5	Comunidad Autónoma de Canarias
	6	6	Comunidad Autónoma de Cantabria
	7	8	Comunidad Autónoma de Castilla-La Mancha
	8	7	Comunidad Autónoma de Castilla y León
	9	9	Comunidad Autónoma de Cataluña
	10	11	Comunidad Autónoma de Extremadura
	11	12	Comunidad Autónoma de Galicia
	12	13	Comunidad de Madrid
	13	14	Región de Murcia
	14	15	Comunidad Foral de Navarra
	15	16	Comunidad Autónoma del País Vasco
	16	17	Comunidad Autónoma de La Rioja
	17	10	Comunidad Valenciana

	 */
}
