package appVGShop.gestionUsuarios.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import appVGShop.gestionUsuarios.domain.Employee;

/**
 * Interfaz de repositorio para Empleados utilizando JPA
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
