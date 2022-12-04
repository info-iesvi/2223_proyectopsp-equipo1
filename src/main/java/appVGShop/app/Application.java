package appVGShop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta anotación se usa en la clase de aplicación al configurar un proyecto Spring Boot.
// La clase que se anota con el @SpringBootApplicationdebe mantenerse en el paquete base.
// La única cosa que el @SpringBootApplicationhace es un escaneo de componentes.
// Pero escaneará solo sus subpaquetes.
@SpringBootApplication
public class Application {

    /**
     * Ejecuta la aplicación
     *
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
