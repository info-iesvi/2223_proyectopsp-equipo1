package appVGShop.gestionUsuarios.infra;

import appVGShop.gestionUsuarios.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
