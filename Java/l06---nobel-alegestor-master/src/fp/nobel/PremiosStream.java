package fp.nobel;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PremiosStream implements Premios{

	private Set<Premio> premios;
	
	public PremiosStream() {
		this.premios = new HashSet<>();
	}
	
	public PremiosStream(Stream<Premio> premios) {
		this.premios = premios.collect(Collectors.toSet());
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
		if (!(obj instanceof PremiosStream))
			return false;
		PremiosStream other = (PremiosStream) obj;
		if (premios == null) {
			if (other.premios != null)
				return false;
		} else if (!premios.equals(other.premios))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PremiosStream [premios=" + premios + "]";
	}

	@Override
	public void anadirPremio(Premio p) {
		premios.add(p);
	}

	@Override
	public Set<Premio> obtenerPremiosDeGenero(Genero g) {
		return premios.stream().filter(p -> p.getGenero().equals(g)).collect(Collectors.toSet());
	}

	@Override
	public Integer calcularNumeroPremiadosMasJovenesDe(Integer n) {
		Long res = premios.stream().filter(p -> p.getEdadPremiado()<n).count();
		return res.intValue();
	}

	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		// TODO Auto-generated method stub
		return premios.stream().collect(Collectors.groupingBy(Premio::getCategoria, Collectors.averagingInt(Premio::getEdadPremiado)));
	}



}
