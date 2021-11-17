package fp.musica;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface AlbumInterfaz {

	void anadirCancion(Cancion cancion);

	void anadirCanciones(List<Cancion> canciones);

	void eliminaCancion(Cancion cancion);

	Integer getNumCanciones();

	//	Existe
	Boolean existeCancionTriste();

	//	Media
	Double getAlegriaMedia();

	//	Filtro
	List<Cancion> cancionesDecadaN(Integer n);

	//	Maps
	Map<Integer, List<Cancion>> getCancionesPorDecada();

	Map<String, Integer> getNumCancionesPorPais();

	//	Filtro + Minimo 
	//		Filtro -> Decada
	//		Minimo -> Rank
	Cancion getMejorCancionDecadaN(Integer n);

	//	Filtro + Orden 
	//		Filtro -> Pais
	//		Orden -> ValenciaSpotify (mayor a menor)
	List<Cancion> getCancionesDelPaisOrdenadasPorValenciaSpotify(String pais);

	//	Filtro + Media
	//		Filtro -> Decada
	//		Media -> ValenciaSpotify
	Double getMediaValenciaSpotifyDecadaN(Integer n);

	//	Map
	//		Key -> Pais
	//		Value -> ValenciaSpotify maxima 
	Map<String, Cancion> getValenciaSpotifyMaxPorPais();

	//	SortedMap
	//		Key -> Pais
	//		Values -> Canciones con mayor ValenciaSpotify 
	SortedMap<String, List<String>> getNCancionesMasAlegresPorPais(Integer n);

	//Calcula un map y obtiene la clave mas frecuente
	Alegria getTipoAlegriaMasFrecuente();

}