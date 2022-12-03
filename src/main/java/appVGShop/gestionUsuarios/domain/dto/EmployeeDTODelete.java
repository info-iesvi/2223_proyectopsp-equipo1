package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDTODelete {

    @Id
    @GeneratedValue
    private Integer empleadoID;

}
