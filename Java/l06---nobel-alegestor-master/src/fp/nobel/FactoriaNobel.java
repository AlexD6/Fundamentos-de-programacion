package fp.nobel;

import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaNobel {

	private static Premio parsearPremio(String s) {
		Premio res = null;
		Checkers.checkNoNull(s);
		String[] trozos = s.split(",");
		Checkers.check("Formato csv no valido", trozos.length == 6);
		Integer anyo = Integer.valueOf(trozos[0].trim());
		String categoria = trozos[1].trim();
		String nombre = trozos[2].trim();
		String apellidos = trozos[3].trim();
		Genero genero = Genero.valueOf(trozos[4].trim());
		Integer anyoNacimiento = Integer.valueOf(trozos[5].trim());
		res = new Premio(anyo, categoria, nombre, apellidos, genero, anyoNacimiento);
		return res;
	}
	
	public static Premios leerPremios(String fichero) {
		PremiosBucle res = new PremiosBucle();
		List<String> lineas = Ficheros.leeFichero("Error abriendo fichero", fichero);
		if(lineas.size()>1) {
			lineas.remove(0);
			for(String l:lineas) {
				Premio p = parsearPremio(l);
				res.anadirPremio(p);
			}
		}
		return res;
		
	}
	
}
