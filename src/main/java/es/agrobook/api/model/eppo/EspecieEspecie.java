package es.agrobook.api.model.eppo;

import java.io.Serializable;
import java.util.Date;

import es.agrobook.api.model.enums.EppoRelacion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(EspecieEspecie.EspecieEspecieId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EspecieEspecie implements Serializable {

	@Id
    @ManyToOne(optional = false)
    private Especie especie;

	@Id
    @ManyToOne(optional = false)
    private Especie especiePadre; // especie Vulnerable

	@Id
    @Enumerated(EnumType.STRING)
    private EppoRelacion relacion;

	@Column(nullable = false)
    private Boolean ataque;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Data
    @Builder
    public static class EspecieEspecieId {
        private long persona;
        private long personaRef;
        private EppoRelacion relacion;

    }
}