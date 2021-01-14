package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

public class AccionLeer extends AccionDefecto {
	
	public AccionLeer(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		if(cadena.length() > 0) esParaJuego = true;
		return esParaJuego;
	}
	
	protected String ejecutarAccion() {
		return jugador.leerNota(cadena);
	}
}
