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
@RequiredArgsConstructor
public class EmployeeController {
    //TODO toda la clase

    private final EmployeeRepository employeeRepository;
    private final UserDTOConverter userDTOConverter;

    /**
     * Método de listado de todos los empleados.
     * @return 404 si no encuentra nada, 200 y el listado si hay más de uno.
     */
    @GetMapping("/employees")
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
     * @param id
     * @return 404 si no encuentra nada, 200 y el empleado si existe.
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    /**
     * Método de guardado de empleado, especificando sus datos en el cuerpo del mensaje.
     * @param newUserCreator
     * @return 201 con los datos del nuevo usuario
     */
    @PostMapping("/employees")
    public ResponseEntity<?> newUser(@RequestBody EmployeeDTOCreator newUserCreator) {
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
     * Se introducen los datos de edición en el cuerpo y la ID en la url.
     * @param editData
     * @param id
     * @return 200 si sale bien, 404 si no encuentra el empleado.
     */
    @PutMapping("/employees/{id}")
    public ResponseEntity<?> editUser(@RequestBody EmployeeDTOCreator editData, @PathVariable Integer id) {
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
     * Recibe la ID del empleado en la url.
     * @param id
     * @return 204 sin contenido.
     */
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
