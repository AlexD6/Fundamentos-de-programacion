package fp.musica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class AlbumBucles implements AlbumInterfaz {
	
	private List<Cancion> canciones;
	
	public AlbumBucles() {
		canciones = new ArrayList<Cancion>();
	}
	
	public AlbumBucles(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	@Override
	public int hashCode() {
		return this.canciones.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if(o instanceof AlbumBucles) {
			AlbumBucles a = (AlbumBucles) o;
			res = this.canciones.equals(a.canciones);
		}
		return res;
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
		return canciones.size();
	}
	
//	Para todo
	@Override
	public Boolean existeCancionTriste() {
		Boolean res = false;
		for(Cancion c:canciones) {
			if (c.getSpotifyValence() <= 0.35) {
				res = true;
				break;
			}
		}
		return res;
	}
	
//	Media
	@Override
	public Double getAlegriaMedia() {
		Double valenciaAcSpotify = 0.;
		for(Cancion c:canciones ) {
			valenciaAcSpotify += c.getSpotifyValence();
		}
		Double res = valenciaAcSpotify/canciones.size();
		return res;
	}

//	filtro
	@Override
	public List<Cancion> cancionesDecadaN(Integer n) {
		List<Cancion> res = new ArrayList<>();
		for(Cancion c:canciones) {
			if(c.getDecade().equals(n)) res.add(c);
		}
		return res;
	}
	
//	Maps
	@Override
	public Map<Integer, List<Cancion>> getCancionesPorDecada() {
		Map<Integer, List<Cancion>> res = new HashMap<>();
		for(Cancion c:canciones) {
			Integer decada = c.getDecade();
			if(res.containsKey(decada)) {
				res.get(decada).add(c);
			} else {
				List<Cancion> listaCanciones = new ArrayList<>();
				listaCanciones.add(c);
				res.put(decada, listaCanciones);
			}
		}
		return res;
	}
	
	@Override
	public Map<String, Integer> getNumCancionesPorPais(){
		Map<String, Integer> res = new HashMap<>();
		for(Cancion c:canciones) {
			String pais = c.getCountry();
			if(res.containsKey(pais)) {
				Integer ac = res.get(pais);
				ac += 1;
				res.put(pais, ac);
			} else {
				Integer ac = 1;
				res.put(pais, ac);
			}
		}
		return res;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//	
//	Estos metodos serian los que necesitan stream para ser operativos, y ya estarian resueltos en AlbumStream, por tanto aqui quedan con el return null
	@Override
	public Cancion getMejorCancionDecadaN(Integer n) {
		return null;
	}

	@Override
	public List<Cancion> getCancionesDelPaisOrdenadasPorValenciaSpotify(String pais) {
		return null;
	}

	@Override
	public Double getMediaValenciaSpotifyDecadaN(Integer n) {
		return null;
	}

	@Override
	public Map<String, Cancion> getValenciaSpotifyMaxPorPais() {
		return null;
	}

	@Override
	public SortedMap<String, List<String>> getNCancionesMasAlegresPorPais(Integer n) {
		return null;
	}

	@Override
	public Alegria getTipoAlegriaMasFrecuente() {
		return null;
	}
	
}

