package es.agrobook.api.model.edificacion;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EdificacionClasificacion{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private String descripcion;

	@ManyToOne(optional = false)
	private EdificacionTipologia tipologia;


	// Entidades enlazadas

	@OneToMany(mappedBy = "clasificacion")
	private Set<Edificacion> edificaciones;

	/*
	* 
	Código	Tipología	Código SIEX	Edificación e instalación
	1	Naves y obras de edificación de entidad constructiva	1	Abrevadero y abastecimiento de agua
	1	Naves y obras de edificación de entidad constructiva	2	Almacén de maquinaria
	1	Naves y obras de edificación de entidad constructiva	3	Almacén de productos y materias primas
	1	Naves y obras de edificación de entidad constructiva	4	Almazara
	1	Naves y obras de edificación de entidad constructiva	5	Alojamiento ganadero aves
	1	Naves y obras de edificación de entidad constructiva	6	Alojamiento ganadero bovino de carne
	1	Naves y obras de edificación de entidad constructiva	7	Alojamiento ganadero bovino de leche
	1	Naves y obras de edificación de entidad constructiva	8	Alojamiento ganadero conejos
	1	Naves y obras de edificación de entidad constructiva	9	Alojamiento ganadero equino
	1	Naves y obras de edificación de entidad constructiva	10	Alojamiento ganadero porcino
	1	Naves y obras de edificación de entidad constructiva	11	Alojamiento ganadero varios
	1	Naves y obras de edificación de entidad constructiva	12	Alojamiento ganadero visones y otros peleteros
	1	Naves y obras de edificación de entidad constructiva	13	Baño
	1	Naves y obras de edificación de entidad constructiva	14	Comedor
	1	Naves y obras de edificación de entidad constructiva	15	Construcción acuicultura, piscifactorías y Cetáreas
	1	Naves y obras de edificación de entidad constructiva	16	Construcción apicultura
	1	Naves y obras de edificación de entidad constructiva	17	Instalación para la producción de hongos
	1	Naves y obras de edificación de entidad constructiva	18	Construcción especies cinegéticas
	1	Naves y obras de edificación de entidad constructiva	19	Construcción Helicicultura
	1	Naves y obras de edificación de entidad constructiva	20	Construcción Lombricultura
	1	Naves y obras de edificación de entidad constructiva	21	Construcción para reparación edificios e instalaciones
	1	Naves y obras de edificación de entidad constructiva	22	Instalaciones de clasificación empaquetado
	1	Naves y obras de edificación de entidad constructiva	23	Invernadero cristal floricultura intensiva
	1	Naves y obras de edificación de entidad constructiva	24	Invernadero cristal horticultura intensiva
	1	Naves y obras de edificación de entidad constructiva	25	Invernadero plástico floricultura intensiva
	1	Naves y obras de edificación de entidad constructiva	26	Invernadero plástico horticultura intensiva
	1	Naves y obras de edificación de entidad constructiva	27	Nave agrícola
	1	Naves y obras de edificación de entidad constructiva	28	Nave ganadera
	1	Naves y obras de edificación de entidad constructiva	29	Nave forestal
	1	Naves y obras de edificación de entidad constructiva	31	Nave para transformación de productos en origen, queserías y otros lácteos.
	1	Naves y obras de edificación de entidad constructiva	32	Ranchos
	1	Naves y obras de edificación de entidad constructiva	33	Refugios
	1	Naves y obras de edificación de entidad constructiva	34	Viviendas de temporeros
	2	Obras de edificación de escasa entidad constructiva	35	Cobertizo
	2	Obras de edificación de escasa entidad constructiva	36	Techado sin cerramiento
	3	Construcciones singulares	37	Bodegas
	3	Construcciones singulares	38	Bodegas subterráneas
	3	Construcciones singulares	39	Construcciones subterráneas
	3	Construcciones singulares	40	Edificios relacionados con actividades deportivas u observación de la naturaleza
	3	Construcciones singulares	41	Instalaciones deportivas y de acampada
	3	Construcciones singulares	42	Picaderos
	3	Construcciones singulares	43	Plazas de toros
	3	Construcciones singulares	44	Tentaderos
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	45	Bancadas
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	46	Caminos de la explotación
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	47	Canales
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	48	Conducciones
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	49	Conducciones generales
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	50	Cortavientos no forestales
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	51	Enarenados
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	52	Estacionamientos maquinaria agrícola y de transporte
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	53	Gavias y jables
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	54	Líneas de transporte y clasificación
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	55	Muelles de carga
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	56	Muros de contención
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	57	Pozos y galerías
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	58	Recintos para el recibo y acopio de materias primas
	5	Construcciones e instalaciones auxiliares	59	Cámaras frigoríficas
	5	Construcciones e instalaciones auxiliares	60	Casetas de riego
	5	Construcciones e instalaciones auxiliares	61	Casetas de transformadores
	5	Construcciones e instalaciones auxiliares	62	Balsas para riego
	5	Construcciones e instalaciones auxiliares	63	Depuradoras
	5	Construcciones e instalaciones auxiliares	65	Saneamiento, desagües, drenajes y fosas
	5	Construcciones e instalaciones auxiliares	66	Secaderos de grano
	5	Construcciones e instalaciones auxiliares	67	Secaderos de tabaco
	6	Depósitos	68	Depósito de líquido
	6	Depósitos	69	Depósitos de gas
	6	Depósitos	70	Estanques y balsas
	6	Depósitos	71	Fosas de purín
	6	Depósitos	72	Silos de grano
	6	Depósitos	73	Silos forrajeros, heniles y pajares
	7	Construcciones tradicionales 	74	Horreo
	7	Construcciones tradicionales 	75	Molino
	7	Construcciones tradicionales 	76	Noria
	7	Construcciones tradicionales 	77	Palloza
	8	Instalación eléctrica	78	Alumbrado
	8	Instalación eléctrica	79	Electrificación por energía eólica
	8	Instalación eléctrica	80	Instalaciones de paneles solares
	8	Instalación eléctrica	81	Electrificación por línea
	8	Instalación eléctrica	82	Grupos electrógenos
	8	Instalación eléctrica	83	Transformadores
	9	Instalación riego	84	Bomba
	9	Instalación riego	85	Cabezal de riego
	9	Instalación riego	86	Electroválvulas
	9	Instalación riego	87	Sistemas agua subterránea
	9	Instalación riego	88	Sistemas agua superficial
	1	Naves y obras de edificación de entidad constructiva	89	Alojamiento ganadero ovino
	1	Naves y obras de edificación de entidad constructiva	90	Alojamiento ganadero caprino
	1	Naves y obras de edificación de entidad constructiva	91	Instalación de recepción, selección, preparación, tratamiento y envasado semillas
	1	Naves y obras de edificación de entidad constructiva	92	Almacén conservación semillas
	1	Naves y obras de edificación de entidad constructiva	93	Centro expedición y logística
	1	Naves y obras de edificación de entidad constructiva	94	Oficina
	1	Naves y obras de edificación de entidad constructiva	95	Instalación para acondicionamiento de grano
	1	Naves y obras de edificación de entidad constructiva	96	Instalación de geminación de semillas                                                                                          
	1	Naves y obras de edificación de entidad constructiva	97	Instalación de procesamiento de madera o embalajes de madera
	1	Naves y obras de edificación de entidad constructiva	98	Centro de jardinería
	1	Naves y obras de edificación de entidad constructiva	99	Laboratorio
	5	Construcciones e instalaciones auxiliares	100	Campo madre de plantas de vivero (en invernadero)
	5	Construcciones e instalaciones auxiliares	101	Campo de producción de plantas de vivero (en invernadero)
	5	Construcciones e instalaciones auxiliares	102	Almacén para la preparación y conservación de plantas de vivero
	5	Construcciones e instalaciones auxiliares	103	Semillero
	5	Construcciones e instalaciones auxiliares	104	Instalación para aclimatación de plantas en producción “in vitro”
	5	Construcciones e instalaciones auxiliares	105	Cámaras conservación, estratificación y multiplicación de semillas, estaquillas o injertos
	5	Construcciones e instalaciones auxiliares	106	Campo madre de plantas de vivero
	5	Construcciones e instalaciones auxiliares	107	Campo de producción de plantas de vivero
	5	Construcciones e instalaciones auxiliares	108	Campo de precontrol y postcontrol de semillas
	4	Espacios anejos y construcciones e instalaciones a cielo abierto	109	Cerramientos de la explotación


    */

}