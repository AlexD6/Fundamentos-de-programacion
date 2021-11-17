package fp.nobel;

import java.util.Map;
import java.util.Set;

public interface Premios {

//	int hashCode();
//
//	boolean equals(Object obj);
//
//	String toString();

	void anadirPremio(Premio p);

	Set<Premio> obtenerPremiosDeGenero(Genero g);

	Integer calcularNumeroPremiadosMasJovenesDe(Integer n);

	Map<String, Double> calcularMediaEdadPorCategoria();

}