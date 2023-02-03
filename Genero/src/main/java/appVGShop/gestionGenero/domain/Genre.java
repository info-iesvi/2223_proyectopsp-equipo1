package appVGShop.gestionGenero.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase de Género base. Es una de las entidades a persistir
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer generoID;

    private String nombre;
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id")
    private List<Videogame> listaJuegos;
}
