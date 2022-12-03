package appVGShop.gestionUsuarios.infra.controller;

import appVGShop.gestionUsuarios.domain.Employee;
import appVGShop.gestionUsuarios.domain.dto.EmployeeDTO;
import appVGShop.gestionUsuarios.domain.dto.EmployeeDTOCreator;
import appVGShop.gestionUsuarios.domain.dto.converter.UserDTOConverter;
import appVGShop.gestionUsuarios.infra.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta es la clase de controlador que utilizaremos para recibir las peticiones externas.
 * Tiene las funciones de un CRUD normal.
 */
@RestController
// La anotación marca la clase como un controlador donde cada método devuelve un objeto de dominio en lugar de una vista.
@RequiredArgsConstructor
// Genera un constructor con todos los argumentos requeridos.
// Los argumentos obligatorios son campos finales y campos con restricciones como @NonNull.
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final UserDTOConverter userDTOConverter;

    /**
     * Método de listado de todos los empleados.
     *
     * Se utiliza el repositorio actual y se obtiene una lista de empleados de este.
     *
     * @return 404 si no encuentra nada, 200 y el listado si hay más de uno.
     */
    @GetMapping("/employees")
    // La anotación se utiliza para asignar solicitudes HTTP GET a métodos de controlador específicos.
    public ResponseEntity<?> getAll() {

        List<Employee> employeeList = employeeRepository.findAll();

        if (employeeList.isEmpty()) {

            return ResponseEntity.notFound().build();

        } else {

            List<EmployeeDTO> dtoList = employeeList.stream().map(userDTOConverter::fromPropertyToDTO).collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);

        }

    }

    /**
     * Método para mostrar un empleado según su ID.
     *
     * Se toma la id desde la url, se busca con esa id en el repositorio y devuelve un Employee
     *
     * @param id
     * @return 404 si no se encuentra nada // 200 si el empleado existe.
     */
    @GetMapping("/employees/{id}")
    // La anotación se utiliza para asignar solicitudes HTTP GET a métodos de controlador específicos.
    public ResponseEntity<?> getUser(@PathVariable Integer id) {

        // La anotación se utiliza para anotar los argumentos del método del controlador de solicitudes.

        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(employee);

        }

    }

    /**
     * Método de creación de empleado.
     *
     * Se toman los datos del cuerpo, para crear un nuevo empleado.
     *
     * @param newUserCreator
     * @return 201 con los datos del nuevo usuario
     */
    @PostMapping("/employees")
    // La anotación se utiliza para asignar solicitudes HTTP POST a métodos de controlador específicos.
    public ResponseEntity<?> newUser(@RequestBody EmployeeDTOCreator newUserCreator) {

        // La anotación se utiliza para anotar los argumentos del método del controlador de solicitudes.

        Employee newEmployee = new Employee();

        newEmployee.setNombreEmpleado(newUserCreator.getNombreEmpleado());

        newEmployee.setCorreoEmpleado(newUserCreator.getCorreoEmpleado());

        newEmployee.setPasswdEmpleado(newUserCreator.getPasswdEmpleado());

        Employee superior = employeeRepository.findById(newUserCreator.getCodSuperior()).orElse(null);

        newEmployee.setCodSuperior(superior);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(newEmployee));

    }

    /**
     * Método de edición de empleado.
     *
     * Se introducen los datos que se van ha editar en el cuerpo y se toma la ID desde la url.
     * Se realiza un mapeado de los empleados que hay en el repositorio, cuando lo encuentra toma el empleado y
     * actualiza sus datos.
     *
     * @param editData
     * @param id
     * @return 200 si se ha podido editar correctamente // 404 si no encuentra el empleado.
     */
    @PutMapping("/employees/{id}")
    // La anotación se utiliza para asignar solicitudes HTTP PUT a métodos de controlador específicos.
    public ResponseEntity<?> editUser(@RequestBody EmployeeDTOCreator editData, @PathVariable Integer id) {

        // La anotación se utiliza para anotar los argumentos del método del controlador de solicitudes.

        return employeeRepository.findById(id).map(p -> {

            p.setNombreEmpleado(editData.getNombreEmpleado());

            p.setCorreoEmpleado(editData.getCorreoEmpleado());

            p.setPasswdEmpleado(editData.getPasswdEmpleado());

            Employee superior = employeeRepository.findById(editData.getCodSuperior()).orElse(null);

            p.setCodSuperior(superior);

            return ResponseEntity.ok(employeeRepository.save(p));

        }).orElseGet(() -> {

            return ResponseEntity.notFound().build();

        });

    }

    /**
     * Método de eliminación de empleado.
     *
     * Se recibe la ID del empleado desde la url.
     * Se toma el repositorio de empleados actual, se buscara y eliminara el empleado con la id que se toma.
     *
     * @param id
     * @return 204 sin contenido.
     */
    @DeleteMapping("/employees/{id}")
    // La anotación se utiliza para mapear solicitudes HTTP DELTE en métodos de controlador específicos.
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {

        // La anotación se utiliza para anotar los argumentos del método del controlador de solicitudes.

        employeeRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

}
