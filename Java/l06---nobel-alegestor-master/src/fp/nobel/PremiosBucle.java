package fp.nobel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PremiosBucle implements Premios {

	private Set<Premio> premios;
	
	public PremiosBucle() {
		this.premios = new HashSet<>();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((premios == null) ? 0 : premios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PremiosBucle))
			return false;
		PremiosBucle other = (PremiosBucle) obj;
		if (premios == null) {
			if (other.premios != null)
				return false;
		} else if (!premios.equals(other.premios))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PremiosBucle [premios=" + premios + "]";
	}

	@Override
	public void anadirPremio(Premio p) {
		this.premios.add(p);
	}
	
	@Override
	public Set<Premio> obtenerPremiosDeGenero(Genero g){
		Set<Premio> res = new HashSet<>();
		for(Premio p:premios) {
			if(p.getGenero().equals(g)) res.add(p);
		}
		return res;
	}
	
	@Override
	public Integer calcularNumeroPremiadosMasJovenesDe(Integer n) {
		Integer res = 0;
		for(Premio p:premios) {
			if(p.getEdadPremiado()<n) res += 1;
		}
		return res;
	}
	
	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		Map<String, Double> res = new HashMap<>();
		Map<String, List<Integer>> edadesCategoria = calcularEdadesPorCategoria();
		for(String e:edadesCategoria.keySet()) {
			res.put(e, calcularMediaEdades(edadesCategoria.get(e)));
		}
		return res;
	}
	
	private Double calcularMediaEdades(List<Integer> edades) {
		Double res = 0.;
		for(Integer e:edades) {
			res += e;
		}
		if(edades.size()>0)res = res/edades.size();
		return res;
	}

	private Map<String, List<Integer>> calcularEdadesPorCategoria() {
		Map<String, List<Integer>> res = new HashMap<>();
		for(Premio p:premios) {
			String catActual = p.getCategoria();
			if(res.containsKey(catActual)) { // Resto de veces
				res.get(catActual).add(p.getEdadPremiado());
			} else { // Primera vez
				List<Integer> valores = new ArrayList<>();
				valores.add(p.getEdadPremiado());
				res.put(catActual, valores);
			}
		}
		return res;
	}
	
}
