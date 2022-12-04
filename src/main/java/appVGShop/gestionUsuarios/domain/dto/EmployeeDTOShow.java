package appVGShop.gestionUsuarios.domain.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EmployeeDTOShow {

    //@Id
    // La anotación se utiliza para determinar el ID de una entidad, aplicándola sobre la propiedad que sería el ID de la entidad.
    //@GeneratedValue
    // La anotación se emplea a una propiedad o campo de clave principal de una entidad o superclase
    // correlacionada junto con la anotación @Id.
    //private Integer empleadoID;

    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;

    @ManyToOne
    // La anotación @ManyToOne, nos permite mapear una entidad con otra.
    // Como única regla, es necesario la clase que sea una entidad, es decir, que también esté anotada con @Entity.
    @JoinColumn(name="empleadoID")
    // La anotación se utiliza para crear múltiples columnas de unión.
    private Integer codSuperior;

}
