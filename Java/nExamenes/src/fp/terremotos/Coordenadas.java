package fp.terremotos;

public class Coordenadas implements Comparable<Coordenadas>{

	private Double latitud;
	private Double longitud;
	
	public Coordenadas() {
	}

	public Coordenadas(Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Coordenadas))
			return false;
		Coordenadas other = (Coordenadas) obj;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordenadas [latitud=" + latitud + ", longitud=" + longitud + "]";
	}

	@Override
	public int compareTo(Coordenadas c) {
		int res;
		res = this.latitud.compareTo(c.getLatitud());
		if(res == 0) res = this.longitud.compareTo(c.getLongitud());
		return res;
	}

	

}
