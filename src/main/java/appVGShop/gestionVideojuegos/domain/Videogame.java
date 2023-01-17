package appVGShop.gestionVideojuegos.domain;

import appVGShop.gestionGenero.domain.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
public class Videogame {

    @Id
    @GeneratedValue
    private Integer vgId;

    private String nombreVg;
    private String descripcionVg;
    private LocalDate fechaLanzVg;
    private Integer pegi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="generoid", nullable = true)
    private Genre genero;
}
