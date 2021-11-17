package fp.nobel;

import fp.utiles.Checkers;

public class Premio {

	private Integer anyo;
	private String categoria;
	private String nombre;
	private String apellidos;
	private Genero genero;
	private Integer anyoNacimiento;
	
	public Premio(Integer anyo, String categoria, String nombre, String apellidos, Genero genero, Integer anyoNacimiento) {
		Checkers.check("El año de nacimiento tiene que ser menor que el año del premio", anyoNacimiento < anyo);
		this.anyo = anyo;
		this.categoria = categoria;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.anyoNacimiento = anyoNacimiento;
	}

	public Integer getAnyo() {
		return anyo;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Genero getGenero() {
		return genero;
	}

	public Integer getAnyoNacimiento() {
		return anyoNacimiento;
	}
	
	public Integer getEdadPremiado() {
		return this.anyo - this.anyoNacimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anyo == null) ? 0 : anyo.hashCode());
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Premio))
			return false;
		Premio other = (Premio) obj;
		if (anyo == null) {
			if (other.anyo != null)
				return false;
		} else if (!anyo.equals(other.anyo))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Premio [anyo=" + anyo + ", categoria=" + categoria + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero 
				+ ", anyoNacimiento=" + anyoNacimiento + "]";
	}


	
}
