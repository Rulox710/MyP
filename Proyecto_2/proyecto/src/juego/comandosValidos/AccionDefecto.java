package juego.comandosValidos;

import java.lang.UnsupportedOperationException;

import juego.ente.jugador.Jugador;

public abstract class AccionDefecto {
	
	protected String cadena;
	protected Jugador jugador;
	protected boolean esParaJuego;
	
	public AccionDefecto(String cadena, Jugador jugador) {
		this.cadena = cadena;
		this.jugador = jugador;
		esParaJuego = false;
	}
	
	public String realizarAccion() {
		if(validarCadena()) {
			return ejecutarAccion();
		}
		return "No se lo que hay que hacer";
	}
	
	public boolean obtenerEsParaJuego() {
		return esParaJuego;
	}
	
	protected abstract boolean validarCadena();
	
	protected abstract String ejecutarAccion();
}
