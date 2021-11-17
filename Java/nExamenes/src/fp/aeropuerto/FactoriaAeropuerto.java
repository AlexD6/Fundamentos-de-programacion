package fp.aeropuerto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaAeropuerto {

	public static Aeropuerto leerVuelosConstructor1(String rutaFichero) {
		Aeropuerto res = new Aeropuerto();
		try {
			Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaAeropuerto::parsearVuelo).forEach(v -> res.anadirVuelo(v));
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	public static Aeropuerto leerVuelosConstructor2(String rutaFichero) {
		Aeropuerto res = null;
		try {
			Stream<Vuelo> s = Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaAeropuerto::parsearVuelo);
			res = new Aeropuerto(s);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}

	private static Vuelo parsearVuelo(String linea) {
		Checkers.checkNoNull(linea);
		String[] trozos = linea.split(",");
		String msg = String.format("Formato no válido : <%s>", linea); 
		Checkers.check(msg, trozos.length == 11);
		LocalDate fecha = LocalDate.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("d/M/yyyy"));
		LocalTime horaPlanificada = LocalTime.parse(trozos[1].trim(),DateTimeFormatter.ofPattern("k:m"));
		String codigo = trozos[2].trim();
		String ciudad = trozos[3].trim();
		String codigoAeropuerto = trozos[4].trim();
		String compania = trozos[5].trim();
		String modelo = trozos[6].trim();
		String idAvion = trozos[7].trim();
		EstadoVuelo estado = EstadoVuelo.valueOf(trozos[8].trim().toUpperCase());
		LocalTime horaEfectiva = parsearHoraNula(trozos[9].trim());
		DireccionVuelo direccion = DireccionVuelo.valueOf(trozos[10].trim().toUpperCase());
		return new Vuelo(fecha, horaPlanificada, codigo, ciudad, codigoAeropuerto, compania, modelo, idAvion, estado, horaEfectiva, direccion);
	}
	
	private static LocalTime parsearHoraNula(String str) {
		return str.equals("null") ? null : LocalTime.parse(str,DateTimeFormatter.ofPattern("k:m"));
	}

}
