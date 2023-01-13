* Crear contenedor para el proyecto:

docker run -it -d --name proyecto-mysql -p 3306:3306 -e MYSQL_DATABASE=proyecto -e MYSQL_USER=usuario -e MYSQL_PASSWORD=usuario -e MYSQL_ROOT_PASSWORD=root mysql
<br>
* Nos conectamos al contenedor

  docker exec -it proyecto-mysql /bin/bash
  <br><br>
* Entraremos al contenedor desde el terminal como usuario

  mysql -u usuario -p -h 127.0.0.1

  password: root
  <br><br>
* Usaremos proyecto

  use proyecto

* Estará vacía la tabla, dado que no ha sido inicializada
