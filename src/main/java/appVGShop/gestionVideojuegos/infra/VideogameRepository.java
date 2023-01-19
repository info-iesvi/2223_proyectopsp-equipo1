package appVGShop.gestionVideojuegos.infra;

import appVGShop.gestionVideojuegos.domain.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository extends JpaRepository<Videogame, Integer> {
}
