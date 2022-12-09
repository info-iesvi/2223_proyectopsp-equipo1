package appVGShop.gestionUsuarios.infra.controller;

import appVGShop.gestionUsuarios.domain.Employee;
import appVGShop.gestionUsuarios.domain.dto.EmployeeDTO;
import appVGShop.gestionUsuarios.domain.dto.EmployeeDTOCreator;
import appVGShop.gestionUsuarios.domain.dto.converter.UserDTOConverter;
import appVGShop.gestionUsuarios.infra.EmployeeRepository;
import appVGShop.shared.config.EndpointUrls;
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
@RequestMapping(EndpointUrls.Base + EmployeeController.USER_RESOURCE)
@RequiredArgsConstructor
public class EmployeeController {

    public static final String USER_RESOURCE = "/employee"; //Declara la segunda parte de la URL. Debería ser localhost:8080/appVGShop/employee. Ver EndpointUrls
    private final EmployeeRepository employeeRepository; //Declaración del repositorio de empleados
    private final UserDTOConverter userDTOConverter; //Declaración del convertidor

    /**
     * Método de listado de todos los empleados.
     * <p>
     * Se utiliza el repositorio actual y se obtiene una lista de empleados de este.
     *
     * @return 404 si no encuentra nada, 200 y el listado si hay más de uno.
     */
    @GetMapping(EndpointUrls.GetAll)
    public ResponseEntity<?> getAll() {
        List<Employee> employeeList = employeeRepository.findAll(); //Crea una lista de empleados desde la base de datos

        if (employeeList.isEmpty()) {

            return ResponseEntity.notFound().build(); //Devuelve un ResponseEntity 404 al no encontrar la lista vacía

        } else {

            List<EmployeeDTO> dtoList = employeeList.stream().map(userDTOConverter::fromPropertyToDTO).collect(Collectors.toList()); //Convierte la lista de empleados a una de DTO.
            //Esta parte utiliza la API stream, que nos permite mapear la lista previa a una de DTO utilizando el convertidor en una sola línea.

            return ResponseEntity.ok(dtoList); //Devuelve un ResponseEntity 200 con la lista de DTO.

        }

    }

    /**
     * Método para mostrar un empleado según su ID.
     * <p>
     * Se toma la id desde la url, se busca con esa id en el repositorio y devuelve un Employee.
     *
     * @param id
     * @return 404 si no se encuentra nada // 200 si el empleado existe.
     */
    @GetMapping(EndpointUrls.GetUser)
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        Employee employee = employeeRepository.findById(id).orElse(null); //Busca al empleado del id indicado en PathVariable. De no encontrarlo devuelve null.

        if (employee == null) {

            return ResponseEntity.notFound().build(); //Devuelve un ResponseEntity 404 al no encontrarlo.

        } else {

            return ResponseEntity.ok(employee); //Devuelve un ResponseEntity 200 incluyendo el empleado encontrado.

        }

    }

    /**
     * Método de creación de empleado.
     * <p>
     * Se toman los datos del cuerpo, para crear un nuevo empleado.
     *
     * @param newUserCreator
     * @return 201 con los datos del nuevo usuario
     */
    @PostMapping
    public ResponseEntity<?> newUser(@RequestBody EmployeeDTOCreator newUserCreator) {
        Employee newEmployee = new Employee(); //Declara un nuevo empleado

        newEmployee.setNombreEmpleado(newUserCreator.getNombreEmpleado()); //Establece el nombre del empleado según el cuerpo

        newEmployee.setCorreoEmpleado(newUserCreator.getCorreoEmpleado()); //Establece el correo

        newEmployee.setPasswdEmpleado(newUserCreator.getPasswdEmpleado()); //Establece la contraseña

        newEmployee.setEsSuperior(newUserCreator.getEsSuperior()); //Establece si es gerente o no

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(newEmployee)); //Devuelve un ResponseEntity 201 con el empleado creado.

    }

    /**
     * Método de edición de empleado.
     * <p>
     * Se introducen los datos que se van a editar en el cuerpo y se toma la ID desde la url.
     * Se realiza un mapeado de los empleados que hay en el repositorio, cuando lo encuentra toma el empleado y
     * actualiza sus datos.
     *
     * @param editData
     * @param id
     * @return 200 si se ha podido editar correctamente // 404 si no encuentra el empleado.
     */
    @PutMapping(EndpointUrls.EditUser)
    public ResponseEntity<?> editUser(@RequestBody EmployeeDTOCreator editData, @PathVariable Integer id) {
        return employeeRepository.findById(id).map(p -> {

            p.setNombreEmpleado(editData.getNombreEmpleado()); //Establece el nombre

            p.setCorreoEmpleado(editData.getCorreoEmpleado()); //Establece el correo

            p.setPasswdEmpleado(editData.getPasswdEmpleado()); //Establece la contraseña

            p.setEsSuperior(editData.getEsSuperior()); //Establece si es gerente

            return ResponseEntity.ok(employeeRepository.save(p)); // Devuelve un ResponseEntity 200 con el empleado actualizado

        }).orElseGet(() -> {

            return ResponseEntity.notFound().build(); //Devuelve un ResponseEntity 404 si no encuentra un empleado con tal ID

        });

    }

    /**
     * Método de eliminación de empleado.
     * <p>
     * Se recibe la ID del empleado desde la url.
     * Se toma el repositorio de empleados actual, se buscara y eliminara el empleado con la id que se toma.
     *
     * @param id
     * @return 204 sin contenido.
     */
    @DeleteMapping(EndpointUrls.DeleteUser)
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        employeeRepository.deleteById(id); //Borra el empleado según su ID

        return ResponseEntity.noContent().build(); //Devuelve un ResponseEntity 204 con que no hay contenido.

    }

}
