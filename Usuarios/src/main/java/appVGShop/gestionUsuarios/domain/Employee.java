package appVGShop.gestionUsuarios.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * Clase de Empleado base. Cuenta como una de las entidades a persistir.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer empleadoID; //Identificador del empleado

    private String nombreEmpleado; //Nombre
    private String correoEmpleado; //Correo electrónico
    private String passwdEmpleado; //Contraseña para el sistema

    private Boolean esSuperior; //Determina si el empleado es gerente o no

}
