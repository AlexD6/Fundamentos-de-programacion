package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class TrayectoTrenImpl implements Comparable<TrayectoTren>, TrayectoTren{
	
	private String codigoTren;
	private String nombreTrayecto;
	private TipoTren tipo;
	private List<String> estaciones;
	private List<LocalTime> horasSalida;
	private List<LocalTime> horasLlegada;
	
	public TrayectoTrenImpl(String codigoTren, String nombreTrayecto, TipoTren tipo, String origen, String destino, LocalTime horaSalida, 
			LocalTime horaLlegada) {
		Checkers.check("El código de un tren debe estar formado por 5 dígitos.", !esCodigoTrenOk(codigoTren));
		Checkers.checkNoNull(horaLlegada);
		Checkers.checkNoNull(horaSalida);
		Checkers.check("La hora de salida de la primera estación debe ser anterior a la hora de llegada a la última estación", horaSalida.isBefore(horaLlegada));
		
		this.codigoTren = codigoTren;
		this.nombreTrayecto = nombreTrayecto;
		this.tipo = tipo;
		this.estaciones = new ArrayList<String>();
		this.estaciones.add(origen);
		this.estaciones.add(destino);
		this.horasSalida = new ArrayList<LocalTime>();
		this.horasSalida.add(horaSalida);
		this.horasSalida.add(null); //Colocamos un null, ya que la hora de salida ultima no existe
		this.horasLlegada = new ArrayList<LocalTime>();
		this.horasLlegada.add(null); //Colocamos un null, ya que la hora de llegda primera no existe
		this.horasLlegada.add(horaLlegada);
	}

	private Boolean esCodigoTrenOk(String codigoTren) {
		Boolean res = codigoTren.length() == 5 && sonDigitos(codigoTren);
		return res;
	}

	private boolean sonDigitos(String codigoTren) {
		Boolean res = false;
		for (int i=0; i<codigoTren.length(); i++) {
			res = res && Character.isDigit(codigoTren.charAt(i));
		}
		return res;
	}

	@Override
	public String getCodigoTren() {
		return codigoTren;
	}

	@Override
	public String getNombreTrayecto() {
		return nombreTrayecto;
	}

	@Override
	public TipoTren getTipo() {
		return tipo;
	}

	@Override
	public List<String> getEstaciones() {
		return estaciones;
	}

	@Override
	public List<LocalTime> getHorasSalida() {
		return horasSalida;
	}

	@Override
	public List<LocalTime> getHorasLlegada() {
		return horasLlegada;
	}
	
	@Override
	public LocalTime getHoraSalida(String estacion) {
		LocalTime res = null;
		Integer posicion = estaciones.indexOf(estacion);
		if(posicion >= 0 && posicion != estaciones.size()-1) res = horasSalida.get(posicion); 
		return res;
	}
	
	@Override
	public LocalTime getHoraLlegada(String estacion) {
		Integer posicion = estaciones.indexOf(estacion);
		LocalTime res = horasLlegada.get(posicion);
		return res;
	}
	
	@Override
	public Duration getDuracion() {
		return Duration.between(getHorasSalida().get(0), getHorasLlegada().get(getHorasLlegada().size()-1));
	}
	
	@Override
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		estaciones.add(posicion, estacion);
		horasSalida.add(posicion, horaSalida);
		horasLlegada.add(posicion, horaLlegada);
		if(getHorasSalida().get(0).equals(horaSalida) || getHorasLlegada().get(getHorasLlegada().size()-1).equals(horaLlegada) || 
				horaLlegada.isBefore(horaSalida)) throw new IllegalArgumentException();
	}
	
	@Override
	public void eliminarEstacionIntermedia(String estacion) {
		estaciones.remove(estacion);
		horasSalida.remove(estaciones.indexOf(estacion));
		horasLlegada.remove(estaciones.indexOf(estacion));
		if(getEstaciones().get(0).equals(estacion) || getEstaciones().get(-1).equals(estacion)) throw new IllegalArgumentException();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTren == null) ? 0 : codigoTren.hashCode());
		result = prime * result + ((horasSalida == null) ? 0 : horasSalida.hashCode());
		result = prime * result + ((nombreTrayecto == null) ? 0 : nombreTrayecto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TrayectoTrenImpl))
			return false;
		TrayectoTrenImpl other = (TrayectoTrenImpl) obj;
		if (codigoTren == null) {
			if (other.codigoTren != null)
				return false;
		} else if (!codigoTren.equals(other.codigoTren))
			return false;
		if (horasSalida == null) {
			if (other.horasSalida != null)
				return false;
		} else if (!horasSalida.equals(other.horasSalida))
			return false;
		if (nombreTrayecto == null) {
			if (other.nombreTrayecto != null)
				return false;
		} else if (!nombreTrayecto.equals(other.nombreTrayecto))
			return false;
		return true;
	}

	@Override
	public int compareTo(TrayectoTren t) {
		Integer res = this.getNombreTrayecto().compareTo(t.getNombreTrayecto());
		if(res==0) this.getHoraSalida(getNombreTrayecto()).compareTo(t.getHoraSalida(getNombreTrayecto()));
		if(res==0) this.getCodigoTren().compareTo(t.getCodigoTren());
		return res;
	}

	@Override
	public String toString() {
//		return "getCodigoTren()=" + getCodigoTren() + ", getNombreTrayecto()=" + getNombreTrayecto()
//				+ ", getTipo()=" + getTipo() + ", getEstaciones()=" + getEstaciones() + ", getHorasSalida()="
//				+ getHorasSalida() + ", getHorasLlegada()=" + getHorasLlegada() + "]";
		String res = getNombreTrayecto() + "-" + getTipo() + " (" + getCodigoTren() + ") \n"; 
		for(int i=0; i<estaciones.size(); i++) {
			res += getEstaciones().get(i) + "      " + getHorasSalida().get(i) + "      " + getHorasLlegada().get(i) + "\n";
		}
		return res;
	}
	
	
	
}
