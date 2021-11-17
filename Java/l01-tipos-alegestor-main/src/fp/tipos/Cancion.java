package fp.tipos;

import java.time.Duration;
import java.time.LocalDate;

public interface Cancion {
//	Getters
	String getTitulo();
	String getArtista();
	Duration getDuracion();
	LocalDate getFechaLanzamiento();
	Genero getGenero();

//	Setters
	void setTitulo(String titulo);
	void setArtista(String artista);
	void setDuracion(Duration duracion);
	void setFechaLanzamiento(LocalDate fechaLanzamiento);
	void setGenero(Genero genero);

}