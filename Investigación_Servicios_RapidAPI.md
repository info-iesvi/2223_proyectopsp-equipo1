# Investigando Servicios para el Proyecto
Equipo 1

Año: 2022-2023

Módulo: PSP

## APIs seleccionadas:
* Best Game Price Search: [https://rapidapi.com/ymfh/api/game-price/](https://rapidapi.com/PaweLewoniewski/api/best-game-price-search)
* Epic Games store: [https://rapidapi.com/archergardinersheridan/api/steam-store-data](https://rapidapi.com/psimavel/api/epic-games-store)
* Game Prices: [https://rapidapi.com/SapphireWare/api/video-game-price/](https://rapidapi.com/wim.onderbeke/api/game-prices)

## Epic Games store
Ofrece los siguientes endpoints, con la restricción de que se tiene que estar suscrito para utilizarlas:

### GET Search: Busca los datos de un juego y los muestra.

#### CURL de ejemplo: 
``` shell
curl --request GET \
	--url https://epic-games-store.p.rapidapi.com/search/fortnite/page/1/country/US/locale/en \
	--header 'X-RapidAPI-Host: epic-games-store.p.rapidapi.com' \
	--header 'X-RapidAPI-Key: 08dab370bamshe9d8629a3882b9cp1cfb9ejsnac299ca7c162'
```

#### Implementación Java:
``` java
HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://epic-games-store.p.rapidapi.com/search/fortnite/page/1/country/US/locale/en"))
		.header("X-RapidAPI-Key", "08dab370bamshe9d8629a3882b9cp1cfb9ejsnac299ca7c162")
		.header("X-RapidAPI-Host", "epic-games-store.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
```

#### Prueba:
![image](https://user-images.githubusercontent.com/73997994/199533700-18db3466-9603-44e7-853a-397881caff31.png)

### GET Get News: Muestra noticias de la plataforma.

#### CURL de ejemplo:
``` shell
curl --request GET \
	--url https://epic-games-store.p.rapidapi.com/getNews/locale/en/limit/30 \
	--header 'X-RapidAPI-Host: epic-games-store.p.rapidapi.com' \
	--header 'X-RapidAPI-Key: 08dab370bamshe9d8629a3882b9cp1cfb9ejsnac299ca7c162'
```

#### Implementación Java:
``` java
HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://epic-games-store.p.rapidapi.com/getNews/locale/en/limit/30"))
		.header("X-RapidAPI-Key", "08dab370bamshe9d8629a3882b9cp1cfb9ejsnac299ca7c162")
		.header("X-RapidAPI-Host", "epic-games-store.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
```

#### Prueba:
![image](https://user-images.githubusercontent.com/73997994/199534577-c0ee53b3-eac3-4ed3-9887-621d2ff5c80a.png)

### GET Get free games: Muestra una lista de los juegos gratis actuales.

#### CURL de ejemplo:
``` shell
curl --request GET \
	--url https://epic-games-store.p.rapidapi.com/getFreeGames/country/US/locale/en \
	--header 'X-RapidAPI-Host: epic-games-store.p.rapidapi.com' \
	--header 'X-RapidAPI-Key: 08dab370bamshe9d8629a3882b9cp1cfb9ejsnac299ca7c162'
```

#### Implementación Java:
``` java
HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://epic-games-store.p.rapidapi.com/getFreeGames/country/US/locale/en"))
		.header("X-RapidAPI-Key", "08dab370bamshe9d8629a3882b9cp1cfb9ejsnac299ca7c162")
		.header("X-RapidAPI-Host", "epic-games-store.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
```

#### Prueba:
![image](https://user-images.githubusercontent.com/73997994/199535323-a4e51b65-c805-4194-8cc7-43963be05f29.png)

# METED LOS QUE FALTAN
Seguid mas o menos la estructura esta que se supone que sea así como se entreguen. Aseguraos de poner el código en los bloques separados con comas izquierdas, y justo antes de la primera línea de código poned el lenguaje que se supone que sea para hacerlo más legible.
