package es.agrobook.api.model.cultivo;

import java.util.Set;

import es.agrobook.api.model.enums.IndicacionGeografica;
import es.agrobook.api.model.location.Municipio;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DenominacionOrigen {

	@Id
	private int id;

    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private IndicacionGeografica indicacionGeografica;

    @Column(nullable = false)
	private String nombre;

    @Column(nullable = false)
	private String registroUE;

    @ManyToOne(optional = false)
	private IndicacionGeograficaSubclase subclase;

    @ManyToMany
	private Set<Municipio> municipios;




	/*
	Tipo_IIGG	ID_IIGG	IIGG nombre_oficial	Num_exp_UE	ID_Subclase	Subclase	INE_COD_PROV	INE_PROV
	DOP	329	Prado de Irache	PDO-ES-A0182	43	VP: “Vino de Pago”	31	Navarra
	DOP	330	Priorat / Priorato	PDO-ES-A1560	41	DOCa: “Vino de Denominación de Origen Calificada”	43	Tarragona
	DOP	331	Rías Baixas	PDO-ES-A1119	42	DO: “Vino de Denominación de Origen”	15	A Coruña
	DOP	331	Rías Baixas	PDO-ES-A1119	42	DO: “Vino de Denominación de Origen”	36	Pontevedra
	DOP	332	Ribeira Sacra	PDO-ES-A1128	42	DO: “Vino de Denominación de Origen”	27	Lugo
	DOP	332	Ribeira Sacra	PDO-ES-A1128	42	DO: “Vino de Denominación de Origen”	32	Ourense
	DOP	334	Ribeiro	PDO-ES-A1123	42	DO: “Vino de Denominación de Origen”	32	Ourense
	DOP	336	Ribera del Duero	PDO-ES-A0626	42	DO: “Vino de Denominación de Origen”	9	Burgos
	DOP	336	Ribera del Duero	PDO-ES-A0626	42	DO: “Vino de Denominación de Origen”	40	Segovia
	DOP	336	Ribera del Duero	PDO-ES-A0626	42	DO: “Vino de Denominación de Origen”	42	Soria
	DOP	336	Ribera del Duero	PDO-ES-A0626	42	DO: “Vino de Denominación de Origen”	47	Valladolid
	DOP	338	Ribera del Guadiana	PDO-ES-A1295	42	DO: “Vino de Denominación de Origen”	6	Badajoz
	DOP	338	Ribera del Guadiana	PDO-ES-A1295	42	DO: “Vino de Denominación de Origen”	10	Cáceres
	DOP	340	Ribera del Júcar	PDO-ES-A0049	42	DO: “Vino de Denominación de Origen”	16	Cuenca
	DOP	342	Rioja	PDO-ES-A0117	41	DOCa: “Vino de Denominación de Origen Calificada”	1	Álava
	DOP	342	Rioja	PDO-ES-A0117	41	DOCa: “Vino de Denominación de Origen Calificada”	9	Burgos
	DOP	342	Rioja	PDO-ES-A0117	41	DOCa: “Vino de Denominación de Origen Calificada”	31	Navarra
	DOP	342	Rioja	PDO-ES-A0117	41	DOCa: “Vino de Denominación de Origen Calificada”	26	La Rioja
	DOP	343	Rueda	PDO-ES-A0889	42	DO: “Vino de Denominación de Origen”	5	Ávila
	DOP	343	Rueda	PDO-ES-A0889	42	DO: “Vino de Denominación de Origen”	40	Segovia
	DOP	343	Rueda	PDO-ES-A0889	42	DO: “Vino de Denominación de Origen”	47	Valladolid
	DOP	345	Sierra de Salamanca	PDO-ES-A0631	44	VC: "Vino de Calidad”	37	Salamanca
	DOP	349	Sierras de Málaga	PDO-ES-A1480	42	DO: “Vino de Denominación de Origen”	14	Córdoba
	DOP	349	Sierras de Málaga	PDO-ES-A1480	42	DO: “Vino de Denominación de Origen”	29	Málaga
	DOP	350	Somontano	PDO-ES-A0534	42	DO: “Vino de Denominación de Origen”	22	Huesca
	DOP	351	Tacoronte-Acentejo	PDO-ES-A0115	42	DO: “Vino de Denominación de Origen”	38	Santa Cruz de Tenerife
	DOP	352	Tarragona	PDO-ES-A1555	42	DO: “Vino de Denominación de Origen”	43	Tarragona
	DOP	353	Terra Alta	PDO-ES-A1556	42	DO: “Vino de Denominación de Origen”	43	Tarragona
	DOP	354	Tierra del Vino de Zamora	PDO-ES-A0634	42	DO: “Vino de Denominación de Origen”	37	Salamanca
	DOP	354	Tierra del Vino de Zamora	PDO-ES-A0634	42	DO: “Vino de Denominación de Origen”	49	Zamora
	DOP	355	Toro	PDO-ES-A0886	42	DO: “Vino de Denominación de Origen”	47	Valladolid
	DOP	355	Toro	PDO-ES-A0886	42	DO: “Vino de Denominación de Origen”	49	Zamora
	DOP	357	Uclés	PDO-ES-A0050	42	DO: “Vino de Denominación de Origen”	16	Cuenca
	DOP	357	Uclés	PDO-ES-A0050	42	DO: “Vino de Denominación de Origen”	45	Toledo
	DOP	358	Utiel-Requena	PDO-ES-A0874	42	DO: “Vino de Denominación de Origen”	46	Valencia
	DOP	360	Valdeorras	PDO-ES-A1132	42	DO: “Vino de Denominación de Origen”	32	Ourense
	DOP	361	Valdepeñas	PDO-ES-A0051	42	DO: “Vino de Denominación de Origen”	13	Ciudad Real
	DOP	362	Valencia	PDO-ES-A0872	42	DO: “Vino de Denominación de Origen”	2	Albacete
	DOP	362	Valencia	PDO-ES-A0872	42	DO: “Vino de Denominación de Origen”	3	Alicante
	DOP	362	Valencia	PDO-ES-A0872	42	DO: “Vino de Denominación de Origen”	46	Valencia
	DOP	363	Valle de Güímar	PDO-ES-A0980	42	DO: “Vino de Denominación de Origen”	38	Santa Cruz de Tenerife
	DOP	364	Valle de la Orotava	PDO-ES-A1040	42	DO: “Vino de Denominación de Origen”	38	Santa Cruz de Tenerife
	DOP	367	Vallegarcía	PDO-ES-02085	43	VP: “Vino de Pago”	13	Ciudad Real
	DOP	368	Valles de Benavente	PDO-ES-A0646	44	VC: "Vino de Calidad”	49	Zamora
	DOP	370	Valtiendas	PDO-ES-A0747	44	VC: "Vino de Calidad”	40	Segovia
	DOP	371	Vera de Estenas	PDO-ES-N1665	43	VP: “Vino de Pago”	46	Valencia
	DOP	373	Vinos de Madrid	PDO-ES-A1525	42	DO: “Vino de Denominación de Origen”	28	Madrid
	DOP	374	Ycoden-Daute-Isora	PDO-ES-A0114	42	DO: “Vino de Denominación de Origen”	38	Santa Cruz de Tenerife
	DOP	375	Yecla	PDO-ES-A0606	42	DO: “Vino de Denominación de Origen”	30	Murcia
	DOP	382	Urueña	PDO-ES-02485	42	DO: “Vino de Denominación de Origen”	47	Valladolid
	DOP	378	Dehesa Peñalba	PDO-ES-02592	42	DO: “Vino de Denominación de Origen”	47	Valladolid
	DOP	376	Abadía Retuerta	PDO-ES-02481	42	DO: “Vino de Denominación de Origen”	47	Valladolid
	DOP	377	Bolandin	PDO-ES-N1876	42	DO: “Vino de Denominación de Origen”	31	Navarra
	DOP	213	Queso de Acehúche	PDO-ES-02621	9	1.3 Quesos	10	Cáceres
	DOP	215	Alubia de Anguiano	PDO-ES-02642	15	1.6 Legumbres	26	La Rioja
	DOP	214	Nuez de Pedroso	PDO-ES-02643	19	1.6 Otros vegetales (frutos secos)	26	La Rioja
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	31	Navarra
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	26	La Rioja
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	43	Tarragona
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	46	Valencia
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	50	Zaragoza
	DOP	267	Cebreros	PDO-ES-02348	44	VC: "Vino de Calidad”	5	Ávila
	DOP	268	Arabako Txakolina / Txakolí de Álava / Chacolí de Álava	PDO-ES-A0732	42	DO: “Vino de Denominación de Origen”	1	Álava
	DOP	269	Bizkaiko Txakolina / Chacolí de Bizkaia / Txakolí de Bizkaia	PDO-ES-A0746	42	DO: “Vino de Denominación de Origen”	48	Vizcaya
	DOP	270	Getariako Txakolina / Chacolí de Getaria / Txakolí de Getaria	PDO-ES-A0741	42	DO: “Vino de Denominación de Origen”	20	Guipúzcoa
	DOP	271	Chozas Carrascal	PDO-ES-N1637	43	VP: “Vino de Pago”	46	Valencia
	DOP	272	Cigales	PDO-ES-A0622	42	DO: “Vino de Denominación de Origen”	34	Palencia
	DOP	272	Cigales	PDO-ES-A0622	42	DO: “Vino de Denominación de Origen”	47	Valladolid
	DOP	273	Conca de Barberà	PDO-ES-A1422	42	DO: “Vino de Denominación de Origen”	43	Tarragona
	DOP	274	Condado de Huelva	PDO-ES-A1485	42	DO: “Vino de Denominación de Origen”	21	Huelva
	DOP	277	Costers del Segre	PDO-ES-A1523	42	DO: “Vino de Denominación de Origen”	25	Lleida
	DOP	277	Costers del Segre	PDO-ES-A1523	42	DO: “Vino de Denominación de Origen”	43	Tarragona
	DOP	279	Dehesa del Carrizal	PDO-ES-A0054	43	VP: “Vino de Pago”	13	Ciudad Real
	DOP	281	Dominio de Valdepusa	PDO-ES-A0052	43	VP: “Vino de Pago”	45	Toledo
	DOP	282	El Hierro	PDO-ES-A1250	42	DO: “Vino de Denominación de Origen”	38	Santa Cruz de Tenerife
	DOP	283	El Terrerazo	PDO-ES-A0940	43	VP: “Vino de Pago”	46	Valencia
	DOP	284	El Vicario	PDO-ES-N1634	43	VP: “Vino de Pago”	13	Ciudad Real
	DOP	285	Empordà	PDO-ES-A1548	42	DO: “Vino de Denominación de Origen”	17	Girona
	DOP	287	Finca Élez	PDO-ES-A0053	43	VP: “Vino de Pago”	2	Albacete
	DOP	289	Gran Canaria	PDO-ES-A0112	42	DO: “Vino de Denominación de Origen”	35	Las Palmas
	DOP	290	Granada	PDO-ES-A1475	42	DO: “Vino de Denominación de Origen”	18	Granada
	DOP	291	Guijoso	PDO-ES-A0058	43	VP: “Vino de Pago”	2	Albacete
	DOP	295	Islas Canarias	PDO-ES-A1511	44	VC: "Vino de Calidad”	35	Las Palmas
	DOP	295	Islas Canarias	PDO-ES-A1511	44	VC: "Vino de Calidad”	38	Santa Cruz de Tenerife
	DOP	296	Jerez-Xérès-Sherry / Jerez / Xérès / Sherry	PDO-ES-A1483	42	DO: “Vino de Denominación de Origen”	11	Cádiz
	DOP	296	Jerez-Xérès-Sherry / Jerez / Xérès / Sherry	PDO-ES-A1483	42	DO: “Vino de Denominación de Origen”	41	Sevilla
	DOP	297	Jumilla	PDO-ES-A0109	42	DO: “Vino de Denominación de Origen”	2	Albacete
	DOP	297	Jumilla	PDO-ES-A0109	42	DO: “Vino de Denominación de Origen”	30	Murcia
	DOP	298	La Gomera	PDO-ES-A0111	42	DO: “Vino de Denominación de Origen”	38	Santa Cruz de Tenerife
	DOP	299	La Jaraba	PDO-ES-01895	43	VP: “Vino de Pago”	16	Cuenca
	DOP	300	La Mancha	PDO-ES-A0045	42	DO: “Vino de Denominación de Origen”	2	Albacete
	DOP	300	La Mancha	PDO-ES-A0045	42	DO: “Vino de Denominación de Origen”	13	Ciudad Real
	DOP	300	La Mancha	PDO-ES-A0045	42	DO: “Vino de Denominación de Origen”	16	Cuenca
	DOP	300	La Mancha	PDO-ES-A0045	42	DO: “Vino de Denominación de Origen”	45	Toledo
	DOP	301	La Palma	PDO-ES-A0510	42	DO: “Vino de Denominación de Origen”	38	Santa Cruz de Tenerife
	DOP	303	Lanzarote	PDO-ES-A0113	42	DO: “Vino de Denominación de Origen”	35	Las Palmas
	DOP	305	Lebrija	PDO-ES-A1478	44	VC: "Vino de Calidad”	41	Sevilla
	DOP	306	León	PDO-ES-A0882	42	DO: “Vino de Denominación de Origen”	24	León
	DOP	306	León	PDO-ES-A0882	42	DO: “Vino de Denominación de Origen”	47	Valladolid
	DOP	308	Los Balagueses	PDO-ES-A0941	43	VP: “Vino de Pago”	46	Valencia
	DOP	309	Los Cerrillos	PDO-ES-02228	43	VP: “Vino de Pago”	13	Ciudad Real
	DOP	311	Málaga	PDO-ES-A1481	42	DO: “Vino de Denominación de Origen”	14	Córdoba
	DOP	311	Málaga	PDO-ES-A1481	42	DO: “Vino de Denominación de Origen”	29	Málaga
	DOP	313	Manchuela	PDO-ES-A0046	42	DO: “Vino de Denominación de Origen”	2	Albacete
	DOP	313	Manchuela	PDO-ES-A0046	42	DO: “Vino de Denominación de Origen”	16	Cuenca
	DOP	314	Manzanilla-Sanlúcar de Barrameda / Manzanilla	PDO-ES-A1482	42	DO: “Vino de Denominación de Origen”	11	Cádiz
	DOP	314	Manzanilla-Sanlúcar de Barrameda / Manzanilla	PDO-ES-A1482	42	DO: “Vino de Denominación de Origen”	41	Sevilla
	DOP	315	Méntrida	PDO-ES-A0047	42	DO: “Vino de Denominación de Origen”	45	Toledo
	DOP	316	Mondéjar	PDO-ES-A0048	42	DO: “Vino de Denominación de Origen”	19	Guadalajara
	DOP	317	Monterrei	PDO-ES-A1114	42	DO: “Vino de Denominación de Origen”	32	Ourense
	DOP	318	Montilla-Moriles	PDO-ES-A1479	42	DO: “Vino de Denominación de Origen”	14	Córdoba
	DOP	319	Montsant	PDO-ES-A1550	42	DO: “Vino de Denominación de Origen”	43	Tarragona
	DOP	321	Navarra	PDO-ES-A0127	42	DO: “Vino de Denominación de Origen”	31	Navarra
	DOP	323	Pago de Arínzano	PDO-ES-A0183	43	VP: “Vino de Pago”	31	Navarra
	DOP	324	Pago de Otazu	PDO-ES-A0184	43	VP: “Vino de Pago”	31	Navarra
	DOP	325	Pago Florentino	PDO-ES-A0057	43	VP: “Vino de Pago”	13	Ciudad Real
	DOP	326	Penedès	PDO-ES-A1551	42	DO: “Vino de Denominación de Origen”	8	Barcelona
	DOP	326	Penedès	PDO-ES-A1551	42	DO: “Vino de Denominación de Origen”	43	Tarragona
	DOP	327	Pla de Bages	PDO-ES-A1557	42	DO: “Vino de Denominación de Origen”	8	Barcelona
	DOP	328	Pla i Llevant	PDO-ES-A1038	42	DO: “Vino de Denominación de Origen”	7	Illes Balears
	DOP	160	Azafrán de la Mancha	PDO-ES-0112	22	1.8 Especias	16	Cuenca
	DOP	160	Azafrán de la Mancha	PDO-ES-0112	22	1.8 Especias	45	Toledo
	DOP	164	Miel de La Alcarria	PDO-ES-0079	10	1.4 Miel	16	Cuenca
	DOP	164	Miel de La Alcarria	PDO-ES-0079	10	1.4 Miel	19	Guadalajara
	DOP	167	Queso Manchego	PDO-ES-0087	9	1.3 Quesos	2	Albacete
	DOP	167	Queso Manchego	PDO-ES-0087	9	1.3 Quesos	13	Ciudad Real
	DOP	167	Queso Manchego	PDO-ES-0087	9	1.3 Quesos	16	Cuenca
	DOP	167	Queso Manchego	PDO-ES-0087	9	1.3 Quesos	45	Toledo
	DOP	168	Pimentón de Murcia	PDO-ES-0113	22	1.8 Especias	3	Alicante
	DOP	168	Pimentón de Murcia	PDO-ES-0113	22	1.8 Especias	4	Almería
	DOP	168	Pimentón de Murcia	PDO-ES-0113	22	1.8 Especias	18	Granada
	DOP	385	Aceite de Madrid	PDO-ES-02812	11	1.5 Aceites  de Oliva Virgen	28	Madrid
	DOP	212	Nueces de Nerpio	PDO-ES-02786	19	1.6 Otros vegetales (frutos secos)	2	Albacete
	DOP	212	Nueces de Nerpio	PDO-ES-02786	19	1.6 Otros vegetales (frutos secos)	30	Murcia
	DOP	386	Aceite Villuercas Ibores Jara	PDO-ES-02828	11	1.5 Aceites  de Oliva Virgen	10	Cáceres
	DOP	168	Pimentón de Murcia	PDO-ES-0113	22	1.8 Especias	30	Murcia
	DOP	169	Pera de Jumilla	PDO-ES-0315	13	1.6 Frutas	30	Murcia
	DOP	171	Queso de Murcia	PDO-ES-0168	9	1.3 Quesos	30	Murcia
	DOP	172	Queso de Murcia al vino	PDO-ES-0204	9	1.3 Quesos	30	Murcia
	DOP	173	Aceite de Navarra	PDO-ES-0695	11	1.5 Aceites  de Oliva Virgen	31	Navarra
	DOP	176	Pimientos del Piquillo de Lodosa	PDO-ES-0080	14	1.6 Hortalizas	31	Navarra
	DOP	178	Roncal	PDO-ES-0091	9	1.3 Quesos	31	Navarra
	DOP	181	Aceite de la Comunitat Valenciana	PDO-ES-0720	11	1.5 Aceites  de Oliva Virgen	3	Alicante
	DOP	181	Aceite de la Comunitat Valenciana	PDO-ES-0720	11	1.5 Aceites  de Oliva Virgen	12	Castellon
	DOP	181	Aceite de la Comunitat Valenciana	PDO-ES-0720	11	1.5 Aceites  de Oliva Virgen	46	Valencia
	DOP	182	Arroz de Valencia / Arròs de València	PDO-ES-0151	16	1.6 Arroces	3	Alicante
	DOP	182	Arroz de Valencia / Arròs de València	PDO-ES-0151	16	1.6 Arroces	12	Castellon
	DOP	182	Arroz de Valencia / Arròs de València	PDO-ES-0151	16	1.6 Arroces	46	Valencia
	DOP	183	Chufa de Valencia / Xufa de València	PDO-ES-0055	23	1.8 Frutos diversos (tubérculos, raíces, etc)	46	Valencia
	DOP	184	Alcachofa de Benicarló / Carxofa de Benicarló	PDO-ES-0202	14	1.6 Hortalizas	12	Castellon
	DOP	185	Kaki Ribera del Xúquer	PDO-ES-0114	13	1.6 Frutas	46	Valencia
	DOP	186	Nísperos Callosa d'En Sarriá	PDO-ES-0074	13	1.6 Frutas	3	Alicante
	DOP	187	Uva de mesa embolsada del Vinalopó	PDO-ES-0075	13	1.6 Frutas	3	Alicante
	DOP	188	Granada Mollar de Elche / Granada de Elche	PDO-ES-01230	13	1.6 Frutas	3	Alicante
	DOP	206	Pebre bord de Mallorca / Pimentón de Mallorca	PDO-ES-02465	22	1.8 Especias	7	Illes Balears
	DOP	238	Abona	PDO-ES-A0975	42	DO: “Vino de Denominación de Origen”	38	Santa Cruz de Tenerife
	DOP	239	Alella	PDO-ES-A1423	42	DO: “Vino de Denominación de Origen”	8	Barcelona
	DOP	240	Alicante	PDO-ES-A1526	42	DO: “Vino de Denominación de Origen”	3	Alicante
	DOP	240	Alicante	PDO-ES-A1526	42	DO: “Vino de Denominación de Origen”	30	Murcia
	DOP	241	Almansa	PDO-ES-A0044	42	DO: “Vino de Denominación de Origen”	2	Albacete
	DOP	243	Arlanza	PDO-ES-A0613	42	DO: “Vino de Denominación de Origen”	9	Burgos
	DOP	243	Arlanza	PDO-ES-A0613	42	DO: “Vino de Denominación de Origen”	34	Palencia
	DOP	244	Arribes	PDO-ES-A0614	42	DO: “Vino de Denominación de Origen”	37	Salamanca
	DOP	244	Arribes	PDO-ES-A0614	42	DO: “Vino de Denominación de Origen”	49	Zamora
	DOP	245	Aylés	PDO-ES-A1522	43	VP: “Vino de Pago”	50	Zaragoza
	DOP	250	Bierzo	PDO-ES-A0615	42	DO: “Vino de Denominación de Origen”	24	León
	DOP	251	Binissalem	PDO-ES-A1056	42	DO: “Vino de Denominación de Origen”	7	Illes Balears
	DOP	252	Bullas	PDO-ES-A0536	42	DO: “Vino de Denominación de Origen”	30	Murcia
	DOP	254	Calatayud	PDO-ES-A0247	42	DO: “Vino de Denominación de Origen”	50	Zaragoza
	DOP	255	Calzadilla	PDO-ES-A0056	43	VP: “Vino de Pago”	16	Cuenca
	DOP	256	Campo de Borja	PDO-ES-A0180	42	DO: “Vino de Denominación de Origen”	50	Zaragoza
	DOP	258	Campo de La Guardia	PDO-ES-A0055	43	VP: “Vino de Pago”	45	Toledo
	DOP	259	Cangas	PDO-ES-A0119	44	VC: "Vino de Calidad”	33	Asturias
	DOP	260	Cariñena	PDO-ES-A0043	42	DO: “Vino de Denominación de Origen”	50	Zaragoza
	DOP	261	Casa del Blanco	PDO-ES-A0060	43	VP: “Vino de Pago”	13	Ciudad Real
	DOP	265	Cataluña / Catalunya	PDO-ES-A1549	42	DO: “Vino de Denominación de Origen”	8	Barcelona
	DOP	265	Cataluña / Catalunya	PDO-ES-A1549	42	DO: “Vino de Denominación de Origen”	17	Girona
	DOP	265	Cataluña / Catalunya	PDO-ES-A1549	42	DO: “Vino de Denominación de Origen”	25	Lleida
	DOP	265	Cataluña / Catalunya	PDO-ES-A1549	42	DO: “Vino de Denominación de Origen”	43	Tarragona
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	1	Álava
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	6	Badajoz
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	8	Barcelona
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	17	Girona
	DOP	266	Cava	PDO-ES-A0735	42	DO: “Vino de Denominación de Origen”	25	Lleida
	DOP	68	Manzana Reineta del Bierzo	PDO-ES-0115	13	1.6 Frutas	24	León
	DOP	76	Mantequilla de Soria	PDO-ES-0326	12	1.5 Mantequillas	42	Soria
	DOP	79	Queso Zamorano	PDO-ES-0089	9	1.3 Quesos	49	Zamora
	DOP	82	Papas Antiguas de Canarias	PDO-ES-0866	14	1.6 Hortalizas	35	Las Palmas
	DOP	82	Papas Antiguas de Canarias	PDO-ES-0866	14	1.6 Hortalizas	38	Santa Cruz de Tenerife
	DOP	84	Miel de Tenerife	PDO-ES-0943	10	1.4 Miel	38	Santa Cruz de Tenerife
	DOP	85	Cochinilla de Canarias	PDO-ES-01302	29	2.12 Cochinilla	35	Las Palmas
	DOP	85	Cochinilla de Canarias	PDO-ES-01302	29	2.12 Cochinilla	38	Santa Cruz de Tenerife
	DOP	86	Queso de Flor de Guía / Queso de Media Flor de Guía / Queso de Guía	PDO-ES-0605	9	1.3 Quesos	35	Las Palmas
	DOP	87	Queso Majorero	PDO-ES-0045	9	1.3 Quesos	35	Las Palmas
	DOP	88	Queso Palmero / Queso de la Palma	PDO-ES-0172	9	1.3 Quesos	38	Santa Cruz de Tenerife
	DOP	90	Miel de Liébana	PDO-ES-01196	10	1.4 Miel	39	Cantabria
	DOP	92	Picón Bejes-Tresviso	PDO-ES-0084	9	1.3 Quesos	39	Cantabria
	DOP	93	Queso Nata de Cantabria	PDO-ES-0085	9	1.3 Quesos	39	Cantabria
	DOP	94	Quesucos de Liébana	PDO-ES-0090	9	1.3 Quesos	39	Cantabria
	DOP	95	Aceite de Terra Alta / Oli de Terra Alta	PDO-ES-0245	11	1.5 Aceites  de Oliva Virgen	43	Tarragona
	DOP	96	Aceite del Baix Ebre-Montsià / Oli del Baix Ebre-Montsià	PDO-ES-0274	11	1.5 Aceites  de Oliva Virgen	43	Tarragona
	DOP	97	Oli de l'Empordà / Aceite de L'Empordà	PDO-ES-1161	11	1.5 Aceites  de Oliva Virgen	17	Girona
	DOP	98	Les Garrigues	PDO-ES-0070	11	1.5 Aceites  de Oliva Virgen	25	Lleida
	DOP	99	Siurana	PDO-ES-0072	11	1.5 Aceites  de Oliva Virgen	43	Tarragona
	DOP	100	Arroz del Delta del Ebro / Arròs del Delta de l'Ebre	PDO-ES-0336	16	1.6 Arroces	43	Tarragona
	DOP	107	Avellana de Reus	PDO-ES-0046	19	1.6 Otros vegetales (frutos secos)	43	Tarragona
	DOP	108	Pera de Lleida	PDO-ES-0698	13	1.6 Frutas	25	Lleida
	DOP	111	Fesols de Santa Pau	PDO-ES-1226	15	1.6 Legumbres	17	Girona
	DOP	112	Mongeta del Ganxet	PDO-ES-0636	15	1.6 Legumbres	8	Barcelona
	DOP	112	Mongeta del Ganxet	PDO-ES-0636	15	1.6 Legumbres	17	Girona
	DOP	113	Mantequilla de l'Alt Urgell y la Cerdanya / Mantega de l'Alt Urgell i la Cerdanya	PDO-ES-0187	12	1.5 Mantequillas	17	Girona
	DOP	113	Mantequilla de l'Alt Urgell y la Cerdanya / Mantega de l'Alt Urgell i la Cerdanya	PDO-ES-0187	12	1.5 Mantequillas	25	Lleida
	DOP	116	Queso de l'Alt Urgell y la Cerdanya	PDO-ES-0094	9	1.3 Quesos	17	Girona
	DOP	116	Queso de l'Alt Urgell y la Cerdanya	PDO-ES-0094	9	1.3 Quesos	25	Lleida
	DOP	117	Aceite Monterrubio	PDO-ES-0198	11	1.5 Aceites  de Oliva Virgen	6	Badajoz
	DOP	118	Gata-Hurdes	PDO-ES-0121	11	1.5 Aceites  de Oliva Virgen	10	Cáceres
	DOP	121	Pimentón de la Vera	PDO-ES-0321	22	1.8 Especias	10	Cáceres
	DOP	122	Cereza del Jerte	PDO-ES-0233	13	1.6 Frutas	10	Cáceres
	DOP	123	Dehesa de Extremadura	PDO-ES-0076	4	1.2 Jamones Ibéricos	6	Badajoz
	DOP	123	Dehesa de Extremadura	PDO-ES-0076	4	1.2 Jamones Ibéricos	10	Cáceres
	DOP	124	Miel Villuercas-Ibores	PDO-ES-01268	10	1.4 Miel	10	Cáceres
	DOP	125	Queso de La Serena	PDO-ES-0086	9	1.3 Quesos	6	Badajoz
	DOP	126	Queso Ibores	PDO-ES-0261	9	1.3 Quesos	10	Cáceres
	DOP	127	Torta del Casar	PDO-ES-0213	9	1.3 Quesos	10	Cáceres
	DOP	134	Pemento de Herbón	PDO-ES-0509	14	1.6 Hortalizas	15	A Coruña
	DOP	134	Pemento de Herbón	PDO-ES-0509	14	1.6 Hortalizas	36	Pontevedra
	DOP	139	Mejillón de Galicia / Mexillón de Galicia	PDO-ES-0165	21	1.7 Moluscos	15	A Coruña
	DOP	139	Mejillón de Galicia / Mexillón de Galicia	PDO-ES-0165	21	1.7 Moluscos	36	Pontevedra
	DOP	144	Arzùa-Ulloa	PDO-ES-0497	9	1.3 Quesos	15	A Coruña
	DOP	144	Arzùa-Ulloa	PDO-ES-0497	9	1.3 Quesos	27	Lugo
	DOP	144	Arzùa-Ulloa	PDO-ES-0497	9	1.3 Quesos	36	Pontevedra
	DOP	145	Cebreiro	PDO-ES-0443	9	1.3 Quesos	27	Lugo
	DOP	146	Queso Tetilla / Queixo Tetilla	PDO-ES-0088	9	1.3 Quesos	15	A Coruña
	DOP	146	Queso Tetilla / Queixo Tetilla	PDO-ES-0088	9	1.3 Quesos	27	Lugo
	DOP	146	Queso Tetilla / Queixo Tetilla	PDO-ES-0088	9	1.3 Quesos	32	Ourense
	DOP	146	Queso Tetilla / Queixo Tetilla	PDO-ES-0088	9	1.3 Quesos	36	Pontevedra
	DOP	147	San Simón da Costa	PDO-ES-0359	9	1.3 Quesos	27	Lugo
	DOP	148	Aceite de la Rioja	PDO-ES-0312	11	1.5 Aceites  de Oliva Virgen	26	La Rioja
	DOP	152	Peras de Rincón de Soto	PDO-ES-0251	13	1.6 Frutas	26	La Rioja
	DOP	153	Queso Camerano	PDO-ES-0767	9	1.3 Quesos	26	La Rioja
	DOP	155	Aceite Campo de Montiel	PDO-ES-0590	11	1.5 Aceites  de Oliva Virgen	13	Ciudad Real
	DOP	156	Aceite Campo de Calatrava	PDO-ES-0642	11	1.5 Aceites  de Oliva Virgen	13	Ciudad Real
	DOP	157	Aceite de La Alcarria	PDO-ES-0562	11	1.5 Aceites  de Oliva Virgen	16	Cuenca
	DOP	157	Aceite de La Alcarria	PDO-ES-0562	11	1.5 Aceites  de Oliva Virgen	19	Guadalajara
	DOP	158	Montes de Toledo	PDO-ES-0083	11	1.5 Aceites  de Oliva Virgen	13	Ciudad Real
	DOP	158	Montes de Toledo	PDO-ES-0083	11	1.5 Aceites  de Oliva Virgen	45	Toledo
	DOP	160	Azafrán de la Mancha	PDO-ES-0112	22	1.8 Especias	2	Albacete
	DOP	160	Azafrán de la Mancha	PDO-ES-0112	22	1.8 Especias	13	Ciudad Real
	DOP	1	Calasparra	PDO-ES-0073	16	1.6 Arroces	2	Albacete
	DOP	1	Calasparra	PDO-ES-0073	16	1.6 Arroces	30	Murcia
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	5	Ávila
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	6	Badajoz
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	10	Cáceres
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	13	Ciudad Real
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	14	Córdoba
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	21	Huelva
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	37	Salamanca
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	40	Segovia
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	41	Sevilla
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	45	Toledo
	DOP	5	Guijuelo	PDO-ES-0077	4	1.2 Jamones Ibéricos	49	Zamora
	DOP	6	Jabugo	PDO-ES-0009	4	1.2 Jamones Ibéricos	6	Badajoz
	DOP	6	Jabugo	PDO-ES-0009	4	1.2 Jamones Ibéricos	10	Cáceres
	DOP	6	Jabugo	PDO-ES-0009	4	1.2 Jamones Ibéricos	11	Cádiz
	DOP	6	Jabugo	PDO-ES-0009	4	1.2 Jamones Ibéricos	14	Córdoba
	DOP	6	Jabugo	PDO-ES-0009	4	1.2 Jamones Ibéricos	21	Huelva
	DOP	6	Jabugo	PDO-ES-0009	4	1.2 Jamones Ibéricos	29	Málaga
	DOP	6	Jabugo	PDO-ES-0009	4	1.2 Jamones Ibéricos	41	Sevilla
	DOP	8	Idiazabal	PDO-ES-0082	9	1.3 Quesos	1	Álava
	DOP	8	Idiazabal	PDO-ES-0082	9	1.3 Quesos	48	Vizcaya
	DOP	8	Idiazabal	PDO-ES-0082	9	1.3 Quesos	20	Guipúzcoa
	DOP	8	Idiazabal	PDO-ES-0082	9	1.3 Quesos	31	Navarra
	DOP	9	Antequera	PDO-ES-0327	11	1.5 Aceites  de Oliva Virgen	14	Córdoba
	DOP	9	Antequera	PDO-ES-0327	11	1.5 Aceites  de Oliva Virgen	29	Málaga
	DOP	10	Baena	PDO-ES-0069	11	1.5 Aceites  de Oliva Virgen	14	Córdoba
	DOP	11	Estepa	PDO-ES-0341	11	1.5 Aceites  de Oliva Virgen	14	Córdoba
	DOP	11	Estepa	PDO-ES-0341	11	1.5 Aceites  de Oliva Virgen	41	Sevilla
	DOP	12	Aceite de Lucena	PDO-ES-0760	11	1.5 Aceites  de Oliva Virgen	14	Córdoba
	DOP	13	Montes de Granada	PDO-ES-0169	11	1.5 Aceites  de Oliva Virgen	18	Granada
	DOP	14	Montoro-Adamuz	PDO-ES-0658	11	1.5 Aceites  de Oliva Virgen	14	Córdoba
	DOP	15	Poniente de Granada	PDO-ES-0273	11	1.5 Aceites  de Oliva Virgen	18	Granada
	DOP	16	Priego de Córdoba	PDO-ES-0053	11	1.5 Aceites  de Oliva Virgen	14	Córdoba
	DOP	17	Sierra de Cádiz	PDO-ES-0219	11	1.5 Aceites  de Oliva Virgen	11	Cádiz
	DOP	17	Sierra de Cádiz	PDO-ES-0219	11	1.5 Aceites  de Oliva Virgen	41	Sevilla
	DOP	18	Sierra de Cazorla	PDO-ES-0137	11	1.5 Aceites  de Oliva Virgen	23	Jaén
	DOP	19	Sierra de Segura	PDO-ES-0071	11	1.5 Aceites  de Oliva Virgen	23	Jaén
	DOP	20	Sierra Mágina	PDO-ES-0054	11	1.5 Aceites  de Oliva Virgen	23	Jaén
	DOP	23	Chirimoya de la Costa tropical de Granada-Málaga	PDO-ES-0244	13	1.6 Frutas	18	Granada
	DOP	23	Chirimoya de la Costa tropical de Granada-Málaga	PDO-ES-0244	13	1.6 Frutas	29	Málaga
	DOP	24	Aceituna Aloreña de Málaga	PDO-ES-0785	17	1.6 Aceitunas	29	Málaga
	DOP	25	Pasas de Málaga	PDO-ES-0849	13	1.6 Frutas	29	Málaga
	DOP	27	Los Pedroches	PDO-ES-0506	4	1.2 Jamones Ibéricos	14	Córdoba
	DOP	34	Miel de Granada	PDO-ES-0243	10	1.4 Miel	18	Granada
	DOP	39	Vinagre del Condado de Huelva	PDO-ES-0724	24	1.8 Vinagres	21	Huelva
	DOP	40	Vinagre de Jerez	PDO-ES-0723	24	1.8 Vinagres	11	Cádiz
	DOP	40	Vinagre de Jerez	PDO-ES-0723	24	1.8 Vinagres	41	Sevilla
	DOP	41	Vinagre de Montilla-Moriles	PDO-ES-0726	24	1.8 Vinagres	14	Córdoba
	DOP	42	Aceite del Bajo Aragón	PDO-ES-0118	11	1.5 Aceites  de Oliva Virgen	44	Teruel
	DOP	42	Aceite del Bajo Aragón	PDO-ES-0118	11	1.5 Aceites  de Oliva Virgen	50	Zaragoza
	DOP	43	Aceite Sierra del Moncayo	PDO-ES-0797	11	1.5 Aceites  de Oliva Virgen	50	Zaragoza
	DOP	45	Melocotón de Calanda	PDO-ES-0103	13	1.6 Frutas	44	Teruel
	DOP	45	Melocotón de Calanda	PDO-ES-0103	13	1.6 Frutas	50	Zaragoza
	DOP	46	Cebolla Fuentes de Ebro	PDO-ES-0817	14	1.6 Hortalizas	50	Zaragoza
	DOP	47	Jamón de Teruel / Paleta de Teruel	PDO-ES-0078	6	1.2 Jamones y paletas no ibéricas	44	Teruel
	DOP	51	Afuega'l Pitu	PDO-ES-0307	9	1.3 Quesos	33	Asturias
	DOP	52	Cabrales	PDO-ES-0081	9	1.3 Quesos	33	Asturias
	DOP	53	Gamoneu / Gamonedo	PDO-ES-0308	9	1.3 Quesos	33	Asturias
	DOP	54	Queso Casín	PDO-ES-0718	9	1.3 Quesos	33	Asturias
	DOP	55	Sidra de Asturias / Sidra d'Asturies	PDO-ES-0260	25	1.8 Sidra	33	Asturias
	DOP	56	Aceite de Mallorca / Aceite mallorquín / Oli de Mallorca / Oli mallorquí	PDO-ES-0263	11	1.5 Aceites  de Oliva Virgen	7	Illes Balears
	DOP	58	Aceituna de Mallorca / Aceituna Mallorquina / Oliva de Mallorca / Oliva Mallorquina	PDO-ES-1051	17	1.6 Aceitunas	7	Illes Balears
	DOP	61	Mahón-Menorca	PDO-ES-9083	9	1.3 Quesos	7	Illes Balears
	IGP	2	Cordero Segureño	PGI-ES-0871	3	1.1 Ovino	2	Albacete
	IGP	2	Cordero Segureño	PGI-ES-0871	3	1.1 Ovino	4	Almería
	IGP	2	Cordero Segureño	PGI-ES-0871	3	1.1 Ovino	18	Granada
	IGP	2	Cordero Segureño	PGI-ES-0871	3	1.1 Ovino	23	Jaén
	IGP	2	Cordero Segureño	PGI-ES-0871	3	1.1 Ovino	30	Murcia
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	5	Ávila
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	6	Badajoz
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	9	Burgos
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	10	Cáceres
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	13	Ciudad Real
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	14	Córdoba
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	19	Guadalajara
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	21	Huelva
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	23	Jaén
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	24	León
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	28	Madrid
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	34	Palencia
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	26	La Rioja
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	37	Salamanca
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	40	Segovia
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	41	Sevilla
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	42	Soria
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	44	Teruel
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	45	Toledo
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	47	Valladolid
	IGP	3	Carne de Ávila	PGI-ES-0093	2	1.1 Vacuno	49	Zamora
	IGP	4	Espárrago de Navarra	PGI-ES-0098	14	1.6 Hortalizas	22	Huesca
	IGP	4	Espárrago de Navarra	PGI-ES-0098	14	1.6 Hortalizas	31	Navarra
	IGP	4	Espárrago de Navarra	PGI-ES-0098	14	1.6 Hortalizas	26	La Rioja
	IGP	4	Espárrago de Navarra	PGI-ES-0098	14	1.6 Hortalizas	50	Zaragoza
	IGP	7	Queso Los Beyos	PGI-ES-0806	9	1.3 Quesos	33	Asturias
	IGP	7	Queso Los Beyos	PGI-ES-0806	9	1.3 Quesos	24	León
	IGP	21	Tomate La Cañada	PGI-ES-0664	14	1.6 Hortalizas	4	Almería
	IGP	22	Espárrago de Huétor-Tájar	PGI-ES-0056	14	1.6 Hortalizas	18	Granada
	IGP	26	Jamón de Trevélez	PGI-ES-0309	5	1.2 Jamones no ibéricos	18	Granada
	IGP	28	Jamón de Serón	PGI-ES-1052	5	1.2 Jamones no ibéricos	4	Almería
	IGP	29	Garbanzo de Escacena	PGI-ES-0945	15	1.6 Legumbres	21	Huelva
	IGP	29	Garbanzo de Escacena	PGI-ES-0945	15	1.6 Legumbres	41	Sevilla
	IGP	30	Caballa de Andalucia	PGI-ES-0281	20	1.7 Pescados	4	Almería
	IGP	30	Caballa de Andalucia	PGI-ES-0281	20	1.7 Pescados	11	Cádiz
	IGP	30	Caballa de Andalucia	PGI-ES-0281	20	1.7 Pescados	18	Granada
	IGP	30	Caballa de Andalucia	PGI-ES-0281	20	1.7 Pescados	21	Huelva
	IGP	30	Caballa de Andalucia	PGI-ES-0281	20	1.7 Pescados	29	Málaga
	IGP	31	Melva de Andalucia	PGI-ES-0280	20	1.7 Pescados	4	Almería
	IGP	31	Melva de Andalucia	PGI-ES-0280	20	1.7 Pescados	11	Cádiz
	IGP	31	Melva de Andalucia	PGI-ES-0280	20	1.7 Pescados	18	Granada
	IGP	31	Melva de Andalucia	PGI-ES-0280	20	1.7 Pescados	21	Huelva
	IGP	31	Melva de Andalucia	PGI-ES-0280	20	1.7 Pescados	29	Málaga
	IGP	32	Mojama de Barbate	PGI-ES-01210	20	1.7 Pescados	11	Cádiz
	IGP	33	Mojama de Isla Cristina	PGI-ES-01211	20	1.7 Pescados	21	Huelva
	IGP	35	Alfajor de Medina Sidonia	PGI-ES-0346	28	2.3 Productos de pastelería y repostería	11	Cádiz
	IGP	36	Mantecados de Estepa	PGI-ES-0761	28	2.3 Productos de pastelería y repostería	41	Sevilla
	IGP	37	Pan de Alfacar	PGI-ES-0890	27	2.3 Panes	18	Granada
	IGP	38	Polvorones de Estepa	PGI-ES-01218	28	2.3 Productos de pastelería y repostería	41	Sevilla
	IGP	44	Ternasco de Aragón	PGI-ES-0096	3	1.1 Ovino	22	Huesca
	IGP	44	Ternasco de Aragón	PGI-ES-0096	3	1.1 Ovino	44	Teruel
	IGP	44	Ternasco de Aragón	PGI-ES-0096	3	1.1 Ovino	50	Zaragoza
	IGP	48	Ternera Asturiana	PGI-ES-0182	2	1.1 Vacuno	33	Asturias
	IGP	49	Chosco de Tineo	PGI-ES-0696	7	1.2 Embutidos	33	Asturias
	IGP	50	Faba Asturiana	PGI-ES-0100	15	1.6 Legumbres	33	Asturias
	IGP	57	Sobrasada de Mallorca	PGI-ES-0097	7	1.2 Embutidos	7	Illes Balears
	IGP	59	Almendra de Mallorca / Almendra Mallorquina / Ametlla de Mallorca / Ametlla Mallorquina	PGI-ES-1037	19	1.6 Otros vegetales (frutos secos)	7	Illes Balears
	IGP	60	Ensaimada de Mallorca / Ensaimada mallorquina	PGI-ES-0277	28	2.3 Productos de pastelería y repostería	7	Illes Balears
	IGP	62	Carne de Salamanca	PGI-ES-01174	2	1.1 Vacuno	37	Salamanca
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	5	Ávila
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	9	Burgos
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	24	León
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	34	Palencia
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	37	Salamanca
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	40	Segovia
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	42	Soria
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	47	Valladolid
	IGP	63	Lechazo de Castilla y León	PGI-ES-0069	3	1.1 Ovino	49	Zamora
	IGP	64	Ternera de Aliste	PGI-ES-01134	2	1.1 Vacuno	49	Zamora
	IGP	65	Botillo del Bierzo	PGI-ES-0138	7	1.2 Embutidos	24	León
	IGP	66	Chorizo de Cantimpalos	PGI-ES-0632	7	1.2 Embutidos	40	Segovia
	IGP	67	Morcilla de Burgos	PGI-ES-01282	7	1.2 Embutidos	9	Burgos
	IGP	69	Pimiento Asado del Bierzo	PGI-ES-0262	14	1.6 Hortalizas	24	León
	IGP	70	Pimiento de Fresno-Benavente	PGI-ES-0705	14	1.6 Hortalizas	24	León
	IGP	70	Pimiento de Fresno-Benavente	PGI-ES-0705	14	1.6 Hortalizas	47	Valladolid
	IGP	70	Pimiento de Fresno-Benavente	PGI-ES-0705	14	1.6 Hortalizas	49	Zamora
	IGP	71	Alubia de La Bañeza-León	PGI-ES-0492	15	1.6 Legumbres	24	León
	IGP	71	Alubia de La Bañeza-León	PGI-ES-0492	15	1.6 Legumbres	49	Zamora
	IGP	72	Garbanzo de Fuentesaúco	PGI-ES-0264	15	1.6 Legumbres	49	Zamora
	IGP	73	Judías de El Barco de Ávila	PGI-ES-0101	15	1.6 Legumbres	5	Ávila
	IGP	73	Judías de El Barco de Ávila	PGI-ES-0101	15	1.6 Legumbres	37	Salamanca
	IGP	74	Lenteja de La Armuña	PGI-ES-0102	15	1.6 Legumbres	37	Salamanca
	IGP	75	Lenteja de Tierra de Campos	PGI-ES-0313	15	1.6 Legumbres	24	León
	IGP	75	Lenteja de Tierra de Campos	PGI-ES-0313	15	1.6 Legumbres	34	Palencia
	IGP	75	Lenteja de Tierra de Campos	PGI-ES-0313	15	1.6 Legumbres	47	Valladolid
	IGP	75	Lenteja de Tierra de Campos	PGI-ES-0313	15	1.6 Legumbres	49	Zamora
	IGP	77	Cecina de León	PGI-ES-0103	8	1.2 Otros productos cárnicos	24	León
	IGP	78	Mantecadas de Astorga	PGI-ES-0311	28	2.3 Productos de pastelería y repostería	24	León
	IGP	80	Queso de Valdeón	PGI-ES-0267	9	1.3 Quesos	24	León
	IGP	81	Gofio Canario	PGI-ES-0942	18	1.6 Cereales frescos o transformados	35	Las Palmas
	IGP	81	Gofio Canario	PGI-ES-0942	18	1.6 Cereales frescos o transformados	38	Santa Cruz de Tenerife
	IGP	83	Plátano de Canarias	PGI-ES-0867	13	1.6 Frutas	35	Las Palmas
	IGP	83	Plátano de Canarias	PGI-ES-0867	13	1.6 Frutas	38	Santa Cruz de Tenerife
	IGP	89	Carne de Cantabria	PGI-ES-0185	2	1.1 Vacuno	39	Cantabria
	IGP	91	Sobao Pasiego	PGI-ES-0478	28	2.3 Productos de pastelería y repostería	39	Cantabria
	IGP	101	Gall del Penedès	PGI-ES-01308	1	1.1 Aves de corral	8	Barcelona
	IGP	101	Gall del Penedès	PGI-ES-01308	1	1.1 Aves de corral	43	Tarragona
	IGP	102	Pollo y Capón del Prat	PGI-ES-0095	1	1.1 Aves de corral	8	Barcelona
	IGP	103	Ternera de los Pirineos Catalanes / Vedella dels Pirineus Catalans / Vedell des Pyrénées Catalanes	PGI-ES+FR-1042	2	1.1 Vacuno	8	Barcelona
	IGP	103	Ternera de los Pirineos Catalanes / Vedella dels Pirineus Catalans / Vedell des Pyrénées Catalanes	PGI-ES+FR-1042	2	1.1 Vacuno	17	Girona
	IGP	103	Ternera de los Pirineos Catalanes / Vedella dels Pirineus Catalans / Vedell des Pyrénées Catalanes	PGI-ES+FR-1042	2	1.1 Vacuno	25	Lleida
	IGP	104	Salchichón de Vic / Llonganissa de Vic	PGI-ES-0119	7	1.2 Embutidos	8	Barcelona
	IGP	105	Calçot de Valls	PGI-ES-0171	14	1.6 Hortalizas	43	Tarragona
	IGP	106	Patatas de Prades / Patates de Prades	PGI-ES-0232	14	1.6 Hortalizas	43	Tarragona
	IGP	109	Clementinas de las Tierras del Ebro / Clementines de les Terres de l'Ebre	PGI-ES-0173	13	1.6 Frutas	43	Tarragona
	IGP	110	Manzana de Girona / Poma de Girona	PGI-ES-0154	13	1.6 Frutas	17	Girona
	IGP	114	Pa de Pagès Català	PGI-ES-0880	27	2.3 Panes	8	Barcelona
	IGP	114	Pa de Pagès Català	PGI-ES-0880	27	2.3 Panes	17	Girona
	IGP	114	Pa de Pagès Català	PGI-ES-0880	27	2.3 Panes	25	Lleida
	IGP	114	Pa de Pagès Català	PGI-ES-0880	27	2.3 Panes	43	Tarragona
	IGP	115	Turrón de Agramunt / Torró d'Agramunt	PGI-ES-0167	26	2.3  Turrones	25	Lleida
	IGP	119	Cordero de Extremadura	PGI-ES-0725	3	1.1 Ovino	6	Badajoz
	IGP	119	Cordero de Extremadura	PGI-ES-0725	3	1.1 Ovino	10	Cáceres
	IGP	120	Ternera de Extremadura	PGI-ES-0220	2	1.1 Vacuno	6	Badajoz
	IGP	120	Ternera de Extremadura	PGI-ES-0220	2	1.1 Vacuno	10	Cáceres
	IGP	128	Capón de Vilalba	PGI-ES-01355	1	1.1 Aves de corral	27	Lugo
	IGP	129	Ternera Gallega	PGI-ES-0012	2	1.1 Vacuno	15	A Coruña
	IGP	129	Ternera Gallega	PGI-ES-0012	2	1.1 Vacuno	27	Lugo
	IGP	129	Ternera Gallega	PGI-ES-0012	2	1.1 Vacuno	32	Ourense
	IGP	129	Ternera Gallega	PGI-ES-0012	2	1.1 Vacuno	36	Pontevedra
	IGP	130	Grelos de Galicia	PGI-ES-0469	14	1.6 Hortalizas	15	A Coruña
	IGP	130	Grelos de Galicia	PGI-ES-0469	14	1.6 Hortalizas	27	Lugo
	IGP	130	Grelos de Galicia	PGI-ES-0469	14	1.6 Hortalizas	32	Ourense
	IGP	130	Grelos de Galicia	PGI-ES-0469	14	1.6 Hortalizas	36	Pontevedra
	IGP	131	Patata de Galicia / Pataca de Galicia	PGI-ES-0205	14	1.6 Hortalizas	15	A Coruña
	IGP	131	Patata de Galicia / Pataca de Galicia	PGI-ES-0205	14	1.6 Hortalizas	27	Lugo
	IGP	131	Patata de Galicia / Pataca de Galicia	PGI-ES-0205	14	1.6 Hortalizas	32	Ourense
	IGP	131	Patata de Galicia / Pataca de Galicia	PGI-ES-0205	14	1.6 Hortalizas	36	Pontevedra
	IGP	132	Pemento do Couto	PGI-ES-0464	14	1.6 Hortalizas	15	A Coruña
	IGP	133	Pemento de Oímbra	PGI-ES-0486	14	1.6 Hortalizas	32	Ourense
	IGP	135	Pemento da Arnoia	PGI-ES-0510	14	1.6 Hortalizas	32	Ourense
	IGP	136	Pemento de Mougán	PGI-ES-1133	14	1.6 Hortalizas	27	Lugo
	IGP	137	Castaña de Galicia	PGI-ES-0609	19	1.6 Otros vegetales (frutos secos)	15	A Coruña
	IGP	137	Castaña de Galicia	PGI-ES-0609	19	1.6 Otros vegetales (frutos secos)	27	Lugo
	IGP	137	Castaña de Galicia	PGI-ES-0609	19	1.6 Otros vegetales (frutos secos)	32	Ourense
	IGP	137	Castaña de Galicia	PGI-ES-0609	19	1.6 Otros vegetales (frutos secos)	36	Pontevedra
	IGP	138	Faba de Lourenzá	PGI-ES-0480	15	1.6 Legumbres	27	Lugo
	IGP	140	Miel de Galicia / Mel de Galicia	PGI-ES-0278	10	1.4 Miel	15	A Coruña
	IGP	140	Miel de Galicia / Mel de Galicia	PGI-ES-0278	10	1.4 Miel	27	Lugo
	IGP	140	Miel de Galicia / Mel de Galicia	PGI-ES-0278	10	1.4 Miel	32	Ourense
	IGP	140	Miel de Galicia / Mel de Galicia	PGI-ES-0278	10	1.4 Miel	36	Pontevedra
	IGP	141	Lacón Gallego	PGI-ES-0104	8	1.2 Otros productos cárnicos	15	A Coruña
	IGP	141	Lacón Gallego	PGI-ES-0104	8	1.2 Otros productos cárnicos	27	Lugo
	IGP	141	Lacón Gallego	PGI-ES-0104	8	1.2 Otros productos cárnicos	32	Ourense
	IGP	141	Lacón Gallego	PGI-ES-0104	8	1.2 Otros productos cárnicos	36	Pontevedra
	IGP	142	Pan de Cea	PGI-ES-0310	27	2.3 Panes	32	Ourense
	IGP	143	Tarta de Santiago	PGI-ES-0616	28	2.3 Productos de pastelería y repostería	15	A Coruña
	IGP	143	Tarta de Santiago	PGI-ES-0616	28	2.3 Productos de pastelería y repostería	27	Lugo
	IGP	143	Tarta de Santiago	PGI-ES-0616	28	2.3 Productos de pastelería y repostería	32	Ourense
	IGP	143	Tarta de Santiago	PGI-ES-0616	28	2.3 Productos de pastelería y repostería	36	Pontevedra
	IGP	149	Chorizo Riojano	PGI-ES-0654	7	1.2 Embutidos	26	La Rioja
	IGP	150	Coliflor de Calahorra	PGI-ES-0268	14	1.6 Hortalizas	26	La Rioja
	IGP	151	Pimiento Riojano	PGI-ES-0275	14	1.6 Hortalizas	26	La Rioja
	IGP	154	Carne de la Sierra de Guadarrama	PGI-ES-0124	2	1.1 Vacuno	28	Madrid
	IGP	159	Cordero Manchego	PGI-ES-0047	3	1.1 Ovino	2	Albacete
	IGP	159	Cordero Manchego	PGI-ES-0047	3	1.1 Ovino	13	Ciudad Real
	IGP	159	Cordero Manchego	PGI-ES-0047	3	1.1 Ovino	16	Cuenca
	IGP	159	Cordero Manchego	PGI-ES-0047	3	1.1 Ovino	45	Toledo
	IGP	161	Berenjena de Almagro	PGI-ES-0011	14	1.6 Hortalizas	13	Ciudad Real
	IGP	162	Ajo Morado de Las Pedroñeras	PGI-ES-0228	14	1.6 Hortalizas	2	Albacete
	IGP	162	Ajo Morado de Las Pedroñeras	PGI-ES-0228	14	1.6 Hortalizas	13	Ciudad Real
	IGP	162	Ajo Morado de Las Pedroñeras	PGI-ES-0228	14	1.6 Hortalizas	16	Cuenca
	IGP	162	Ajo Morado de Las Pedroñeras	PGI-ES-0228	14	1.6 Hortalizas	45	Toledo
	IGP	163	Melón de La Mancha	PGI-ES-0511	13	1.6 Frutas	13	Ciudad Real
	IGP	165	Mazapán de Toledo	PGI-ES-0291	28	2.3 Productos de pastelería y repostería	45	Toledo
	IGP	166	Pan de Cruz de Ciudad Real	PGI-ES-0608	27	2.3 Panes	13	Ciudad Real
	IGP	208	Cebolla de la Mancha	PGI-ES-02631	14	1.6 Hortalizas	45	Toledo
	IGP	208	Cebolla de la Mancha	PGI-ES-02631	14	1.6 Hortalizas	19	Guadalajara
	IGP	208	Cebolla de la Mancha	PGI-ES-02631	14	1.6 Hortalizas	16	Cuenca
	IGP	208	Cebolla de la Mancha	PGI-ES-02631	14	1.6 Hortalizas	13	Ciudad Real
	IGP	208	Cebolla de la Mancha	PGI-ES-02631	14	1.6 Hortalizas	2	Albacete
	IGP	394	Terras do Navia	PGI-ES-02787	45	VT: “Vino de la Tierra”	27	Lugo
	IGP	216	Melocotón de Cieza	PGI-ES-02644	13	1.6 Frutas	30	Murcia
	IGP	210	Cerdo de Teruel	PGI-ES-2633	31	1.1 Porcino	44	Teruel
	IGP	209	Vaca de Extremadura	PGI-ES-02619	2	1.1 Vacuno	6	Badajoz
	IGP	209	Vaca de Extremadura	PGI-ES-02619	2	1.1 Vacuno	10	Cáceres
	IGP	388	Formatge Garrotxa / Queso Garrotxa	PGI-ES-02876	9	1.3 Quesos	8	Barcelona
	IGP	388	Formatge Garrotxa / Queso Garrotxa	PGI-ES-02876	9	1.3 Quesos	17	Girona
	IGP	388	Formatge Garrotxa / Queso Garrotxa	PGI-ES-02876	9	1.3 Quesos	25	Lleida
	IGP	388	Formatge Garrotxa / Queso Garrotxa	PGI-ES-02876	9	1.3 Quesos	43	Tarragona
	IGP	384	Cabrito de Extremadura	PGI-ES-02796	3	1.1 Ovino	6	Badajoz
	IGP	384	Cabrito de Extremadura	PGI-ES-02796	3	1.1 Ovino	10	Cáceres
	IGP	199	Vaca e Boi de Galicia / Vaca y Buey de Galicia	PGI-ES-2308	2	1.1 Vacuno	36	Pontevedra
	IGP	174	Cordero de Navarra / Nafarroako Arkumea	PGI-ES-0212	3	1.1 Ovino	31	Navarra
	IGP	175	Ternera de Navarra / Nafarroako Aratxea	PGI-ES-0130	2	1.1 Vacuno	31	Navarra
	IGP	177	Alcachofa de Tudela	PGI-ES-0139	14	1.6 Hortalizas	31	Navarra
	IGP	179	Carne de Vacuno del País Vasco / Euskal Okela	PGI-ES-0175	2	1.1 Vacuno	1	Álava
	IGP	179	Carne de Vacuno del País Vasco / Euskal Okela	PGI-ES-0175	2	1.1 Vacuno	48	Vizcaya
	IGP	179	Carne de Vacuno del País Vasco / Euskal Okela	PGI-ES-0175	2	1.1 Vacuno	20	Guipúzcoa
	IGP	180	Pimiento de Gernika or Gernikako Piperra	PGI-ES-0673	14	1.6 Hortalizas	1	Álava
	IGP	180	Pimiento de Gernika or Gernikako Piperra	PGI-ES-0673	14	1.6 Hortalizas	48	Vizcaya
	IGP	180	Pimiento de Gernika or Gernikako Piperra	PGI-ES-0673	14	1.6 Hortalizas	20	Guipúzcoa
	IGP	189	Cerezas de la Montaña de Alicante	PGI-ES-0099	13	1.6 Frutas	3	Alicante
	IGP	189	Cerezas de la Montaña de Alicante	PGI-ES-0099	13	1.6 Frutas	46	Valencia
	IGP	190	Cítricos Valencianos / Cítrics Valencians	PGI-ES-0152	13	1.6 Frutas	3	Alicante
	IGP	190	Cítricos Valencianos / Cítrics Valencians	PGI-ES-0152	13	1.6 Frutas	12	Castellon
	IGP	190	Cítricos Valencianos / Cítrics Valencians	PGI-ES-0152	13	1.6 Frutas	46	Valencia
	IGP	191	Jijona	PGI-ES-1563	26	2.3  Turrones	3	Alicante
	IGP	192	Turrón de Alicante	PGI-ES-1564	26	2.3  Turrones	3	Alicante
	IGP	201	Aceite de Ibiza / Oli d'Eivissa	PGI-ES-02459	11	1.5 Aceites  de Oliva Virgen	7	Illes Balears
	IGP	202	Aceite de Jaén	PGI-ES-2322	11	1.5 Aceites  de Oliva Virgen	23	Jaén
	IGP	204	Mollete de Antequera	PGI-ES-02393	27	2.3 Panes	29	Málaga
	IGP	205	Pan Galego / Pan Gallego	PGI-ES-02321	27	2.3 Panes	15	A Coruña
	IGP	205	Pan Galego / Pan Gallego	PGI-ES-02321	27	2.3 Panes	27	Lugo
	IGP	205	Pan Galego / Pan Gallego	PGI-ES-02321	27	2.3 Panes	32	Ourense
	IGP	205	Pan Galego / Pan Gallego	PGI-ES-02321	27	2.3 Panes	36	Pontevedra
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	5	Ávila
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	9	Burgos
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	24	León
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	34	Palencia
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	37	Salamanca
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	40	Segovia
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	42	Soria
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	47	Valladolid
	IGP	207	Queso Castellano	PGI-ES-02307	9	1.3 Quesos	49	Zamora
	IGP	237	3 Riberas	PGI-ES-A0128	45	VT: “Vino de la Tierra”	31	Navarra
	IGP	242	Altiplano de Sierra Nevada	PGI-ES-A1402	45	VT: “Vino de la Tierra”	18	Granada
	IGP	246	Bailén	PGI-ES-A1404	45	VT: “Vino de la Tierra”	23	Jaén
	IGP	247	Bajo Aragón	PGI-ES-A1362	45	VT: “Vino de la Tierra”	44	Teruel
	IGP	247	Bajo Aragón	PGI-ES-A1362	45	VT: “Vino de la Tierra”	50	Zaragoza
	IGP	248	Barbanza e Iria	PGI-ES-A1255	45	VT: “Vino de la Tierra”	15	A Coruña
	IGP	248	Barbanza e Iria	PGI-ES-A1255	45	VT: “Vino de la Tierra”	36	Pontevedra
	IGP	249	Betanzos	PGI-ES-A1257	45	VT: “Vino de la Tierra”	15	A Coruña
	IGP	253	Cádiz	PGI-ES-A1405	45	VT: “Vino de la Tierra”	11	Cádiz
	IGP	262	Castelló	PGI-ES-A1173	45	VT: “Vino de la Tierra”	12	Castellon
	IGP	263	Castilla	PGI-ES-A0059	45	VT: “Vino de la Tierra”	2	Albacete
	IGP	263	Castilla	PGI-ES-A0059	45	VT: “Vino de la Tierra”	13	Ciudad Real
	IGP	263	Castilla	PGI-ES-A0059	45	VT: “Vino de la Tierra”	16	Cuenca
	IGP	263	Castilla	PGI-ES-A0059	45	VT: “Vino de la Tierra”	19	Guadalajara
	IGP	263	Castilla	PGI-ES-A0059	45	VT: “Vino de la Tierra”	45	Toledo
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	5	Ávila
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	9	Burgos
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	24	León
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	34	Palencia
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	37	Salamanca
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	40	Segovia
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	42	Soria
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	47	Valladolid
	IGP	264	Castilla y León	PGI-ES-A0948	45	VT: “Vino de la Tierra”	49	Zamora
	IGP	275	Córdoba	PGI-ES-A1406	45	VT: “Vino de la Tierra”	14	Córdoba
	IGP	276	Costa de Cantabria	PGI-ES-A0129	45	VT: “Vino de la Tierra”	39	Cantabria
	IGP	278	Cumbres del Guadalfeo	PGI-ES-A1407	45	VT: “Vino de la Tierra”	18	Granada
	IGP	280	Desierto de Almería	PGI-ES-A1408	45	VT: “Vino de la Tierra”	4	Almería
	IGP	286	Extremadura	PGI-ES-A1300	45	VT: “Vino de la Tierra”	6	Badajoz
	IGP	286	Extremadura	PGI-ES-A1300	45	VT: “Vino de la Tierra”	10	Cáceres
	IGP	288	Formentera	PGI-ES-A0875	45	VT: “Vino de la Tierra”	7	Illes Balears
	IGP	292	Ibiza / Eivissa	PGI-ES-A0110	45	VT: “Vino de la Tierra”	7	Illes Balears
	IGP	293	Illes Balears	PGI-ES-A0947	45	VT: “Vino de la Tierra”	7	Illes Balears
	IGP	294	Isla de Menorca / Illa de Menorca	PGI-ES-A0870	45	VT: “Vino de la Tierra”	7	Illes Balears
	IGP	302	Laderas del Genil	PGI-ES-A1409	45	VT: “Vino de la Tierra”	18	Granada
	IGP	304	Laujar-Alpujarra	PGI-ES-A1410	45	VT: “Vino de la Tierra”	4	Almería
	IGP	307	Liébana	PGI-ES-A0130	45	VT: “Vino de la Tierra”	39	Cantabria
	IGP	310	Los Palacios	PGI-ES-A1411	45	VT: “Vino de la Tierra”	41	Sevilla
	IGP	312	Mallorca	PGI-ES-A0960	45	VT: “Vino de la Tierra”	7	Illes Balears
	IGP	320	Murcia	PGI-ES-A0608	45	VT: “Vino de la Tierra”	30	Murcia
	IGP	322	Norte de Almería	PGI-ES-A1412	45	VT: “Vino de la Tierra”	4	Almería
	IGP	333	Ribeiras do Morrazo	PGI-ES-02238	45	VT: “Vino de la Tierra”	36	Pontevedra
	IGP	335	Ribera del Andarax	PGI-ES-A1414	45	VT: “Vino de la Tierra”	4	Almería
	IGP	337	Ribera del Gállego - Cinco Villas	PGI-ES-A0245	45	VT: “Vino de la Tierra”	22	Huesca
	IGP	337	Ribera del Gállego - Cinco Villas	PGI-ES-A0245	45	VT: “Vino de la Tierra”	50	Zaragoza
	IGP	339	Ribera del Jiloca	PGI-ES-A0244	45	VT: “Vino de la Tierra”	44	Teruel
	IGP	339	Ribera del Jiloca	PGI-ES-A0244	45	VT: “Vino de la Tierra”	50	Zaragoza
	IGP	341	Ribera del Queiles	PGI-ES-A0083	45	VT: “Vino de la Tierra”	31	Navarra
	IGP	341	Ribera del Queiles	PGI-ES-A0083	45	VT: “Vino de la Tierra”	50	Zaragoza
	IGP	344	Serra de Tramuntana-Costa Nord	PGI-ES-A0103	45	VT: “Vino de la Tierra”	7	Illes Balears
	IGP	346	Sierra Norte de Sevilla	PGI-ES-A1415	45	VT: “Vino de la Tierra”	41	Sevilla
	IGP	347	Sierra Sur de Jaén	PGI-ES-A1416	45	VT: “Vino de la Tierra”	23	Jaén
	IGP	348	Sierras de Las Estancias y Los Filabres	PGI-ES-A1417	45	VT: “Vino de la Tierra”	4	Almería
	IGP	356	Torreperogil	PGI-ES-A1418	45	VT: “Vino de la Tierra”	23	Jaén
	IGP	359	Valdejalón	PGI-ES-A0246	45	VT: “Vino de la Tierra”	50	Zaragoza
	IGP	365	Valle del Cinca	PGI-ES-A0181	45	VT: “Vino de la Tierra”	22	Huesca
	IGP	366	Valle del Miño-Ourense / Val do Miño-Ourense	PGI-ES-A1259	45	VT: “Vino de la Tierra”	32	Ourense
	IGP	369	Valles de Sadacia	PGI-ES-A0511	45	VT: “Vino de la Tierra”	26	La Rioja
	IGP	372	Villaviciosa de Córdoba	PGI-ES-A1419	45	VT: “Vino de la Tierra”	14	Córdoba
	IGP	199	Vaca e Boi de Galicia / Vaca y Buey de Galicia	PGI-ES-2308	2	1.1 Vacuno	15	A Coruña
	IGP	199	Vaca e Boi de Galicia / Vaca y Buey de Galicia	PGI-ES-2308	2	1.1 Vacuno	27	Lugo
	IGP	199	Vaca e Boi de Galicia / Vaca y Buey de Galicia	PGI-ES-2308	2	1.1 Vacuno	32	Ourense
	IG	217	Ronmiel de Canarias	PGI-ES-01943	39	47. Otras bebidas espirituosas	35	Las Palmas
	IG	236	Vino Naranja del Condado de Huelva	PGI-ES-02343	40	Vinos aromatizados	21	Huelva
	IG	218	Hierbas Ibicencas	PGI-ES-01973	36	25. Bebidas espirituosas anisadas	7	Illes Balears
	IG	219	Aguardiente de hierbas de Galicia	PGI-ES-01913	39	47. Otras bebidas espirituosas	15	A Coruña
	IG	219	Aguardiente de hierbas de Galicia	PGI-ES-01913	39	47. Otras bebidas espirituosas	27	Lugo
	IG	219	Aguardiente de hierbas de Galicia	PGI-ES-01913	39	47. Otras bebidas espirituosas	32	Ourense
	IG	219	Aguardiente de hierbas de Galicia	PGI-ES-01913	39	47. Otras bebidas espirituosas	36	Pontevedra
	IG	220	Herbero de la Sierra de Mariola	PGI-ES-01894	39	47. Otras bebidas espirituosas	3	Alicante
	IG	221	Anís Paloma Monforte del Cid	PGI-ES-01893	36	25. Bebidas espirituosas anisadas	3	Alicante
	IG	222	Aperitivo Café de Alcoy	PGI-ES-01891	39	47. Otras bebidas espirituosas	3	Alicante
	IG	223	Cantueso Alicantino	PGI-ES-01892	37	32. Licor	3	Alicante
	IG	224	Hierbas de Mallorca	PGI-ES-01869	36	25. Bebidas espirituosas anisadas	7	Illes Balears
	IG	225	Licor café de Galicia	PGI-ES-01911	37	32. Licor	15	A Coruña
	IG	225	Licor café de Galicia	PGI-ES-01911	37	32. Licor	27	Lugo
	IG	225	Licor café de Galicia	PGI-ES-01911	37	32. Licor	32	Ourense
	IG	225	Licor café de Galicia	PGI-ES-01911	37	32. Licor	36	Pontevedra
	IG	226	Licor de hierbas de Galicia	PGI-ES-01912	37	32. Licor	15	A Coruña
	IG	226	Licor de hierbas de Galicia	PGI-ES-01912	37	32. Licor	27	Lugo
	IG	226	Licor de hierbas de Galicia	PGI-ES-01912	37	32. Licor	32	Ourense
	IG	226	Licor de hierbas de Galicia	PGI-ES-01912	37	32. Licor	36	Pontevedra
	IG	227	Palo de Mallorca	PGI-ES-01868	37	32. Licor	7	Illes Balears
	IG	228	Orujo de Galicia	PGI-ES-01914	33	6. Aguardiente de orujo u orujo	15	A Coruña
	IG	228	Orujo de Galicia	PGI-ES-01914	33	6. Aguardiente de orujo u orujo	27	Lugo
	IG	228	Orujo de Galicia	PGI-ES-01914	33	6. Aguardiente de orujo u orujo	32	Ourense
	IG	228	Orujo de Galicia	PGI-ES-01914	33	6. Aguardiente de orujo u orujo	36	Pontevedra
	IG	229	Ratafia catalana	PGI-ES-01945	37	32. Licor	8	Barcelona
	IG	229	Ratafia catalana	PGI-ES-01945	37	32. Licor	17	Girona
	IG	229	Ratafia catalana	PGI-ES-01945	37	32. Licor	25	Lleida
	IG	229	Ratafia catalana	PGI-ES-01945	37	32. Licor	43	Tarragona
	IG	230	Brandy de Jerez	PGI-ES-01944	32	5. Brandy o Weinbrand	11	Cádiz
	IG	231	Aguardiente de sidra de Asturias	PGI-ES-02058	34	10. Aguardiente de sidra y aguardiente de perada	33	Asturias
	IG	232	Brandy del Penedés	PGI-ES-01946	32	5. Brandy o Weinbrand	8	Barcelona
	IG	232	Brandy del Penedés	PGI-ES-01946	32	5. Brandy o Weinbrand	43	Tarragona
	IG	233	Gin de Mahón	PGI-ES-01953	35	19. Bebidas espirituosas aromatizadas con enebro	7	Illes Balears
	IG	234	Pacharán navarro	PGI-ES-01878	38	37bis. Bebida espirituosa aromatizada a base de endrinas o pacharán	31	Navarra
	IG	235	Chinchón	PGI-ES-02017	36	25. Bebidas espirituosas anisadas	28	Madrid
	IG	217	Ronmiel de Canarias	PGI-ES-01943	39	47. Otras bebidas espirituosas	38	Santa Cruz de Tenerife


	
	 */
}