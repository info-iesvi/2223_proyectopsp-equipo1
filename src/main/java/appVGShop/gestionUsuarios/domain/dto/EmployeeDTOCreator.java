package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTOCreator {

    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;

    private Boolean esSuperior;

}
