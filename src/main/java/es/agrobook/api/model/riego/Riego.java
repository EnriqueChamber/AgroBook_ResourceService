package es.agrobook.api.model.riego;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Riego{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private Date fecha;

    @Column(nullable = false)
	private float superficie;

	@ManyToOne(optional = false)
	private RiegoSistemaRiego sistemaRiego;

    @Column(nullable = false)
	private float cantidad;

	@ManyToOne(optional = false)
	private RiegoOrigenAgua origenAgua;

    @Column(nullable = false)
	private String contador;

    @Column(nullable = false)
	private float nitrogenoEnAgua;

    @Column(nullable = false)
	private float p2o5EnAgua;

}