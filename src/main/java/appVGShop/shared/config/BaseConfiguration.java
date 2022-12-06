package appVGShop.shared.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// La anotación es parte del marco Spring Core.
// La anotación indica que la clase tiene métodos de definición de @Bean.
// Con esta, el contenedor Spring puede procesar la clase y generar
// Spring Beans para usar en la aplicación.

public class BaseConfiguration {

    /**
     * ModelMapper es una librería Java para copiar o mapear propiedades de un
     * tipo de objeto a otro tipo de objeto, permitiendo copiar también los
     * datos de las referencias a los objetos que contengan.
     *
     * @return
     */
    // Esta anotación se utiliza en el nivel del método.
    // @Bean es una anotación que funciona con @Configuration para crear beans en Spring.
    // Como se mencionó anteriormente, @Configuration tendrá métodos para instanciar y configurar dependencias.
    // Tales métodos serán anotados con @Bean.
    // El método anotado con esta anotación funciona como ID del bean y crea y devuelve el bean real.
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();

    }

}
