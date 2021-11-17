package fp.musica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlbumStream implements AlbumInterfaz {

	private List<Cancion> canciones;
	

	public AlbumStream() {
		this.canciones = new ArrayList<>();
	}
	
	public AlbumStream(Stream<Cancion> canciones) {
	this.canciones = canciones.collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canciones == null) ? 0 : canciones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AlbumStream))
			return false;
		AlbumStream other = (AlbumStream) obj;
		if (canciones == null) {
			if (other.canciones != null)
				return false;
		} else if (!canciones.equals(other.canciones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Album [canciones=" + canciones + "]";
	}

	
	@Override
	public void anadirCancion(Cancion cancion) {
		this.canciones.add(cancion);
	}

	@Override
	public void anadirCanciones(List<Cancion> canciones) {
		this.canciones.addAll(canciones);
	}

	@Override
	public void eliminaCancion(Cancion cancion) {
		this.canciones.remove(cancion);
	}

	@Override
	public Integer getNumCanciones() {
		return this.canciones.size();
	}

//	Existe
	@Override
	public Boolean existeCancionTriste() {
		return this.canciones.stream().anyMatch(c -> c.getSpotifyValence() <= 0.35);
	}

//	Media
	@Override
	public Double getAlegriaMedia() {
		return this.canciones.stream().collect(Collectors.averagingDouble(Cancion::getSpotifyValence));
	}

//	Filtro
	@Override
	public List<Cancion> cancionesDecadaN(Integer n) {
		return this.canciones.stream().filter(c -> c.getDecade().equals(n)).collect(Collectors.toList());
	}

//	Maps
	/**
	 * Entrega 7 1.2a
	 */
	@Override
	public Map<Integer, List<Cancion>> getCancionesPorDecada() {
		return this.canciones.stream().collect(Collectors.groupingBy(Cancion::getDecade));
	}

	/**
	 * Entrega 7 1.2b, 1.3
	 */
	@Override
	public Map<String, Integer> getNumCancionesPorPais() {
		return this.canciones.stream().collect(Collectors.groupingBy(Cancion::getCountry, Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
	}

//	Filtro + Minimo 
//		Filtro -> Decada
//		Minimo -> Rank
	@Override
	public Cancion getMejorCancionDecadaN(Integer n) {
		return this.canciones.stream().filter(c -> c.getDecade().equals(n)).min(Comparator.comparing(Cancion::getRank)).get();
	}
	
//	Filtro + Orden 
//		Filtro -> Pais
//		Orden -> ValenciaSpotify (mayor a menor)
	@Override
	public List<Cancion> getCancionesDelPaisOrdenadasPorValenciaSpotify(String pais) {
		return this.canciones.stream().filter(c -> c.getCountry().equals(pais)).sorted(Comparator.comparing(Cancion::getSpotifyValence).reversed()).
				collect(Collectors.toList());
	}
	
	/**
	 * Entrega 7 1.1
	 */
//	Filtro + Media
//		Filtro -> Decada
//		Media -> ValenciaSpotify
	@Override
	public Double getMediaValenciaSpotifyDecadaN(Integer n) {
		return this.canciones.stream().filter(c -> c.getDecade().equals(n)).mapToDouble(Cancion::getSpotifyValence).average().orElse(0.);
	}
	
	/**
	 * Entrega 7 1.4
	 */
//	Map
//		Key -> Pais
//		Value -> ValenciaSpotify maxima 
	@Override
	public Map<String, Cancion> getValenciaSpotifyMaxPorPais(){
		return this.canciones.stream().collect(Collectors.groupingBy(Cancion::getCountry, 
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Cancion::getSpotifyValence)), c -> c.get())));
	}
	
	/**
	 * Entrega 7 1.5
	 */
//	SortedMap
//		Key -> Pais
//		Values -> Canciones con mayor ValenciaSpotify 
	@Override
	public SortedMap<String, List<String>> getNCancionesMasAlegresPorPais(Integer n) {
		Map<String, List<Cancion>> mapa = canciones.stream().collect(Collectors.groupingBy(Cancion::getCountry));
		return new TreeMap<>(mapa.entrySet().stream().collect(Collectors.toMap(x -> x.getKey(), y -> getNCancionesPorValenciaSpotify(n))));
	}
	
	private List<String> getNCancionesPorValenciaSpotify(Integer n) {
		return this.canciones.stream().sorted(Comparator.comparing(Cancion::getSpotifyValence)).limit(n).map(Cancion::getName).collect(Collectors.toList());
	}
	
	/**
	 * Entrega 7 1.6
	 */
	//Calcula un map y obtiene la clave mas frecuente
	@Override
	public Alegria getTipoAlegriaMasFrecuente() {
		return this.canciones.stream().collect(Collectors.groupingBy(Cancion::getAlegria, Collectors.counting())).entrySet().stream()
				.max(Comparator.comparing(c -> c.getValue())).get().getKey();
	}
	
}
