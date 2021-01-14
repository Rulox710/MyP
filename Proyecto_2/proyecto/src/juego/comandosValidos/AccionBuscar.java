package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

public class AccionBuscar extends AccionDefecto {
	
	public AccionBuscar(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		if(cadena.equalsIgnoreCase("Salidas")) {
			esParaJuego = true;
		}
		return esParaJuego;
	}
	
	protected String ejecutarAccion() {
		return jugador.buscarSalidas();
	}
}
