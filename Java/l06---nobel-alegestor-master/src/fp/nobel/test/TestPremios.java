package fp.nobel.test;

import fp.nobel.FactoriaNobel;
import fp.nobel.Genero;
import fp.nobel.Premio;
import fp.nobel.Premios;

public class TestPremios {
	
	private static void testObtenerPremiosDeGenero(Premios premios) {
		System.out.println("\ntestObtenerPremiosDeGenero");
		try {
			System.out.println("Genero masculino");
			for(Premio p:premios.obtenerPremiosDeGenero(Genero.male)) {
				System.out.println("   " + p.getNombre() + p.getCategoria());
			}
			System.out.println("Genero femenino");
			for(Premio p:premios.obtenerPremiosDeGenero(Genero.female)) {
				System.out.println("   " + p.getNombre() + p.getCategoria());
			}
		} catch (Exception e) {
			System.err.println("Error");
		}
	}
	
	private static void testCalcularMediaPorCategoria(Premios premios) {
		System.out.println("\n\ntestCalcularMediaPorCategoria");
		try {
			System.out.println(premios.calcularMediaEdadPorCategoria());
		} catch (Exception e) {
			System.err.println("Error");
		}
	}

	public static void main(String[] args) {
		Premios premios = FactoriaNobel.leerPremios("data/nobel_prizes.csv");
		System.out.println(premios);
		
		testObtenerPremiosDeGenero(premios);
		testCalcularMediaPorCategoria(premios);
	}

}
