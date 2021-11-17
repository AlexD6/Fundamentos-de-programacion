package fp.eolo;

import java.time.LocalDate;

import fp.utiles.Checkers;

public class Registro implements Comparable<Registro>{
	
	private LocalDate fecha;
	private String ciudad;
	private Double direccion;
	private Double velocidad;
	private Double velocidadMax;
	
	public Registro(LocalDate fecha, String ciudad, Double direccion, Double velocidad, Double velocidadMax) {
		Checkers.check("La velocidad maxima no puede superar a la media", velocidad <= velocidadMax);
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.velocidad = velocidad;
		this.velocidadMax = velocidadMax;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Double getDireccion() {
		return direccion;
	}

	public Double getVelocidad() {
		return velocidad;
	}

	public Double getVelocidadMax() {
		return velocidadMax;
	}
	
	public Integer getDia() {
		return this.fecha.getDayOfMonth();
	}
	
	public Integer getMes() {
		return this.fecha.getMonthValue();
	}
	
	public Integer getAnyo() {
		return this.fecha.getYear();
	}
	
	public Viento getViento() {
		Viento res = null;
		if (this.direccion > 135. && this.direccion <= 225.) {
			res = Viento.SUR;
		} else if (this.direccion > 225. && this.direccion <= 315.) {
			res = Viento.PONIENTE;
		} else if (this.direccion > 315. || this.direccion <= 45.) {
			res = Viento.NORTE;
		} else if (this.direccion > 45. && this.direccion <= 135.) {
			if (this.velocidadMax <= 3) {
				res = Viento.LEVANTICHON;
			} else {
				res = Viento.LEVANTE;
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return "Registro [fecha=" + fecha + ", ciudad=" + ciudad + ", direccion=" + direccion + ", velocidad="
				+ velocidad + ", velocidadMax=" + velocidadMax + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Registro))
			return false;
		Registro other = (Registro) obj;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}

	@Override
	public int compareTo(Registro r) {
		int res;
		if (r == null) throw new NullPointerException();
		res = this.ciudad.compareTo(r.getCiudad());
		if (res == 0) this.fecha.compareTo(r.getFecha());
		return res;
	}
	
	
	
}
