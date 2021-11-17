package fp.barcos;

import fp.utiles.Checkers;

public class Factoria {
	
	public PasajeroBarco parsearRegistro(String linea) {
		String[] trozos = linea.split(";");
		Checkers.check("Tiene que haber 11 trozos", trozos.length == 11);
		Integer id = Integer.valueOf(trozos[0].trim());
		Boolean superviviente = false;
		if(trozos[1] == "1") superviviente = true;
		Integer clase = Integer.valueOf(trozos[2].trim());
		String nombre = trozos[3].trim();
		Sexo sexo = Sexo.valueOf(trozos[4]);
		Integer edad = Integer.valueOf(trozos[5].trim());
		Integer numHermanosOParejaABordo = Integer.valueOf(trozos[6].trim());
		Integer numPadresOHijosABordo = Integer.valueOf(trozos[7].trim());
		Double precioTicket = Double.valueOf(trozos[8].trim());
		String cabina = trozos[9].trim();
		String ciudadEmbarque = trozos[10].trim();
		return new PasajeroBarco(id, superviviente, clase, nombre, sexo, edad,
				numHermanosOParejaABordo, numPadresOHijosABordo, precioTicket, cabina,
				ciudadEmbarque);
	}
	
}
