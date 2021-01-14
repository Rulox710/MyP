package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

public class AccionPelear extends AccionDefecto {
	
	public AccionPelear(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	protected boolean validarCadena() {
		String[] str = cadena.split(" ");
		if(cadena.length() == 0) {
			esParaJuego = true;
		} else if(str.length >= 1) {
			String ultimo = str[str.length-1]; 
			String[] principio = cadena.split(" ".concat(ultimo));
			boolean m = (ultimo.equalsIgnoreCase("enemigo") || 
				ultimo.equalsIgnoreCase("monstruo"));
				System.out.println(principio[0] + "aqui");
			if(principio[0].equals(ultimo)) {
				esParaJuego = true;
			} else if((principio[0].equalsIgnoreCase("al") ||
				principio[0].equalsIgnoreCase("con El") || 
				principio[0].equalsIgnoreCase("a Ese") || 
				principio[0].equalsIgnoreCase("contra El") || 
				principio[0].equalsIgnoreCase("en Contra Del")) && m) {
				esParaJuego = true;
			}
		}
		return esParaJuego;
	}
	
	protected String ejecutarAccion() {
		return jugador.atacar(false);
	}
}
