package fp.aeropuerto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Vuelo implements Comparable<Vuelo> {
	private LocalDate fecha;
	private LocalTime horaPlanificada;
	private String codigo;
	private String ciudad;
	private String codigoAeropuerto;
	private String compania;
	private String modelo;
	private String idAvion;
	private EstadoVuelo estado;
	private LocalTime horaEfectiva;
	private DireccionVuelo direccion;

	public Vuelo(LocalDate fecha, LocalTime horaPlanificada, String codigo, String ciudad, String codigoAeropuerto, String compania, String modelo, String idAvion, EstadoVuelo estado, LocalTime horaEfectiva, DireccionVuelo direccion) {
		this.fecha = fecha;
		this.horaPlanificada = horaPlanificada;
		this.codigo = codigo;
		this.ciudad = ciudad;
		this.codigoAeropuerto = codigoAeropuerto;
		this.compania = compania;
		this.modelo = modelo;
		this.idAvion = idAvion;
		this.estado = estado;
		this.horaEfectiva = horaEfectiva;
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHoraPlanificada() {
		return horaPlanificada;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getCodigoAeropuerto() {
		return codigoAeropuerto;
	}

	public String getCompania() {
		return compania;
	}

	public String getModelo() {
		return modelo;
	}

	public String getIdAvion() {
		return idAvion;
	}

	public EstadoVuelo getEstado() {
		return estado;
	}

	public LocalTime getHoraEfectiva() {
		return horaEfectiva;
	}

	public DireccionVuelo getDireccion() {
		return direccion;
	}
	
	public Long getDiferenciaMinutos() {
		return getHoraEfectiva() == null ? null : getHoraPlanificada().until(getHoraEfectiva(), ChronoUnit.MINUTES);
	}
	
	public int hashCode(){
		return this.getCodigo().hashCode() + this.getFecha().hashCode() * 31 + this.getHoraPlanificada().hashCode() * 31 * 31;
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof Vuelo){
			Vuelo v = (Vuelo) o;
			res = this.getCodigo().equals(v.getCodigo()) && this.getFecha().equals(v.getFecha()) && this.getHoraPlanificada().equals(v.getHoraPlanificada());
		}
		return res;
	}
	
	public int compareTo(Vuelo v){
		int res = this.getFecha().compareTo(v.getFecha());
		if (res == 0){
			res = this.getHoraPlanificada().compareTo(v.getHoraPlanificada());
			if (res == 0){
				res = this.getCodigo().compareTo(v.getCodigo());
			}
		}
		return res;
	}

	public String toString() {
		return "Código: " + getCodigo() + ", Fecha: " + getFecha() + ", Hora planificada: " + getHoraPlanificada();
	}
}
