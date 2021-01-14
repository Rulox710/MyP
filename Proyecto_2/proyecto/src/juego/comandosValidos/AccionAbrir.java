package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

public class AccionAbrir extends AccionDefecto {
	
	private String mueble = null;
	private String llave = null;
	
	public AccionAbrir(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		if(cadena.length() > 0) {
			String[] con = cadena.split("con",2);
			mueble = con[0];
			if(con.length > 1) {
				llave = con[1];
			}
			esParaJuego = true;
			if(con.length == 1 && con[0].length() > cadena.trim().length()) {
				esParaJuego = false;
			}
		}
		return esParaJuego;
	}
	
	protected String ejecutarAccion() {
		String resultado = "";
		if(llave != null) {
			resultado = jugador.abrirMueble(mueble,llave);
		} else {
			resultado = jugador.abrirMueble(mueble,"");
		}
		return resultado;
	}
}
