package appVGShop.gestionGenero.domain;

import appVGShop.gestionVideojuegos.domain.Videogame;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase de Género base. Es una de las entidades a persistir
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {

    @Id
    @GeneratedValue
    private Integer generoID;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "genero")
    private List<Videogame> listaJuegos;

    public void addGame(Videogame videogame) {
        listaJuegos.add(videogame);
        videogame.setGenero(this);
    }

    public void removeGame(Videogame videogame) {
        listaJuegos.remove(videogame);
        videogame.setGenero(null);
    }
}
