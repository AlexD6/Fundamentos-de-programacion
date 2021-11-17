package fp.barcos;

import fp.utiles.Checkers;

public class PasajeroBarco implements Comparable<PasajeroBarco> {
	
	private Integer id;
	private Boolean superviviente;
	private Integer clase;
	private String nombre;
	private Sexo sexo;
	private Integer edad;
	private Integer numHermanosOParejaABordo;
	private Integer numPadresOHijosABordo;
	private Double precioTicket;
	private String cabina;
	private String ciudadEmbarque;
	
	public PasajeroBarco(Integer id, Boolean superviviente, Integer clase, String nombre, Sexo sexo, Integer edad,
			Integer numHermanosOParejaABordo, Integer numPadresOHijosABordo, Double precioTicket, String cabina,
			String ciudadEmbarque) {
		Checkers.checkNoNull(id, superviviente, clase, edad,  edad, numHermanosOParejaABordo, numPadresOHijosABordo, precioTicket);
		Checkers.check("Las propiedades numéricas deben tener un valor mayor o igual que cero.", id >=0 && clase >=0 && edad >=0 && 
				numHermanosOParejaABordo >=0 && numPadresOHijosABordo >=0 && precioTicket >=0);
		this.id = id;
		this.superviviente = superviviente;
		this.clase = clase;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.numHermanosOParejaABordo = numHermanosOParejaABordo;
		this.numPadresOHijosABordo = numPadresOHijosABordo;
		this.precioTicket = precioTicket;
		this.cabina = cabina;
		this.ciudadEmbarque = ciudadEmbarque;
	}

	public Integer getId() {
		return id;
	}

	public Boolean getSuperviviente() {
		return superviviente;
	}

	public Integer getClase() {
		return clase;
	}

	public String getNombre() {
		return nombre;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Integer getEdad() {
		return edad;
	}

	public Integer getNumHermanosOParejaABordo() {
		return numHermanosOParejaABordo;
	}

	public Integer getNumPadresOHijosABordo() {
		return numPadresOHijosABordo;
	}

	public Double getPrecioTicket() {
		return precioTicket;
	}

	public String getCabina() {
		return cabina;
	}

	public String getCiudadEmbarque() {
		return ciudadEmbarque;
	}
	
	public Integer getNumeroFamiliares() {
		return numHermanosOParejaABordo + numPadresOHijosABordo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PasajeroBarco))
			return false;
		PasajeroBarco other = (PasajeroBarco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PasajeroBarco [id=" + id + ", superviviente=" + superviviente + ", clase=" + clase + ", nombre="
				+ nombre + ", sexo=" + sexo + ", edad=" + edad + ", numHermanosOParejaABordo="
				+ numHermanosOParejaABordo + ", numPadresOHijosABordo=" + numPadresOHijosABordo + ", precioTicket="
				+ precioTicket + ", cabina=" + cabina + ", ciudadEmbarque=" + ciudadEmbarque + "]";
	}

	@Override
	public int compareTo(PasajeroBarco p) {
		int res = id.compareTo(p.getId());
		return res;
	}
	
	

}
