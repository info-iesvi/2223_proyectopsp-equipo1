package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Se generan un getter y un setter para todos los atributos.
public class EmployeeDTO {

    //private int empleadoID;
    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;

    private boolean esSuperior;

}
