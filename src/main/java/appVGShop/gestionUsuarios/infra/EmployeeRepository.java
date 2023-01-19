package appVGShop.gestionUsuarios.infra;

import org.springframework.data.jpa.repository.*;
import appVGShop.gestionUsuarios.domain.*;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de repositorio para Empleados utilizando JPA
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
