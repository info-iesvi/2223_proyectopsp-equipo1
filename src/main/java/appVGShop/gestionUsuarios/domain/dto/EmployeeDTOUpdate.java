package appVGShop.gestionUsuarios.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDTOUpdate {

    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;
    private Integer codSuperior;

}
