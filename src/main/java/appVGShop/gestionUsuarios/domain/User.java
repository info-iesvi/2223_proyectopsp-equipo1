package appVGShop.gestionUsuarios.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue
    private Integer empleadoID;

    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;

    @ManyToOne
    @JoinColumn(name="empleadoID")
    private User codSuperior;
}
