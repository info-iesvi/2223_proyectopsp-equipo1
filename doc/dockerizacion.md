**FASE 1**

* Crear contenedor para el proyecto:

  docker run -it -d --name proyecto-mysql -p 3306:3306 -e MYSQL_DATABASE=proyecto -e MYSQL_USER=usuario -e MYSQL_PASSWORD=usuario -e MYSQL_ROOT_PASSWORD=root mysql


* Nos conectamos al contenedor

  docker exec -it proyecto-mysql /bin/bash


* Entraremos al contenedor desde el terminal como usuario

  mysql -u usuario -p -h 127.0.0.1

  password: root


* Usaremos proyecto

  use proyecto


* Estará vacía la tabla, dado que no ha sido inicializada


* Creamos el contenedor phpmyadmin y lo enlazamos con el mysql que creamos previamente

  docker run --name phpmyadmin -d --link proyecto-mysql:db -p 8081:80 phpmyadmin/phpmyadmin


* Accedemos (Los dos contenedores deben estar inicializados) al localhost:8081 e iniciamos como Usuario:usuario / Contraseña:usuario

**FASE 2**
