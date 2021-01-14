package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

public class AccionAyuda extends AccionDefecto {
	
	public AccionAyuda(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		if (cadena.length() == 0) {
			esParaJuego = true;
		}
		return esParaJuego;
	}
	
	protected String ejecutarAccion() {
		String resultado = "Algunos de los comandos que puede usar son: ";
		Iterator it = LectorRecursos.obtenerComandosValidos().iterator();
		while(it.hasNext()) {
			resultado += it.next();
			if(it.hasNext()) resultado += ", ";
		}
		return resultado;
	}
}
