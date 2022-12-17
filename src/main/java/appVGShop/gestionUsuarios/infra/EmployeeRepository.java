package appVGShop.gestionUsuarios.infra;

import org.springframework.data.jpa.repository.*;
import appVGShop.gestionUsuarios.domain.*;

/**
 * Interfaz de repositorio para Empleados utilizando JPA
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
