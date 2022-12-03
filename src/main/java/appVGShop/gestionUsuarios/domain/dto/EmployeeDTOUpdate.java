package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDTOUpdate {

    @Id
    @GeneratedValue
    private Integer empleadoID;
    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;
    private Integer codSuperior;

}
