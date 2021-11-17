package fp.tipos.test;

import java.util.ArrayList;
import java.util.List;

import fp.tipos.Beca;
import fp.tipos.BecaImpl;
import fp.tipos.TipoBeca;

public class TestBeca {

	public static void main(String[] args) {
		try {
			List<Beca> becas = new ArrayList<Beca>();
			System.out.println(becas.get(0));
			Beca b1 = new BecaImpl("ABB2024", TipoBeca.MOVILIDAD);
			System.out.println(b1);
			Beca b3 = null;
			System.out.println(b3.getCodigo());
			Beca b2 = new BecaImpl("AC2024",3000.0, 2, TipoBeca.ORDINARIA);
			System.out.println(b2);
		} catch(IllegalArgumentException e) {
			System.err.println("Se ha producido un error");
		} catch(NullPointerException n) {
			System.err.println("Error de nullpointer");
		} catch(Exception ee) { // Captura cualquier exception
			System.out.println("Error generico");
			ee.printStackTrace(); // Muestra donde esta el error
		} finally { // Se va a ejecutar siempre
			System.out.println("Entramos en finally");
		}
		System.out.println("Programa terminado");
	}
}
