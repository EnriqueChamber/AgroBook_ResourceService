package es.agrobook.api.model.location;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Provincia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String descripcion;

	@OneToOne()
	private ComunidadAutonoma comunidadAutonoma;
	

	/*
	CCAA	Provincia	Nombre Provincia
	15	1	ÁLAVA
	7	2	ALBACETE
	17	3	ALICANTE
	1	4	ALMERÍA
	8	5	AVILA
	10	6	BADAJOZ
	4	7	BALEARES
	9	8	BARCELONA
	8	9	BURGOS
	10	10	CÁCERES
	1	11	CÁDIZ
	17	12	CASTELLÓN
	7	13	CIUDAD REAL
	1	14	CÓRDOBA
	11	15	LA CORUÑA
	7	16	CUENCA
	9	17	GERONA
	1	18	GRANADA
	7	19	GUADALAJARA
	15	20	GUIPUZCOA
	1	21	HUELVA
	2	22	HUESCA
	1	23	JAÉN
	8	24	LEÓN
	9	25	LERIDA
	16	26	LA RIOJA
	11	27	LUGO
	12	28	MADRID
	1	29	MÁLAGA
	13	30	MURCIA
	14	31	NAVARRA
	11	32	OURENSE
	3	33	ASTURIAS
	8	34	PALENCIA
	5	35	LAS PALMAS
	11	36	PONTEVEDRA
	8	37	SALAMANCA
	5	38	SANTA CRUZ DE TENERIFE
	6	39	CANTABRIA
	8	40	SEGOVIA
	1	41	SEVILLA
	8	42	SORIA
	9	43	TARRAGONA
	2	44	TERUEL
	7	45	TOLEDO
	17	46	VALENCIA
	8	47	VALLADOLID
	15	48	VIZCAYA
	8	49	ZAMORA
	2	50	ZARAGOZA

	 */
}
