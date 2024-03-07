package es.agrobook.api.model.location;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pais {
	
	@Id
	private int id;

	@Column(nullable = false, length = 4)
	private String codigo;

	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne(optional = false)
	private AgrupacionPaises agrupacionPaises;


	// Entidades enlazadas

	@OneToMany(mappedBy = "pais")
	private Set<ComunidadAutonoma> comunidadesAutonomas;
	

	/*
	Continente		Agregaciones de países		Países	
01	Europa	11	Unión Europea 	102	Austria
				103	Bélgica
				104	Bulgaria
				106	Chipre
				107	Dinamarca
				108	España
				109	Finlandia
				110	Francia
				111	Grecia
				112	Hungría
				113	Irlanda
				115	Italia
				117	Luxemburgo
				118	Malta
				121	Países Bajos
				122	Polonia
				123	Portugal
				126	Alemania
				128	Rumanía
				131	Suecia
				136	Letonia
				141	Estonia
				142	Lituania
				143	República Checa
				144	República Eslovaca
				146	Croacia
				147	Eslovenia
		12	Resto de Europa	101	Albania
				114	Islandia
				116	Liechtenstein
				119	Mónaco
				120	Noruega
				124	Andorra
				125	Reino Unido
				129	San Marino
				130	Santa Sede
				132	Suiza
				135	Ucrania
				137	Moldavia
				138	Belarús
				139	Georgia
				145	Bosnia y Herzegovina
				148	Armenia
				154	Rusia
				156	Macedonia del Norte
				157	Serbia
				158	Montenegro
				436	Turquía
				199	Otros países de Europa
02	África	02	África	201	Burkina Faso
				202	Angola
				203	Argelia
				204	Benin
				205	Botswana
				206	Burundi
				207	Cabo Verde
				208	Camerún
				209	Comores
				210	Congo
				211	Costa de Marfil
				212	Djibouti
				213	Egipto
				214	Etiopía
				215	Gabón
				216	Gambia
				217	Ghana
				218	Guinea
				219	Guinea-Bissau
				220	Guinea Ecuatorial
				221	Kenia
				222	Lesotho
				223	Liberia
				224	Libia
				225	Madagascar
				226	Malawi
				227	Mali
				228	Marruecos
				229	Mauricio
				230	Mauritania
				231	Mozambique
				232	Namibia
				233	Níger
				234	Nigeria
				235	República Centroafricana
				236	Sudáfrica
				237	Ruanda
				238	Santo Tomé y Príncipe
				239	Senegal
				240	Seychelles
				241	Sierra Leona
				242	Somalia
				243	Sudán
				244	Swazilandia
				245	Tanzania
				246	Chad
				247	Togo
				248	Túnez
				249	Uganda
				250	República Democrática del Congo
				251	Zambia
				252	Zimbabwe
				253	Eritrea
				254	Sudán del Sur
				299	Otros países de África
03	América	31	América del Norte	301	Canadá
				302	Estados Unidos de América
				303	México
		32	Centro América y Caribe	310	Antigua y Barbuda
				311	Bahamas
				312	Barbados
				313	Belice
				314	Costa Rica
				315	Cuba
				316	Dominica
				317	El Salvador
				318	Granada
				319	Guatemala
				320	Haití
				321	Honduras
				322	Jamaica
				323	Nicaragua
				324	Panamá
				325	San Vicente y las Granadinas
				326	República Dominicana
				327	Trinidad y Tobago
				328	Santa Lucía
				329	San Cristóbal y Nieves
		33	Sudamérica	340	Argentina
				341	Bolivia
				342	Brasil
				343	Colombia
				344	Chile
				345	Ecuador
				346	Guyana
				347	Paraguay
				348	Perú
				349	Surinam
				350	Uruguay
				351	Venezuela
				399	Otros países de América
04	Asia	04	Asia	401	Afganistán
				402	Arabia Saudí
				403	Bahréin
				404	Bangladesh
				405	Myanmar
				407	China
				408	Emiratos Árabes Unidos
				409	Filipinas
				410	India
				411	Indonesia
				412	Iraq
				413	Irán
				414	Israel
				415	Japón
				416	Jordania
				417	Camboya
				418	Kuwait
				419	Laos
				420	Líbano
				421	Malasia
				422	Maldivas
				423	Mongolia
				424	Nepal
				425	Omán
				426	Pakistán
				427	Qatar
				430	Corea
				431	Corea del Norte
				432	Singapur
				433	Siria
				434	Sri Lanka
				435	Tailandia
				437	Vietnam
				439	Brunei
				440	Islas Marshall
				441	Yemen
				442	Azerbaiyán
				443	Kazajstán
				444	Kirguistán
				445	Tayikistán
				446	Turkmenistán
				447	Uzbekistán
				448	Bhután
				449	Palestina. Estado Observador, no miembro de Naciones Unidas
				499	Otros países de Asia
05	Oceanía	05	Oceanía	501	Australia
				502	Fiji
				504	Nueva Zelanda
				505	Papúa Nueva Guinea
				506	Islas Salomón
				507	Samoa
				508	Tonga
				509	Vanuatu
				511	Micronesia
				512	Tuvalu
				513	Islas Cook
				514	Kiribati
				515	Nauru
				516	Palaos
				517	Timor Oriental
				599	Otros países de Oceanía











	Código	Descripción
	AD	ANDORRA
	AE	EMIRATOS ARABES UNIDOS
	AF	AFGANISTAN
	AG	ANTIGUA Y BARBUDA
	AI	ANGUILA
	AL	ALBANIA
	AM	ARMENIA
	AO	ANGOLA
	AQ	ANTARTIDA
	AR	ARGENTINA
	AS	SAMOA AMERICANA
	AT	AUSTRIA
	AU	AUSTRALIA
	AW	ARUBA
	AX	ALAND
	AZ	AZERBAIYAN
	BA	BOSNIA Y HERCEGOVINA
	BB	BARBADOS
	BD	BANGLADESH
	BE	BELGICA
	BF	BURKINA FASO
	BG	BULGARIA
	BH	BAHRAIN
	BI	BURUNDI
	BJ	BENIN
	BL	SAN BARTOLOME
	BM	BERMUDAS
	BN	BRUNEI DARUSSALAM
	BO	BOLIVIA
	BQ	BONAIRE, SAN EUSTAQUIO Y SABA
	BR	BRASIL
	BS	BAHAMAS
	BT	BUTAN
	BV	BOUVET (ISLA)
	BW	BOTSUANA
	BY	BELARUS (BIELORUSIA)
	BZ	BELICE
	CA	CANADA
	CC	COCOS (ISLA) (O ISLAS KEELING)
	CD	CONGO (REPUBLICA DEMOCRATICA DEL)
	CF	REPUBLICA CENTROAFRICANA
	CG	CONGO
	CH	SUIZA
	CI	COSTA DE MARFIL
	CK	COOK (ISLAS)
	CL	CHILE
	CM	CAMERUN
	CN	CHINA (REPUBLICA POPULAR DE)
	CO	COLOMBIA
	CR	COSTA RICA
	CS	SERBIA Y MONTENEGRO
	CU	CUBA
	CV	CABO VERDE
	CW	CURAZAO
	CX	NAVIDAD (ISLA)
	CY	CHIPRE
	CZ	REPUBLICA CHECA
	DE	ALEMANIA
	DJ	YIBUTI
	DK	DINAMARCA
	DM	DOMINICA
	DO	REPUBLICA DOMINICANA
	DZ	ARGELIA
	EC	ECUADOR
	EE	ESTONIA
	EG	EGIPTO
	EH	SAHARA OCCIDENTAL
	ER	ERITREA
	ES	ESPAÑA
	ET	ETIOPIA
	FI	FINLANDIA
	FJ	FIYI (ISLAS)
	FK	MALVINAS (ISLAS) (FALKLAND)
	FM	MICRONESIA (ESTADOS FEDERADOS)
	FO	FEROE (ISLAS)
	FR	FRANCIA
	GA	GABON
	GB	REINO UNIDO
	GD	GRANADA
	GE	GEORGIA
	GF	GUAYANA FRANCESA
	GG	GUERNSEY
	GH	GHANA
	GI	GIBRALTAR
	GL	GROENLANDIA
	GM	GAMBIA
	GN	GUINEA
	GQ	GUINEA ECUATORIAL
	GR	GRECIA
	GS	GEORGIA DEL SUR E ISLAS SANDWICH DEL SUR
	GT	GUATEMALA
	GU	GUAM
	GW	GUINEA-BISSAU
	GY	GUYANA
	HK	HONG KONG
	HM	ISLA HEARD Y ISLAS MCDONALD
	HN	HONDURAS
	HR	CROACIA
	HT	HAITI
	HU	HUNGRIA
	ID	INDONESIA
	IE	IRLANDA
	IL	ISRAEL
	IM	ISLA DE MAN
	IN	INDIA
	IO	TERRITORIO BRITANICO DEL OCEANO INDICO
	IQ	IRAQ
	IR	IRAN (REPUBLICA ISLAMICA)
	IS	ISLANDIA
	IT	ITALIA
	JE	JERSEY
	JM	JAMAICA
	JO	JORDANIA
	JP	JAPON
	KE	KENIA
	KG	KIRGUZISTAN
	KH	CAMBOYA
	KI	KIRIBATI
	KM	COMORAS
	KN	SAN CRISTOBAL Y NIEVES
	KP	COREA (REPUBLICA POPULAR DEMOCRATICA)
	KR	COREA (REPUBLICA DE)
	KW	KUWAIT
	KY	ISLAS CAIMAN
	KZ	KAZAJISTAN
	LA	LAO
	LB	LIBANO
	LC	SANTA LUCIA
	LI	LIECHTENSTEIN
	LK	SRI LANKA
	LR	LIBERIA
	LS	LESOTO
	LT	LITUANIA
	LU	LUXEMBURGO
	LV	LETONIA
	LY	LIBIA (JAMAHIRIYA ARABE)
	MA	MARRUECOS
	MC	MONACO
	MD	REPUBLICA DE MOLDAVIA
	ME	MONTENEGRO
	MF	SAN MARTIN
	MG	MADAGASCAR
	MH	MARSHALL (ISLAS)
	MK	ANTIGUA REPUBLICA YUGOSLAVA DE MACEDONIA
	ML	MALI
	MM	MYANMAR
	MN	MONGOLIA
	MO	MACAO
	MP	MARIANAS DEL NORTE (ISLAS)
	MQ	MARTINICA
	MR	MAURITANIA
	MS	MONTSERRAT
	MT	MALTA
	MU	MAURICIO
	MV	MALDIVAS
	MW	MALAUI
	MX	MEXICO
	MY	MALASIA
	MZ	MOZAMBIQUE
	NA	NAMIBIA
	NC	NUEVA CELEDONIA
	NE	NIGER
	NF	NORFOLK (ISLA)
	NG	NIGERIA
	NI	NICARAGUA
	NL	PAISES BAJOS
	NO	NORUEGA
	NP	NEPAL
	NR	NAURU
	NU	NIUE (ISLA)
	NZ	NUEVA ZELANDA
	OM	OMAN
	PA	PANAMA
	PE	PERU
	PF	POLINESIA FRANCESA
	PG	PAPUA-NUEVA GUINEA
	PH	FILIPINAS
	PK	PAKISTAN
	PL	POLONIA
	PM	SAN PEDRO Y MIQUELON
	PN	PITCAIRN
	PR	PUERTO RICO
	PS	TERRITORIO PALESTINO OCUPADO
	PT	PORTUGAL
	PW	PALAOS
	PY	PARAGUAY
	QA	QATAR
	QQ	AVITUALLAMIENTO Y COMBUSTIBLE
	QR	AVI.Y COMB.MARCO INTER. INTRACOMUNITARIO
	QS	AVI.Y COMB.MARCO INTER.TERCEROS PAISES
	QU	PAISES Y TERRITORIOS NO DETERMINADOS
	QV	PAIS.Y TERRI.NO DETER.MARCO INTER.INTRA.
	QW	PAI.Y TERRI.NO DETER.MAR.INTR.TER.PAIS.
	QX	PAIS.Y TERRI.NO PREC.RAZO.COME. O MILIT.
	QY	PAIS.Y TERRI.NO PREC.R.COME.O MILIT.INT.
	QZ	PAIS.Y TERRI.NO PREC.R.CO.O MIL.TE.PAI.
	RE	REUNION
	RO	RUMANIA
	RS	SERBIA
	RU	RUSIA (FEDERACION DE)
	RW	RUANDA
	SA	ARABIA SAUDI
	SB	ISLAS SALOMON
	SC	SEYCHELLES
	SD	SUDAN
	SE	SUECIA
	SG	SINGAPUR
	SH	SANTA ELENA
	SI	ESLOVENIA
	SJ	SVALBARD  Y JAN MAYEN
	SK	ESLOVAQUIA
	SL	SIERRA LEONA
	SM	SAN MARINO
	SN	SENEGAL
	SO	SOMALIA
	SR	SURINAM
	SS	SUDAN DEL SUR
	ST	SANTO TOME Y PRINCIPE
	SV	EL SALVADOR
	SX	SINT MAARTEN
	SY	REPUBLICA ARABE SIRIA
	SZ	SUAZILANDIA
	TC	TURCAS Y CAICOS (ISLAS)
	TD	CHAD
	TF	TIERRAS AUSTRALES FRANCESAS
	TG	TOGO
	TH	TAILANDIA
	TJ	TAYIKISTAN
	TK	TOKELAU (ISLAS)
	TL	TIMOR ORIENTAL
	TM	TURKMENISTAN
	TN	TUNEZ
	TO	TONGA
	TR	TURQUIA
	TT	TRINIDAD Y TOBAGO
	TV	TUVALU
	TW	TAIWAN
	TZ	TANZANIA (REPUBLICA UNIDA DE)
	UA	UCRANIA
	UG	UGANDA
	UM	ISLAS MENORES ALEJADAS DE ESTADOS UNIDOS
	US	ESTADOS UNIDOS
	UY	URUGUAY
	UZ	UZBEKISTAN
	VA	SANTA SEDE
	VC	SAN VICENTE Y LAS GRANADINAS
	VE	VENEZUELA
	VG	VIRGENES BRITANICAS (ISLAS)
	VI	VIRGENES DE LOS ESTADOS UNIDOS (ISLAS)
	VN	VIETNAM
	VU	VANUATU
	WF	WALLIS Y FUTUNA
	WS	SAMOA
	X9	AVITUALLAMIENTOS BUQUES Y AERONAV. NAC
	YE	YEMEN
	YT	MAYOTTE
	ZA	SUDAFRICA
	ZM	ZAMBIA
	ZW	ZIMBABUE

	 */
}
