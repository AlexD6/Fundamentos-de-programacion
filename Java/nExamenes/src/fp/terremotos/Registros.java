package fp.terremotos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Registros {

	private List<Registro> registros;
	
	public Registros() {
		this.registros = new ArrayList<>();
	}

	public Registros(Stream<Registro> registros) {
		this.registros = registros.collect(Collectors.toList());
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

	@Override
	public String toString() {
		return "Registros [registros=" + registros + "]";
	}
	
	public Integer getNumRegistros() {
		return registros.size();
	}
	
//	Ejercicio A
	public Set<String> getCiudadesIntensidadMayorEnAnyo(Double umbralRichter, Integer anyo){
		return this.registros.stream().filter(r -> anyo.equals(r.getFecha().getYear()) && umbralRichter < r.getRichter()).map(Registro::getCiudad)
				.collect(Collectors.toSet());
	}
	
//	Ejercicio B
	public Double calcularPromedioRichterConjuntoCiudades(Set<String> ciudades) {
		return this.registros.stream().filter(r -> ciudades.contains(r.getCiudad())).collect(Collectors.averagingDouble(Registro::getRichter));
	}
	
//	Ejercicio C
	public Map<String, List<Coordenadas>> getCoordenadasPorCiudad(){
		return this.registros.stream().collect(Collectors.groupingBy(Registro::getCiudad, Collectors.mapping(Registro::getCoordenadas, Collectors.toList())));
	}
	
//	Ejercicio D
	public Map<String, Coordenadas> getCoordenadasMediasPorCiudad(){
		Map<String, List<Coordenadas>> map = getCoordenadasPorCiudad();
		return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> getCoordenadasMedias(e.getValue())));
	}
	
	private Coordenadas getCoordenadasMedias(List<Coordenadas> l) {
		Double lat = l.stream().collect(Collectors.averagingDouble(Coordenadas::getLatitud));
		Double lon = l.stream().collect(Collectors.averagingDouble(Coordenadas::getLongitud));
		return new Coordenadas(lat, lon);
	}
	
//	Ejercicio E
	public String getCiudadMasTerremotosNMayores(Integer n) {
		return this.registros.stream().sorted(Comparator.comparing(Registro::getRichter).reversed()).limit(n)
				.collect(Collectors.groupingBy(Registro::getCiudad, Collectors.counting()))
				.entrySet().stream().max(Comparator.comparing(x -> x.getValue())).get().getKey();
	}
	
//	Ejercicio F
	public Double getMediaDiasEntreTerremotosCiudad(String ciudad) {
		Double res = 0.;
		List<LocalDate> fechas = registros.stream().sorted(Comparator.comparing(Registro::getFecha)).map(Registro::getFecha).collect(Collectors.toList());
		Double suma = 0.;
		
		for(int i=0; i<fechas.size(); i++) {
			long dif = fechas.get(i).until(fechas.get(i+1), ChronoUnit.DAYS);
			suma = suma + dif;
		}
		
		if(fechas.size()-1 > 0) {
			res = suma/(fechas.size()-1);
		}
		
		return res;
	}
	
}
