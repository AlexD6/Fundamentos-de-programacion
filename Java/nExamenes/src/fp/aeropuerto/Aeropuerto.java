
package fp.aeropuerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aeropuerto {
	
	private SortedSet<Vuelo> vuelos;

	public Aeropuerto() {
		SortedSet<Vuelo> vuelos = new TreeSet<>();
	}
	
	public Aeropuerto(Stream<Vuelo> vuelos) {
		vuelos.collect(Collectors.toCollection(TreeSet::new));
	}
	
	@Override
	public String toString() {
		return "Aeropuerto [vuelos=" + vuelos + "]";
	}

	public Integer getNumVuelos() {
		return this.vuelos.size();
	}
	
	public void anadirVuelo(Vuelo v) {
		this.vuelos.add(v);
	}
	
	public Boolean existeVueloDestino(String ciudad) {
		return this.vuelos.stream().anyMatch(v -> v.getCiudad().equals(ciudad));
	}
	
	public Boolean todosVuelosCompañiaSinRetraso(String compañia) {
		return this.vuelos.stream().filter(v -> v.getCompania().equals(compañia))
				.allMatch(v -> v.getHoraPlanificada().isBefore(v.getHoraEfectiva()) || v.getHoraEfectiva().equals(v.getHoraPlanificada()));
	}
	
	public Long getNumeroVuelosSalida() {
		return this.vuelos.stream().filter(v -> v.getDireccion().equals(DireccionVuelo.OUT)).count();
	}
	
	public Long getNumeroVuelosDestino(String ciudad) {
		return this.vuelos.stream().filter(v -> v.getCiudad().equals(ciudad) && v.getDireccion().equals(DireccionVuelo.OUT)).count();
	}
	
	public Long getNumeroVuelosCancelados() {
		return this.vuelos.stream().filter(v -> v.getEstado().equals(EstadoVuelo.CANCELED)).count();
	}
	
	public Long getNumeroVuelosCompañia(String compañia) {
		return this.vuelos.stream().filter(v -> v.getCompania().equals(compañia)).count();
	}
	
	public Long getNumeroVuelosConRetraso() {
		return this.vuelos.stream().filter(v -> v.getHoraEfectiva().isAfter(v.getHoraPlanificada()) && !v.getEstado().equals(EstadoVuelo.CANCELED)).count();
	}
	
	public Set<String> getCompañiasVuelos(){
		return this.vuelos.stream().map(Vuelo::getCompania).collect(Collectors.toSet());
	}
	
	public Long getNumeroCiudadesDestino() {
		return this.vuelos.stream().filter(v -> v.getDireccion().equals(DireccionVuelo.OUT)).map(Vuelo::getCiudad).distinct().count();
	}
	
	public Set<String> getModelosAvionesCompañia(String compañia){
		return this.vuelos.stream().filter(v -> v.getCompania().equals(compañia)).map(Vuelo::getModelo).collect(Collectors.toSet());
	}
	
	public Long getMinutosRetrasoAcumuladosCompañia(String compañia) {
		return this.vuelos.stream().filter(v -> v.getCompania().equals(compañia) && v.getHoraEfectiva().isAfter(v.getHoraPlanificada()))
				.mapToLong(Vuelo::getDiferenciaMinutos).sum();
	}
	
	public Double getMediaMinutosRetrasoCiudad(String ciudad) {
		return this.vuelos.stream().filter(v -> v.getCiudad().equals(ciudad) && !v.getEstado().equals(EstadoVuelo.CANCELED) && 
				v.getHoraEfectiva().isAfter(v.getHoraPlanificada())).mapToDouble(Vuelo::getDiferenciaMinutos).average().orElse(0.);
	}
	
	public Set<DayOfWeek> getDiasSemanaConVuelosDestino(String ciudad){
		return this.vuelos.stream().filter(v -> v.getCiudad().equals(ciudad)).map(Vuelo::getFecha).map(v -> v.getDayOfWeek()).collect(Collectors.toSet());
	}
	
	public Vuelo getVueloMayorRetraso() {
		return this.vuelos.stream().filter(v -> v.getHoraEfectiva().isAfter(v.getHoraPlanificada()) && v.getEstado().equals(EstadoVuelo.CANCELED)).max(Comparator.comparing(Vuelo::getDiferenciaMinutos)).get();
	}
	
	public Vuelo getVueloMasTempranoDestino(String ciudad) {
		return this.vuelos.stream().filter(v -> v.getCiudad().equals(ciudad)).min(Comparator.comparing(Vuelo::getHoraPlanificada)).get();
	}
	
	public Vuelo getPrimerVueloCompañia(String compañia) {
		return this.vuelos.stream().filter(v -> v.getCompania().equals(compañia)).min(Comparator.comparing(Vuelo::getHoraPlanificada)).get();
	}
	
	public List<String> getPrimerosDestinos(Integer n){
		return this.vuelos.stream().sorted(Comparator.comparing(Vuelo::getFecha).thenComparing(Comparator.comparing(Vuelo::getHoraPlanificada)))
				.limit(n).map(Vuelo::getCiudad).collect(Collectors.toList());
	}
	
	public void desviaVuelosCiudad(String ciudad, String nuevaCiudad) {
		this.vuelos.stream().filter(v -> v.getCiudad().equals(ciudad)).forEach(v -> v.setCiudad(nuevaCiudad));
	}
	
	public Map<String, List<Vuelo>> getVuelosPorCiudad(){
		return this.vuelos.stream().collect(Collectors.groupingBy(Vuelo::getCiudad));
	}
	
	public Map<LocalDate, List<Vuelo>> getVuelosPorFecha() {
		return this.vuelos.stream().collect(Collectors.groupingBy(Vuelo::getFecha));
	}
	
	public Map<String, Set<String>> getModelosPorCompañia(){
		return this.vuelos.stream().collect(Collectors.groupingBy(Vuelo::getCompania, Collectors.mapping(Vuelo::getModelo, Collectors.toSet())));
	}
	
	public Map<String, Long> getNumeroVuelosPorCiudad(){
		return this.vuelos.stream().collect(Collectors.groupingBy(Vuelo::getCiudad, Collectors.counting()));
	}
	
	public Map<String, Integer> getNumeroVuelosConRetrasoPorCompañia(){
		Map<String, List<Vuelo>> mapa = this.vuelos.stream().collect(Collectors.groupingBy(Vuelo::getCompania));
		return mapa.entrySet().stream().collect(Collectors.toMap(x -> x.getKey(), y -> getCantidadVuelosRetrasoCompania(y.getKey())));
	}
////////////////////////////////////////////
	private Integer getCantidadVuelosRetrasoCompania(String compania) {
		return (int) this.vuelos.stream().filter(v -> v.getCompania().equals(compania) && v.getHoraPlanificada().isAfter(v.getHoraEfectiva())).count();
	}
////////////////////////////////////////////
	public SortedMap<Integer, Long> getNumeroSalidasPorHora(){
		return this.vuelos.stream().filter(v -> !v.getEstado().equals(EstadoVuelo.CANCELED) && v.getDireccion().equals(DireccionVuelo.OUT))
				.collect(Collectors.groupingBy(x -> x.getHoraEfectiva().getHour(), TreeMap::new, Collectors.counting()));
	}
	
	public Map<String, Long> getRetrasoAcumuladoPorCompañia(){
		Map<String, List<Vuelo>> mapa = this.vuelos.stream().collect(Collectors.groupingBy(Vuelo::getCompania));
		return mapa.entrySet().stream().collect(Collectors.toMap(x -> x.getKey(), y -> getMinutosRetrasoAcumuladosCompañia(y.getKey())));
	}
	
	public Map<String, Double> getRetrasoMedioPorCompañia(){
		return this.vuelos.stream().filter(v -> v.getHoraEfectiva().isAfter(v.getHoraPlanificada()))
				.collect(Collectors.groupingBy(Vuelo::getCompania, Collectors.averagingDouble(Vuelo::getDiferenciaMinutos)));
	}
	
	public Map<String, Vuelo> getVueloMasRetrasoPorCompañia(){
		return this.vuelos.stream().filter(v -> v.getHoraEfectiva().isAfter(v.getHoraPlanificada()))
				.collect(Collectors.groupingBy(Vuelo::getCompania, 
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Vuelo::getDiferenciaMinutos)), x -> x.get())));
	}
	
	public Map<String, Vuelo> getVueloMasTempranoPorCiudad() {
		return this.vuelos.stream().collect(Collectors.groupingBy(Vuelo::getCiudad, 
				Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Vuelo::getHoraPlanificada)), x -> x.get())));
	}
	
	public Map<String, Double> getPorcentajeVuelosConRetrasoPorCompañia(){
		return this.vuelos.stream().filter(v -> v.getHoraEfectiva().isAfter(v.getHoraPlanificada()))
				.collect(Collectors.groupingBy(Vuelo::getCompania, Collectors.averagingDouble(Vuelo::getDiferenciaMinutos)));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
