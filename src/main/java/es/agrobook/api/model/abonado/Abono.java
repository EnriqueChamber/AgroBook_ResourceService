package es.agrobook.api.model.abonado;

import java.util.Date;
import java.util.Set;

import es.agrobook.api.model.catastro.Superficie;
import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.model.maquina.MaquinaUso;
import es.agrobook.api.model.persona.Persona;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Abono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(optional = false)
	private AbonoTipo tipo; 
	
    @Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private AbonoClasificacion clasificacion; // Solo inorgánicos

	@Column(nullable = false)
	private String nombreComercial;

	@Column(nullable = true)
	private String grupoConsumo; // Solo inorgánicos

	@Column(nullable = false)
	private Persona fabricante;

	



}