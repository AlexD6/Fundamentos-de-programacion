package fp.comic;

import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaPersonaje {

	public static Personaje parsePersonaje(String s) {
		Personaje res = null;
		Checkers.checkNoNull(s);
		String[] trozos = s.split(",");
		String nombre = trozos[0].trim();
		String tipo = trozos[1].trim();
		String ojos = trozos[2].trim();
		String pelo = trozos[3].trim();
		String sexo = trozos[4].trim();
		Integer anyoAparicion = Integer.valueOf(trozos[5].trim());
		res = new Personaje(nombre, tipo, ojos, pelo, sexo, anyoAparicion);
		return res;
	}
	
	public static Personajes leerPersonajes(String fichero) {
		Personajes res = new Personajes();
		List<String> lineas = Ficheros.leeFichero("Error abriendo fichero", fichero);
		if(lineas.size()>1) {
			lineas.remove(0);
			for(String l:lineas) {
				Personaje p = parsePersonaje(l);
				res.añadirPersonaje(p);
			}
		}
		return res;
	}
	
}
