package appVGShop.gestionVideojuegos.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Clase de videojuego base. Cuenta como una de las entidades a persistir
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Videogame {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer vgId;

    private String nombreVg;
    private String descripcionVg;
    private LocalDate fechaLanzVg;
    private Integer pegi;
}
