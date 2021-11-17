package fp.musica.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.musica.AlbumStream;
import fp.musica.Cancion;
import fp.musica.FactoriaCancion;

public class TestAlbum {
	
	private static final AlbumStream CANCIONES = FactoriaCancion.leeCanciones("./data/Top20DecadasDefinitivo.csv");

	public static void main(String[] args) {
		testMuestraCanciones();
		
		testAnadirCancion();
		testAnadirCanciones();
		testEliminaCancion();
		testExisteCancionTriste();
		testGetAlegriaMedia();
		testCancionesDecadaN();
		testGetCancionesPorDecada();
		testGetNumCancionesPorPais();
		
		testGetMejorCancionDecadaN();
		testGetCancionesDelPaisOrdenadasPorValenciaSpotify();
		testGetMediaValenciaSpotifyDecadaN();
		testGetValenciaSpotifyMaxPorPais();
		testGetNCancionesMasAlegresPorPais();
		testGetTipoAlegriaMasFrecuente();
	}

	private static void testMuestraCanciones() {
		System.out.println("testMuestraCanciones: ");
		try {
			System.out.println("   " + CANCIONES);
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testAnadirCancion() {
		System.out.println("testAnadirCancion: ");
		try {
			Cancion prueba1 = new Cancion("Prueba1", "Prueba1",60, 1, 937, 153760, "Pruebas", LocalDate.of(2015, 11, 13));
			CANCIONES.anadirCancion(prueba1);
			System.out.println("  " + CANCIONES);
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testAnadirCanciones() {
		System.out.println("testAnadirCanciones: ");
		try {
			Cancion prueba2 = new Cancion("Prueba2", "Prueba2",60, 1, 937, 153760, "Pruebas", LocalDate.of(2015, 11, 13));
			Cancion prueba3 = new Cancion("Prueba3", "Prueba3",60, 1, 937, 153760, "Pruebas", LocalDate.of(2015, 11, 13));
			List<Cancion> prueba = new ArrayList<>();
			prueba.add(prueba2);
			prueba.add(prueba3);
			CANCIONES.anadirCanciones(prueba);
			System.out.println("  " + CANCIONES);
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testEliminaCancion() {
		System.out.println("testEliminaCancion: ");
		try {
			Cancion prueba2 = new Cancion("Prueba2", "Prueba2",60, 1, 937, 153760, "Pruebas", LocalDate.of(2015, 11, 13));
			CANCIONES.eliminaCancion(prueba2);
			System.out.println("  " + CANCIONES);
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testExisteCancionTriste() {
		System.out.println("testExisteCancionTriste: ");
		try {
			System.out.println("  " + CANCIONES.existeCancionTriste());
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testGetAlegriaMedia() {
		System.out.println("testGetAlegriaMedia: ");
		try {
			System.out.println("  " + CANCIONES.getAlegriaMedia());
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testCancionesDecadaN() {
		Integer n = 70;
		System.out.println(String.format("testCancionesDecada%d: ", n));
		try {
			for(int i=0; i<CANCIONES.getNumCanciones(); i++) {
			System.out.println("  " + CANCIONES.cancionesDecadaN(n).get(i));
			if (i == 19) break;
			}
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testGetCancionesPorDecada() {
		System.out.println("testGetCancionesPorDecada:");
		try {
			System.out.println("  " + CANCIONES.getCancionesPorDecada());
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testGetNumCancionesPorPais() {
		System.out.println("testGetNumCancionesPorPais:");
		try {
			System.out.println("  " + CANCIONES.getNumCancionesPorPais());
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	private static void testGetMejorCancionDecadaN() {
		System.out.println("testGetMejorCancionDecadaN:");
		try {
			System.out.println("  " + CANCIONES.getMejorCancionDecadaN(80));
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}

	private static void testGetCancionesDelPaisOrdenadasPorValenciaSpotify() {
		System.out.println("testGetCancionesDelPaisOrdenadasPorValenciaSpotify:");
		try {
			System.out.println("  " + CANCIONES.getCancionesDelPaisOrdenadasPorValenciaSpotify("United States"));
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	private static void testGetMediaValenciaSpotifyDecadaN() {
		System.out.println("testGetMediaValenciaSpotifyDecadaN:");
		try {
			System.out.println("  " + CANCIONES.getMediaValenciaSpotifyDecadaN(90));
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	private static void testGetValenciaSpotifyMaxPorPais() {
		System.out.println("testGetValenciaSpotifyMaxPorPais:");
		try {
			System.out.println("  " + CANCIONES.getValenciaSpotifyMaxPorPais());
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	private static void testGetNCancionesMasAlegresPorPais() {
		System.out.println("testGetNCancionesMasAlegresPorPais:");
		try {
			System.out.println("  " + CANCIONES.getNCancionesMasAlegresPorPais(3));
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	private static void testGetTipoAlegriaMasFrecuente() {
		System.out.println("testGetTipoAlegriaMasFrecuente:");
		try {
			System.out.println("  " + CANCIONES.getTipoAlegriaMasFrecuente());
		} catch(Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		System.out.println("");
	}
	
}
