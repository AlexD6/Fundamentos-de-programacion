package fp.tipos;

import java.time.Duration;
import java.time.LocalDate;

public class PeliculaImpl {
	private String titulo;
	private LocalDate fechaEstreno;
	private Duration duracion;
	
	public Duration getDuracion() {
		return duracion;
	}
	
	public TipoMetraje getTipoMetraje() {
		TipoMetraje res = null;
		Long minutos = getDuracion().toMinutes();
		if (minutos < 30) {
			res = TipoMetraje.CORTOMETRAJE;
		} else if (minutos >= 30 && minutos <= 60) {
			res = TipoMetraje.MEDIOMETRAJE;
		} else {
			res = TipoMetraje.LARGOMETRAJE;
		}
		return res;
	}
}
