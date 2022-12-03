package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDTO {

    private int empleadoID;
    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;

    @ManyToOne
    @JoinColumn(name="empleadoID")
    private int codSuperior;

}
