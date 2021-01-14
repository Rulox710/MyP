package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

public class AccionAgarrar extends AccionDefecto {
	
	private String usar = null;
	
	public AccionAgarrar(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		String[] str = cadena.split(" ",1);
		if(str.length == 2) {
			boolean articulo = (str[0].equalsIgnoreCase("el")
				|| str[0].equalsIgnoreCase("un") || str[0].equalsIgnoreCase("una")
				|| str[0].equalsIgnoreCase("la"));
			if(articulo) {
				usar = str[1];
			} else {
				usar = cadena;
			}
			esParaJuego = true;
		} else if(str.length == 1) {
			esParaJuego = true;
			usar = cadena;
		}
		return esParaJuego;
	}
	
	protected String ejecutarAccion() {
		return jugador.tomarObjeto(usar);
	}
}
