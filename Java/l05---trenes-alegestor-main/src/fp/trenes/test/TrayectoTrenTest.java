package fp.trenes.test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fp.trenes.TipoTren;
import fp.trenes.TrayectoTrenImpl;

public class TrayectoTrenTest {

	public static void main(String[] args) {
		List<String> estaciones = new ArrayList<String>();
		estaciones.add("Sevilla");
		estaciones.add("Madrid");
		estaciones.add(1, "Puertollano");
		estaciones.add(1, "Cordoba");
		TrayectoTrenImpl sevillaMadrid = new TrayectoTrenImpl("02471", "SEVILLA-MADRID", TipoTren.AV_CITY, estaciones.get(0), estaciones.get(3), 
				LocalTime.of(07, 00), LocalTime.of(10, 02));
		System.out.println(sevillaMadrid);
	}

}
