package es.agrobook.api.model.persona;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
