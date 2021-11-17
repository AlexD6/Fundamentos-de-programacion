package fp.utiles;

public class Validators {
/**
* @param cad -> cadena de caracteres
* @return true -> si se cumple la condidicion del if
*         false -> si no lo hace
**/
	public static Boolean sonLetras(String cad) {
//		Esquema para todo
		Boolean res = true;
		for (int i=0; i<cad.length(); i++) {
			if(!Character.isLetter(cad.charAt(i))) {
				res = false;
				break;
			}
		}
		return res;
	}
	
	public static Boolean sonNumeros(String cad) {
		Boolean res = true;
		for (int i=0; i<cad.length(); i++) {
			if(!Character.isDigit(cad.charAt(i))) {
				res = false;
				break;
			}
		}
		return res;
	}
}
