package fp.tipos;

import java.time.Duration;
import java.time.LocalDate;

public class CancionImpl implements Cancion {
//	Atributos
	private String titulo;
	private String artista;
	private Duration duracion;
	private LocalDate fechaLanzamiento;
	private Genero genero;
	
//	Constructor
	public CancionImpl(String titulo, String artista, Duration duracion, LocalDate fechaLanzamiento, Genero genero) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
		this.fechaLanzamiento = fechaLanzamiento;
		this.genero = genero;
	}

//	Getters
	@Override
	public String getTitulo() {
		return titulo;
	}

	@Override
	public String getArtista() {
		return artista;
	}

	@Override
	public Duration getDuracion() {
		return duracion;
	}

	@Override
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	@Override
	public Genero getGenero() {
		return genero;
	}

	@Override
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}

	@Override
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	@Override
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	//	toString
	public String toString() {
		Integer minutos = duracion.toMinutesPart();
		Integer segundos = duracion.toSecondsPart();
		String res = String.format("%s(%s) %2d:%2d", getTitulo(), getArtista(), minutos, segundos);
		return res;
	}
	
	
}
