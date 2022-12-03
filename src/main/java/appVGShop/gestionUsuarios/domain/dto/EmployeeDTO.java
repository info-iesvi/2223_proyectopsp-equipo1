package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Se generan un getter y un setter para todos los atributos.
public class EmployeeDTO {

    private int empleadoID;
    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;

    @ManyToOne
    // La anotación @ManyToOne, nos permite mapear una entidad con otra.
    // Como única regla, es necesario la clase que sea una entidad, es decir, que también esté anotada con @Entity.
    @JoinColumn(name="empleadoID")
    // La anotación se utiliza para crear múltiples columnas de unión.
    private int codSuperior;

}
