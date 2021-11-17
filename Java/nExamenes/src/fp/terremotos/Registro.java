package fp.terremotos;

import java.time.LocalDate;

import fp.utiles.Checkers;

public class Registro implements Comparable<Registro>{

	private LocalDate fecha;
	private Coordenadas coordenadas;
	private String ciudad;
	private Double richter;
	
	public Registro(LocalDate fecha, Coordenadas coordenadas, String ciudad, Double richter) {

		Checkers.check("La magnitud del terremoto debe estar en el intervalo [1.5, 12]", richter >= 1.5 && richter <= 12.);
		Checkers.check("La fecha debe ser anterior o igual al día de hoy", fecha.isBefore(LocalDate.now()) || fecha.isEqual(LocalDate.now()));
		
		this.fecha = fecha;
		this.coordenadas = coordenadas;
		this.ciudad = ciudad;
		this.richter = richter;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Double getRichter() {
		return richter;
	}
	
	public Double getDistancia(Coordenadas c) {
		Double lat = this.coordenadas.getLatitud() - c.getLatitud();
		Double lon = this.coordenadas.getLongitud() - c.getLongitud();
		return Math.sqrt(lat*lat + lon*lon);
	}

	@Override
	public String toString() {
		return "Terremoto [fecha=" + fecha + ", coordenadas=" + coordenadas + ", ciudad=" + ciudad + ", richter="
				+ richter + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenadas == null) ? 0 : coordenadas.hashCode());
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
		if (coordenadas == null) {
			if (other.coordenadas != null)
				return false;
		} else if (!coordenadas.equals(other.coordenadas))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}

	@Override
	public int compareTo(Registro t) {
		int res = this.fecha.compareTo(t.getFecha());
		if (res==0) this.coordenadas.compareTo(t.getCoordenadas());
		return res;
	}
	
	
	
	
}
