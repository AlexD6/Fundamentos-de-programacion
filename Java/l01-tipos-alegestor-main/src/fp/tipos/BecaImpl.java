package fp.tipos;

import fp.utiles.Checkers;
import fp.utiles.Validators;

public class BecaImpl implements Beca { // Cuando se usa una clase se usa implements
//	public interface Beca extends Comparable<Beca> // Cuando de usa una interfaz se usa extends	

	private String codigo;
	private Double cuantiaTotal;
	private Integer duracion;
	private TipoBeca tipo;
	private static final Double CUANTIA_MINIMA = 1500.0;
	private static final Integer DURACION_MINIMA = 1;
	
	public BecaImpl(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		Checkers.check("formato de codigo incorrecto", esCodigoOK(codigo));
		this.codigo = codigo;
		setCuantiaTotal(cuantiaTotal); //Cuando hay un set, se puede colocar el set, ya que el set tambien incluye la restriccion, asi se queda el codigo mas limpio
		setDuracion(duracion);
		this.tipo = tipo;
	}
	
	public BecaImpl(String codigo, TipoBeca tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	private Boolean esCodigoOK(String codigo) {
		return codigo.length() == 7 && Validators.sonLetras(codigo.substring(0, 4)) // [0,4)
				&& Validators.sonNumeros(codigo.substring(4)); //[4,...)
	}
	
	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public Double getCuantiaTotal() {
		return cuantiaTotal;
	}

	@Override
	public Integer getDuracion() {
		return duracion;
	}

	@Override
	public TipoBeca getTipo() {
		return tipo;
	}
	@Override
	public void setCuantiaTotal(Double cuantiaTotal) {
		Checkers.check("Comprobador de cuantia", cuantiaTotal >= CUANTIA_MINIMA);
		this.cuantiaTotal = cuantiaTotal;
	}

	@Override
	public void setDuracion(Integer duracion) {
		Checkers.check("Comprobador de duracion", duracion >= DURACION_MINIMA);
		this.duracion = duracion;
	}

	@Override
	public void setTipo(TipoBeca tipo) {
		this.tipo = tipo;
	}

	@Override
	public Double getCuantiaMensual() {
		return getCuantiaTotal()/getDuracion();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Beca))
			return false;
		Beca other = (Beca) obj;
		if (codigo == null) {
			if (other.getCodigo() != null)
				return false;
		} else if (!codigo.equals(other.getCodigo()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String strTipo = getTipo().toString().toLowerCase();
		return String.format("[%s, %s]", getCodigo(), strTipo);
	}

	public int compareTo(Beca b) {
		return this.getCodigo().compareTo(b.getCodigo());
	}
	
}
