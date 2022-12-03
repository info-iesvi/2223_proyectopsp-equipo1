package appVGShop.gestionUsuarios.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import appVGShop.gestionUsuarios.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
