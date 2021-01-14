package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

public class AccionObservar extends AccionDefecto {
	
	private boolean esMueble = false;
	private String usar = null;
	
	public AccionObservar(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		boolean art = false;
		if(cadena.length() > 3 && cadena.charAt(0) == 'e' 
			&& cadena.charAt(1) == 'l' && cadena.charAt(2) == ' ') art = true;
		if(art) {
			usar = cadena.split(" ",2)[1];
		} else {
			usar = cadena;
		}
		if(usar.equals("") || usar.equalsIgnoreCase("cuarto")) {
			esParaJuego = true;
		} else if(jugador.validarMueble(usar)) {
			esMueble = true;
			esParaJuego = true;
		}
		return esParaJuego;
	}
	
	protected String ejecutarAccion() {
		String resultado = "";
		if(esMueble) {
			resultado = jugador.verContenidoMueble();
		} else {
			resultado = jugador.describirCuarto();
		}
		return resultado;
	}
}
