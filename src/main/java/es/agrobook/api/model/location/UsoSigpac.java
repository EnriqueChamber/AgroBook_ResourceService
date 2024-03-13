package es.agrobook.api.model.location;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsoSigpac {
	
	@Id
	@Column(length = 2)
	private String codigo;

	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne(optional = false)
	private AgrupacionPaises agrupacionPaises;


	// Entidades enlazadas

	@OneToMany(mappedBy = "pais")
	private Set<ComunidadAutonoma> comunidadesAutonomas;
	

	/*
	Uso SIGPAC	Descripción
    AG	CORRIENTES Y SUPERFICIES DE AGUA
    CA	VIALES
    CF	Asociación Cítricos-Frutales
    CI	CITRICOS
    CO	CONTORNO OLIVAR
    CS	Asociación Cítricos-Frutales de cáscara
    CV	Asociación Cítricos-Viñedo
    ED	EDIFICACIONES
    EP	ELEMENTO DEL PAISAJE
    FF	Asociación Frutales-Frutales de cáscara
    FL	FRUTOS SECOS Y OLIVAR
    FO	FORESTAL
    FS	FRUTOS SECOS
    FV	FRUTOS SECOS Y VIÑEDO
    FY	FRUTALES
    IM	IMPRODUCTIVOS
    IS	ISLAS
    IV	INVERNADEROS Y CULTIVOS BAJO PLASTICO
    MT	MATORRAL
    OC	Asociación Olivar-Cítricos
    OF	OLIVAR -  FRUTAL
    OP	Otros cultivos Permanentes
    OV	OLIVAR
    PA	PASTO CON ARBOLADO
    PR	PASTO ARBUSTIVO
    PS	PASTIZAL
    TA	TIERRAS ARABLES
    TH	HUERTA
    VF	VIÑEDO - FRUTAL
    VI	VIÑEDO
    VO	VIÑEDO - OLIVAR
    ZC	ZONA CONCENTRADA NO INCLUIDA EN LA ORTOF
    ZU	ZONA URBANA
    ZV	ZONA CENSURADA

    */
}
