package appVGShop.gestionUsuarios.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// Es una anotación de acceso directo conveninete que agrupa las características
// de @ToString, @EqualsAndHashCode, @Getter, @Setter y @RequiredArgsConstructor juntas.
@NoArgsConstructor
// Genera un constructor con todos los atributos.
@AllArgsConstructor
// Genera un constructor sin atributos.
@Entity
// Es la persistencia de objetos almacenados como registros en la base de datos.
public class Employee {

    @Id
    // La anotación se utiliza para determinar el ID de una entidad, aplicándola sobre la propiedad que sería el ID de la entidad.
    @GeneratedValue
    // La anotación se emplea a una propiedad o campo de clave principal de una entidad o superclase
    // correlacionada junto con la anotación @Id.
    private Integer empleadoID;

    private String nombreEmpleado;
    private String correoEmpleado;
    private String passwdEmpleado;

    @ManyToOne
    // La anotación @ManyToOne, nos permite mapear una entidad con otra.
    // Como única regla, es necesario la clase que sea una entidad, es decir, que también esté anotada con @Entity.
    @JoinColumn(name="empleadoID")
    // La anotación se utiliza para crear múltiples columnas de unión.
    private Employee codSuperior;

}
