package fp.barcos;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccidenteNaval {
	
	private SortedSet<PasajeroBarco> pasajeros;

	public AccidenteNaval() {
		this.pasajeros = new TreeSet<>();
	}
	
	public AccidenteNaval(Stream<PasajeroBarco> pasajeros) {
		this.pasajeros = pasajeros.collect(Collectors.toCollection(TreeSet::new));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pasajeros == null) ? 0 : pasajeros.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AccidenteNaval))
			return false;
		AccidenteNaval other = (AccidenteNaval) obj;
		if (pasajeros == null) {
			if (other.pasajeros != null)
				return false;
		} else if (!pasajeros.equals(other.pasajeros))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccidenteNaval [pasajeros=" + pasajeros + "]";
	}
	
//	Ejercicio A
	public Double getEdadMediaPorDebajoDe(Boolean superviviente, Integer limite) {
		return this.pasajeros.stream().filter(p -> p.getSuperviviente().equals(superviviente) && p.getEdad() <= limite)
				.collect(Collectors.averagingDouble(PasajeroBarco::getEdad));
	}
	
//	Ejercicio B
	public String getCiudadEmbarqueConMayorPrecio() {
		return this.pasajeros.stream().sorted(Comparator.comparing(PasajeroBarco::getPrecioTicket).reversed()).findFirst().get().getCiudadEmbarque();
	}
	
//	Ejercicio C
	public Map<Integer, Long> getNumeroVictimasMenoresDePorEdad(Integer edad){
		return this.pasajeros.stream().filter(p -> p.getEdad() <= edad).collect(Collectors.groupingBy(PasajeroBarco::getEdad, Collectors.counting()));
	}
	
//	Ejercicio D
	public Map<String, Double> getPorcentajeSupervivientesPorCiudadEmbarque(){
		return this.pasajeros.stream().collect(Collectors.groupingBy(PasajeroBarco::getCiudadEmbarque, 
				Collectors.collectingAndThen(Collectors.mapping(PasajeroBarco::getSuperviviente, 
						Collectors.toList()), p -> 100.*Collections.frequency(p, true)/p.size())));
	}
	
//	Ejercicio E
	public Double getMedianaPrecioTicket(Boolean superviviente) {
		Long contador = pasajeros.stream().filter(p -> p.getSuperviviente().equals(superviviente)).count();
		return this.pasajeros.stream().filter(p -> p.getSuperviviente().equals(superviviente)).map(PasajeroBarco::getPrecioTicket).sorted()
				.skip(contador/2).findFirst().get();
	}
	
//	Ejercicio F
	public SortedMap<String, SortedSet<PasajeroBarco>> getParejasPorFuncion(Function<PasajeroBarco, String> extractorIdPareja){
		return new TreeMap<>(pasajeros.stream().collect(Collectors.groupingBy(extractorIdPareja, 
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(PasajeroBarco::getSexo)))))
				.entrySet().stream().filter(e -> e.getValue().size()==2).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
