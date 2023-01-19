# Documentación del proyecto
Equipo 1

Año: 2022-2023

Módulo: PSP

## [Codificación-2] Requisitos funcionales 1/2 con app dockerizada

### Cambios mayores

* Implementación de capa servicio a todas las gestiones del sistema. Realiza conversión DTO cuando es necesario.
* Conversores movidos a la capa de servicio.

### Pruebas con Postman

#### GESTIÓN DE EMPLEADOS

Habrá más información en el código de cómo funciona cada uno de los métodos.

Creando un empleado:

![img.png](images/doc2img1.png)

Viendo todos los empleados:

![img.png](images/doc2img2.png)

Tomando un solo empleado:

![img.png](images/doc2img3.png)

Editando un empleado:

![img.png](images/doc2img4.png)

![img.png](images/doc2img4_1.png)

Borrando un empleado:

![img.png](images/doc2img5.png)

![img.png](images/doc2img5_1.png)

----

#### GESTIÓN DE GÉNEROS

Género tiene una lista con los videojuegos que le pertenecen. Cuando un videojuego se edita o borra, este desaparece de la lista del género.
De base, los géneros no tienen ningún juego en su lista. Si un género se borra, los juegos dentro de él también.

Creando un género:

![img.png](images/doc2img6.png)

Viendo todos los géneros:

![img.png](images/doc2img7.png)

Tomando un solo género:

![img.png](images/doc2img8.png)

Editando la descripción de un género:

![img.png](images/doc2img9.png)

Borrando un género:

![img.png](images/doc2img10.png)

![img.png](images/doc2img10_1.png)

----

#### GESTIÓN DE VIDEOJUEGOS

Los videojuegos al crearse deben pertenecer a un género el cual es indicado en el path.

Creando un juego:

![img.png](images/doc2img11.png)

Mostrando todos los juegos independientemente de género (Aparecen duplicados por testeo previo):

![img.png](images/doc2img12.png)

Mostrando info de un juego específico:

![img.png](images/doc2img13.png)

Editando la info de un juego:

![img.png](images/doc2img14.png)

Borrando un juego:

![img.png](images/doc2img15.png)

![img.png](images/doc2img15_1.png)

Mostrando los géneros con juegos añadidos:

![img.png](images/doc2img16.png)

----

### Explicación DTOs

El sistema cuenta a lo largo de sus tres gestiones con dos tipos de DTO que se ven prevalentemente:

* El DTO normal, cuyos objetos usaremos para mantener la información de estos sin tener que estar acudiendo constantemente al repositorio. Aparte, servirá como una manera de desacoplar estos objetos de la capa de servicio.
* El DTO de creación, el cual usamos como esquema para poder enviar cuerpos de información json a través de las peticiones. Mantienen los datos justos y necesarios, evitando los ID que sean autogenerados (puesto que resultaría irrelevante una vez llegase al sistema).

El paso de un tipo de objeto a otro (VO a DTO y viceversa) ocurre a través de los convertidores, que se encuentran en la capa de aplicación. Utilizan el ModelMapper para mapear las clases y automáticamente transmutarlas.