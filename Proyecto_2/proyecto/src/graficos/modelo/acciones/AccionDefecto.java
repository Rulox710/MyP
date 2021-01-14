package ;

import juego.ente.jugador.Jugador;

public abstract class AccionDefecto {
	
	protected String cadena;
	protected Jugador jugador;
	
	public AccionDefecto(String cadena, Jugador jugador) {
		this.cadena = cadena;
		jthis.jugador = jugador;
	}
	
	public abstract String[] ejecutarAccion();
	
	protected abstract boolean encontrarAuxiliar();
	
	protected abstract String[] separarPartes();
	
	protected abstract boolean palabrasExtra();
}
