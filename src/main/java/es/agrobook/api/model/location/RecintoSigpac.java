package es.agrobook.api.model.location;

import es.agrobook.api.model.enums.UsoSigpac;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RecintoSigpac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = true)
	private int recinto;					// Doc y (Web -> Parcela = Recinto Sigpac)

	@Column(nullable = false)
	private float superficie;				// Doc y (Web -> Parcela = Recinto Sigpac)
	
	@Column(nullable = false)
	private float pendiente;				// Solo Web -> Parcela = Recinto Sigpac
	
	@Column(nullable = false)
	private float altitud;				// Solo Web -> Parcela = Recinto Sigpac
	
    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UsoSigpac uso;						// Doc y (Web -> Parcela = Recinto Sigpac)
	
	@Column(nullable = true)
	private float superficieSubvencionable;			// Solo Web
	
	@Column(nullable = false)
	private int coeficienteRegadio;			// Solo Web
	// pendientes en Web: pjeSubvencionado, supSubvencionada, coefRegadio, incidencias, región
	// FIN REFERENCIAS SIGPAC


    @ManyToOne(optional = false)
	private ParcelaSigpac parcelaSigpac;

}