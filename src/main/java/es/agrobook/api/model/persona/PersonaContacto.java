package es.agrobook.api.model.persona;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaContacto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int telefonoFijo;

	private int telefonoMovil;

	private String email;
	
}
