package fp.musica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaCancion {

	public static Cancion parseCancion(String s) {
		Cancion res = null;
		Checkers.checkNoNull(s);
		String[] trozos = s.split(";");
		Checkers.check("Formato csv no valido", trozos.length == 8);
		String name = trozos[0].trim();
		String artist = trozos[1].trim();
		Integer decade = Integer.valueOf(trozos[2].trim());
		Integer rank = Integer.valueOf(trozos[3].trim());
		Integer valence = Integer.valueOf(trozos[4].trim());
		Integer durationMS = Integer.valueOf(trozos[5].trim());
		String country = trozos[6].trim();
		LocalDate releaseDate = LocalDate.parse(trozos[7].trim(), DateTimeFormatter.ofPattern("dd/M/yyyy"));
		res = new Cancion(name,  artist, decade, rank, valence, durationMS, country, releaseDate);
		return res;
	}
	
	public static AlbumStream leeCanciones(String fichero){
		AlbumStream res = new AlbumStream();
		List<String> lineas = Ficheros.leeFichero("Error abriendo fichero", fichero);
		if(lineas.size()>1)	{
			lineas.remove(0);
			for(String l:lineas) {
				Cancion c = parseCancion(l);
				res.anadirCancion(c);
			}
		}
		return res;
	}
	
}
