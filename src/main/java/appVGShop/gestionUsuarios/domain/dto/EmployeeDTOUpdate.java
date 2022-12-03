package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name="empleadoID")
    private Integer codSuperior;

}
