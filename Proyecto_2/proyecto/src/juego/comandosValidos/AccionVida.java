package juego.comandosValidos;

import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionVida extends AccionDefecto {
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionVida(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	/**
	 * Valida que la <code>cadena</code> sea "entendible" y realiza la 
	 * extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected boolean validarCadena() {
		if(cadena.length() == 0 || cadena.equalsIgnoreCase("actual")) {
			esParaJuego = true;
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de vida. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		switch(jugador.obtenerVida()) {
			case 1: return "Con un golpe mas... siento que...";
			case 2: return "Me cuesta continuar";
			case 3: return "Me he sentido mejor";
			case 4: return "Solo tengo unos rasgunos";
			default: return "No podria sentirme mejor";
		}
	}
}
