package fp.terremotos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public class RegistrosFact {

	public Registro parsearRegistro(String linea) {
		String[] trozos = linea.split(",");
		Checkers.check("Tiene que haber 5 trozos", trozos.length == 5);
		LocalDate fecha = LocalDate.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("yyyy.M.d"));
		Double latitud = Double.valueOf(trozos[1].trim());
		Double longitud = Double.valueOf(trozos[2].trim());
		Coordenadas coordenadas = new Coordenadas(latitud, longitud);
		String ciudad = trozos[3].trim();
		Double richter = Double.valueOf(trozos[4].trim());
		return new Registro(fecha, coordenadas, ciudad, richter);
	}
	
}
