package fp.musica.test;

import java.time.LocalDate;

import fp.musica.Cancion;

public class TestCancion {
	public static void main(String[] args) {
		try {
//			Cancion c1 = new Cancion("Lost in the Echo", "Linkin Park");
//			System.out.println(c1);
			Cancion c2 = new Cancion("The Twist","Chubby Checker",60,1,937,153760,"United States",LocalDate.of(1960, 05, 11));
			System.out.println(c2);
		} catch(Exception e) { // Captura cualquier exception
			System.out.println("Error");
			e.printStackTrace(); // Muestra donde esta el error
		System.out.println("Programa terminado");
		}
	}
}
