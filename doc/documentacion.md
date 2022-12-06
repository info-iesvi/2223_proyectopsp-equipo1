# Documentación del proyecto
Equipo 1

Año: 2022-2023

Módulo: PSP

## [Codificación-1] Implementando los usuarios

### Pruebas con H2

Primero lanzamos la aplicación y comprobamos que no hayan errores de ejecución.

![Captura de pantalla_20221204_180324.png](images/Captura%20de%20pantalla_20221204_180324.png)

Luego abrimos la consola de h2, para realizar las comprobaciones con la aplicación.

![Captura de pantalla_20221204_175344.png](images/Captura%20de%20pantalla_20221204_175344.png)

Realizamos un select para comprobar que la conexion se ha realizado correctamente.

![Captura de pantalla_20221204_174249.png](images/Captura%20de%20pantalla_20221204_174249.png)

Realizamos un insert para comprobar que los campos automaticamente creados son correctos

![Captura de pantalla_20221204_174351.png](images/Captura%20de%20pantalla_20221204_174351.png)

Realizamos un select para comprobar que el nuevo dato se ha introducido correctamente.

![Captura de pantalla_20221204_174415.png](images/Captura%20de%20pantalla_20221204_174415.png)

Realizamos un update para comprobar que el metodo funciona correctamente.

![Captura de pantalla_20221204_174604.png](images/Captura%20de%20pantalla_20221204_174604.png)

Realizamos un select para visualizar que el cambio se ha realizado correctamente.

![Captura de pantalla_20221204_174618.png](images/Captura%20de%20pantalla_20221204_174618.png)

Realizamos un delete para visualizar que el dato se ha eliminado correctamente.

![Captura de pantalla_20221204_174704.png](images/Captura%20de%20pantalla_20221204_174704.png)

Realizamos un select para visualizar que la eliminación se ha realizado correctamente.

![Captura de pantalla_20221204_174724.png](images/Captura%20de%20pantalla_20221204_174724.png)

### Pruebas con Postman

Añadiendo unos pocos usuarios (Añado 3 más de los mostrados):

![](images/postman_post.png)

Mostrando todos los usuarios:

![](images/postman_getAll.png)

Mostrando un solo usuario:

![](images/postman_getOne.png)

Editando usuario 1:

![](images/postman_updateUser.png)

Borrando usuario 2:

![](images/postman_deleteOne.png)

Todos los cambios realizados con Postman son realizados también en la base de datos H2 a través de JPA.