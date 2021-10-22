package cap6;

import java.io.IOException;
import java.util.Calendar;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		Mapa m = new GoogleMaps();
		m.devolveMapa("rua");
		
		RelogioDoSistema relogio = new RelogioDoSistema();
		Calendar dataAtual = relogio.hoje();

	}

}
