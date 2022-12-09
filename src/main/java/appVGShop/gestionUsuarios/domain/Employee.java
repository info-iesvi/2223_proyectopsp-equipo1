package appVGShop.gestionUsuarios.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase de Empleado base. Cuenta como una de las entidades a persistir.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer empleadoID; //Identificador del empleado

    private String nombreEmpleado; //Nombre
    private String correoEmpleado; //Correo electrónico
    private String passwdEmpleado; //Contraseña para el sistema

    private Boolean esSuperior; //Determina si el empleado es gerente o no

}
