package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

public class AccionEquipar extends AccionDefecto {
	
	public AccionEquipar(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		return false;
	}
	
	protected String ejecutarAccion() {
		return "";
	}
}

