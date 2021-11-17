package fp.comic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Personajes {

	private List<Personaje> personajes;

	public Personajes() {
		this.personajes = new ArrayList<>();
	}
	
	public Personajes(Stream<Personaje> personajes) {
		this.personajes = personajes.collect(Collectors.toList());
	}
	
	public void añadirPersonaje(Personaje p) {
		this.personajes.add(p);
	}

	@Override
	public String toString() {
		return "Personajes [personajes=" + personajes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personajes == null) ? 0 : personajes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Personajes))
			return false;
		Personajes other = (Personajes) obj;
		if (personajes == null) {
			if (other.personajes != null)
				return false;
		} else if (!personajes.equals(other.personajes))
			return false;
		return true;
	}
	
	public List<Personaje> obtenerPersonajesDeSexoOrdenados(String sexo){
		return this.personajes.stream().filter(p -> p.getSexo().equals(sexo)).sorted().collect(Collectors.toList());
	}
	
	public List<Personaje> obtenerPersonajesOrdenadosPorPelo(){
		return this.personajes.stream().sorted(Comparator.comparing(Personaje::getPelo)).collect(Collectors.toList());
	}
	
	public Boolean hayPersonajePeloOjos(String pelo, String ojos){
		return this.personajes.stream().anyMatch(p -> p.getPelo().equals(pelo) && p.getOjos().equals(ojos));
	}
	
	public Set<String> obtenerValoresAtributo(Function<Personaje, String> metodoGetter ) {
		return this.personajes.stream().map(metodoGetter).collect(Collectors.toSet());
	}
	
	public Map<String, Integer> calcularAñoPrimerPersonajePorPelo() {
//		Maps -> Collectors.groupingBy(Como obtengo la clave, como obtengo los valores)
		Map<String, List<Personaje>> personajesPorPelo = this.personajes.stream().collect(Collectors.groupingBy(Personaje::getPelo, 
				Collectors.toList()));
		return personajesPorPelo.entrySet().stream().collect(Collectors.toMap(entrada -> entrada.getKey(), 
				entrada -> Collections.min(entrada.getValue(), Comparator.comparing(Personaje::getAnyoAparicion)).getAnyoAparicion()));
	}
	
}
