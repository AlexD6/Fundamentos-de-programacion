package fp.comic;

import fp.utiles.Checkers;

public class Personaje implements Comparable<Personaje> {

	private String nombre;
	private String tipo;
	private String ojos;
	private String pelo;
	private String sexo;
	private Integer anyoAparicion;
	
	public Personaje(String nombre, String tipo, String ojos, String pelo, String sexo, Integer anyoAparicion) {
		Checkers.check("El año de aparicion debe ser igual o posterior a 1930", anyoAparicion >= 1930);
		this.nombre = nombre;
		this.tipo = tipo;
		this.ojos = ojos;
		this.pelo = pelo;
		this.sexo = sexo;
		this.anyoAparicion = anyoAparicion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getOjos() {
		return ojos;
	}

	public String getPelo() {
		return pelo;
	}

	public String getSexo() {
		return sexo;
	}

	public Integer getAnyoAparicion() {
		return anyoAparicion;
	}
	
	public String getDecada() {
		Integer res = (anyoAparicion/10)*10;
		return res.toString();
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", tipo=" + tipo + ", ojos=" + ojos + ", pelo=" + pelo + ", sexo=" + sexo
				+ ", anyoAparicion=" + anyoAparicion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anyoAparicion == null) ? 0 : anyoAparicion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Personaje))
			return false;
		Personaje other = (Personaje) obj;
		if (anyoAparicion == null) {
			if (other.anyoAparicion != null)
				return false;
		} else if (!anyoAparicion.equals(other.anyoAparicion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Personaje p) {
		int res;
		if(p == null) {
			throw new NullPointerException();
		}
		res = this.getNombre().compareTo(p.getNombre());
		if(res == 0) {
			this.anyoAparicion.compareTo(p.getAnyoAparicion());
		}
		return res;
	}
	
}
