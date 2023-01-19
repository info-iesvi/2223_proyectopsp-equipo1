package appVGShop.gestionGenero.infra;

import appVGShop.gestionGenero.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
