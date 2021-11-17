package fp.eolo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class Registros {
	
	private Set<Registro> registros;

	public Registros() {
		this.registros = new HashSet<Registro>();
	}
	
	public Registros(Stream<Registro> registros) {
		this.registros = registros.collect(Collectors.toSet());
	}
	
	public void anadirRegistro(Registro r) {
		this.registros.add(r);
	}
	
	public Integer getNumeroRegistros() {
		return this.registros.size();
	}

	@Override
	public String toString() {
		return "Registros [registros=" + registros + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registros == null) ? 0 : registros.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Registros))
			return false;
		Registros other = (Registros) obj;
		if (registros == null) {
			if (other.registros != null)
				return false;
		} else if (!registros.equals(other.registros))
			return false;
		return true;
	}
	
	public Set<Registro> calcularRegistrosDeViento(Viento v){
		return this.registros.stream().filter(r -> r.getViento().equals(v)).collect(Collectors.toSet());
	}
	
	public Long calcularDiasDeVientoEnCiudadEnFechas(String ciudad, Viento v, LocalDate fechaIni, LocalDate FechaFin) {
		Checkers.check("La fecha de inicio tiene que ser anterio a fecha de fin", fechaIni.isBefore(FechaFin));
		return registros.stream().filter(r ->r.getCiudad().equals(ciudad) && r.getViento().equals(v) && r.getFecha().isAfter(fechaIni) && 
				r.getFecha().isBefore(FechaFin)).count();
	}
	
	public Set<Registro> obtenerRegistrosMayorVelocidadMaxima(Long n) {
		return this.registros.stream().sorted(Comparator.comparing(Registro::getVelocidadMax).reversed()).limit(n).collect(Collectors.toSet());
	}
	
	public Double calcularPromedioVelocidadEnAnyo(Integer anyo) {
		return this.registros.stream().filter(r -> r.getAnyo().equals(anyo)).mapToDouble(Registro::getVelocidad).average().orElse(0.);
	}
	
	public Map<LocalDate, Double> calcularPromedioVelocidadPorFecha() {
		return this.registros.stream().collect(Collectors.groupingBy(Registro::getFecha, Collectors.averagingDouble(Registro::getVelocidad)));
	}
	
	public List<Double> ordenarVelocidadesPorFecha(Integer n) {
		Map<LocalDate, Double> aux = calcularPromedioVelocidadPorFecha();
		return aux.entrySet().stream().sorted(Comparator.comparing(map -> map.getKey())).map(map -> map.getValue()).limit(n).collect(Collectors.toList());
	}
	
	
	public Map<String, Optional<Registro>> calcularRegistroMayorVelocidadMaximaPorCiudad(){
		return this.registros.stream().collect(Collectors.groupingBy(Registro::getCiudad, Collectors.maxBy(Comparator.comparing(Registro::getVelocidadMax))));
	}
	
	public Viento calcularVientoPredominanteDeCiudad(String ciudad) {
		return this.registros.stream().filter(r -> r.getCiudad().equals(ciudad))
				.collect(Collectors.groupingBy(r -> r.getViento(), Collectors.counting()))
				.entrySet().stream().max(Comparator.comparing(r -> r.getValue())).get().getKey();
	}
	
	public Map<String, Double> calcularPromedioVelocidadPorCiudad(Viento viento){
		return this.registros.stream().filter(r -> r.getViento().equals(viento)).collect(Collectors.groupingBy(Registro:: getCiudad, 
				Collectors.averagingDouble(Registro::getVelocidad)));
	}
	
}
