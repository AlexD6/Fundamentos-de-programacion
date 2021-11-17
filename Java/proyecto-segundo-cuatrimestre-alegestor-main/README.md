El csv consiste en el top 20 canciones de la revista de música BillBoard organizado por décadas desde los años 60 hasta la década de los 2000.

La URL del dataset original es:
	http://kaggle.com/emilynallen/top-20-songs-1970s2000s-w-audio-features
	
Las propiedades dascartadas han sido: danceability, energy, key, loudness, speechiness, acousticness, instrumentalness, liveness, tempo, time_signature y city.

Las propiedades que vamos a tratar son los siguientes:

	Name: Nombre de la canción. String. Consultable.
	Artist: Autor de la canción. String. Consultable.
	Decade: Década en la que fue lanzada la canción. Integer. Consultable.
	Rank: Posición que ocupa en el ranking. Integer. Consultable y modificable.
	Valence: Cuanto mayor sea el valor, la canción será considerada más alegre. Integer. Consultable.
	Duration_ms: Duración de la canción, en milisegundos. Integer. Consultable.
	Country: País de origen del artista. String. Consultable.
	Release Date: Se supone que es la fecha de lanzamiento de la canción, pero han sido fechas creadas aleatoriamente por excel, poniendo como único requerimiento que la fecha generada tiene que encontrarse en la década correspondiente. Date. Consultable y modificable.
	
Las restricciones que vamos a usar son:
	
	La decada tiene que ser mayor que 0.
	La posicion en el ranking tiene que ser un numero entre 1 y 20.
	La valencia tiene que ser mayor que 0.
	La duracion tiene que ser mayor que 0.
	La fecha de lanzamiento tiene que ser menor a la actual.

Las propiedades derivadas que vamos a tratar son:
	
	DurationString: Obtiene la duración de la canción y la muestra en un String de minutos:segundos. String.
	SpotifyValence: Pasa la valencia a tantos por 1, como marca el standard de Spotify. Double.
	EsAlegre: Devuelve True si la valencia supera un 0.65 en spotify. Boolean.
	Alegria: Es un ENUM con valores ALEGRE, NORMAL y TRISTE. Si la valencia de Spotify es superior o igual a 0.65, es ALEGRE, si es inferior o igual a 0.35, sera triste, y si esta entre los valores, sera normal.
	
Criterio de igualdad: 2 canciones son iguales si tienen el mismo nombre y el mismo autor.

Criterio de ordenación: Acorde al criterio de igualdad

Representación como cadena: Incluye el nombre de la canción y su artista.