package fp.tipos;

import java.util.LinkedList;
import java.util.List;

import fp.utiles.Checkers;

public class AlbumImpl {
//	Atributos
	private String nombre;
	private String id;
	private Integer popularidad;
	private Integer a�oPublicacion;
	private TipoAlbum tipo;
	private List<Cancion> canciones;
	private List<String> imagenes;
	
//	Constructor
	public AlbumImpl(String nombre, String id, Integer popularidad, Integer a�oPublicacion, TipoAlbum tipo) {
		super();
		this.nombre = nombre;
//		checkId(id);
		Checkers.check("Id de longitud incorrecta", !(id.length() == 22));
		this.id = id;
		checkPopularidad(popularidad);
		this.popularidad = popularidad;
		this.a�oPublicacion = a�oPublicacion;
		this.tipo = tipo;
		canciones = new LinkedList<Cancion>();
		imagenes = new LinkedList<String>();
	}

//	private void checkId(String id) {
//		if(!(id.length() == 22)) {
//			throw new IllegalArgumentException("Id de longitud incorrecta");
//		}
//	}
//
	private void checkPopularidad(Integer popularidad) {
		Checkers.check("Popularidad incorrecta", !(popularidad >= 0 && popularidad <= 100));
//		if(!(popularidad >= 0 && popularidad <= 100)) {
//			throw new IllegalArgumentException("popularidad incorrecta");
//		}	
	}

//	Getters
	public String getNombre() {
		return nombre;
	}

	public String getId() {
		return id;
	}

	public Integer getPopularidad() {
		return popularidad;
	}

	public Integer getA�oPublicacion() {
		return a�oPublicacion;
	}

	public TipoAlbum getTipo() {
		return tipo;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public List<String> getImagenes() {
		return imagenes;
	}
	
//	Setters
	public void setPopularidad(Integer popularidad) {
		checkPopularidad(popularidad);
		this.popularidad = popularidad;
	}

	//	toString
	public String toString() {
		return String.format("%s (%s)", getNombre(), getId());
	}
}
