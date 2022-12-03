package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class EmployeeDTOShow {

    @Id
    // La anotación se utiliza para determinar el ID de una entidad, aplicándola sobre la propiedad que sería el ID de la entidad.
    @GeneratedValue
    // La anotación se emplea a una propiedad o campo de clave principal de una entidad o superclase
    // correlacionada junto con la anotación @Id.
    private Integer empleadoID;

}
