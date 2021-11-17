# Primer cuatrimestre

Mi proyecto del primer cuatrimestre implementara distintas funciones sobre el conjunto de datos de tiros de campo de la NBA.

21/10/2020:
	Creacion del Readme.
	
	
11/11/2020:
	Limpieza de los datos del csv, dejando los datos siguientes:
		
		MATCHUP: Encuentro en cuestion. Se divide en fecha, equipo local y equipo visitante.
		
		SHOT_NUMBER: Numero del tiro del partido en cuestion.
		
		PERIOD: Cuarto en que se realiza el tiro.
		
		GAME_CLOCK: Momento del partido.
		
		DRIBBLES: Numero de dribbles hechos por el jugador en el momento
		
		SHOT_DIST: Distancia del intento al aro.
		
		PTS_TYPE: Tipo de intento (puede ser de 2 o de 3).
		
		CLOSEST_DEFENDER: Defensor más cercano al tirador.
		
		PTS: Punto acertado o no y que valor tiene (puede ser 0, 2 o 3).
		
		player_name: Tirador en cuestion.

	Ademas, inclusion de NBA.py y NBA_TEST.py donde se han hecho 2 lectores, el primero incluye matchup y el segundo separa matchup en fecha, local y visitante, siendo el segundo el que se usara durante el proyecto y con un test para comprobar cualquiera de los 2.

	Horas despues, he unido los lectores, de tal manera que ahora el lector realiza la funcion de separador tambien.
	
	
12/11/2020:
	Puestas el nombre de las variables en minusculas, siguiendo las reglas de estilo.
	
	
18/11/2020:
	Propuestas de funciones del trabajo (obsoletas):
		
		Mejor defensor: Recorre todo el CSV y selecciona el jugador que ha causado mas fallos de los rivales usando el parametro closest_defender
		
		% de tiros de campo/triples de un equipo a lo largo de la temporada: ofrecerá el % de acierto
		
		% de tiros de campo/triples de un jugador a lo largo de la temporada: ofrecerá el % de acierto
		
		Maximo anotador: Jugador que ha anotado mas puntos
		
		Mejor triplista (en volumen y en porcentaje): Jugador(es) que han anotado mayor numero de triples y el que ha anotado con mayor porcentaje
		
		--------
		
		Anotaciones por jugador: Se pasa un parametro nombre, con el nombre del jugador en cuestion y se obtiene la anotacion total de ese jugador
		
		--------
		
		Enfrentamientos jugadores: Se le pasa un parametro atacante con el nombre de un jugador en cuestion y se obtienen sus intentos de tiro, si lo ha anotado o no y quien lo defendia en esa jugada
		
		--------
		
		Anotadores por equipo: Se le pasa un parametro equipo con el nombre de un equipo en cuestion y se obtiene una lista ordenada de tuplas con el numero de puntos anotados y el nombre del jugador en cuestion
		
		
19/11/2020:
	Actualizadas las propuestas de funciones, añadiendo la de anotacion por jugador para asi poder obtener la funcion de maximo anotador, incluye el codigo realizado y los test.
	
	
8/12/2020:
	Actualizadas las propuestas de funciones, a�adiendo la de enfrentamientos de jugadores, con su funcion y su test
	

14/12/2020:
	Actualizadas las propuestas de funciones, a�adiendo la de anotadores por equipo, con su funcion y su test	
	
	
27/12/2020:
	Propuestas de funciones rehechas de 0, incluyendo el tipo de ejercicio que es cada una:
		
		Lee NBA: Lee el CSV y devuelve una lista de tuplas con los datos del mismo.
		
		Enfrentamientos jugadores (1): Se le pasa un parametro atacante con el nombre de un jugador en cuestion y se obtienen sus intentos de tiro, si lo ha anotado o no y quien lo defendia en esa jugada.
		
		Anotaciones por jugador (3): Se pasa un parametro nombre, con el nombre del jugador en cuestion y se obtiene la anotacion total de ese jugador.
		
		Maximo anotador (4): Jugador que ha anotado mas puntos.
		
		Anotadores por equipo (6): Se le pasa un parametro equipo con el nombre de un equipo en cuestion y se obtiene una lista ordenada de tuplas con el numero de puntos anotados y el nombre del jugador en cuestion.
		
		Jugadores por equipo (7): Lee el registro y crea un diccionario donde la clave es el equipo y los valores son los jugadores del mismo.
		
		Contar jugadores por equipo (8): Usa el diccionario creado en jugadores por equipo y devuelve el numero de jugadores que hay en cada equipo.
		
		Equipo con mas jugadores (11): Devuelve el equipo con mas jugadores.
		
		Tiro mas lejano y resultado (12): Crea un diccionario que usa como clave los jugadores y como valores, el tiro mas lejano que ha lanzado y su resultado y devuelve el tiro mas lejano de cada jugador y su resultado.
		
		Top n dribbles por jugador (14): Crea un diccionario que usa como clave el nombre del jugador y como valor, el numero de dribles que ha realizado, luego los ordena de mayor a menor y muestra el top n de cada uno.
		
		Grafica anotaciones por jugador (16): Crea un diccionario que usa como clave el nombre del jugador y como valor, la suma de sus puntos obtenidos, luego los ordena de mayor a menor y crea una grafica con cada jugador y sus puntos totales. Es una funcion planteada y comentada, ya que al no funcionar matplotlib, es lo mejor que se puede hacer.
		
		
07/01/2021:
	Colocados los numeros a cada una de las funciones, y funciones hechas y funcionales hasta el 12 y el 14 esta con errores.
	Arreglo del 12
	
	
10/01/2021:
	Arreglo final del 12
	

10/01/2021:
	Arreglo final del 14
	Correccion de errores en el 7
	Planteada la funcion 16