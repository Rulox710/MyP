package juego.comandosValidos;

import java.util.Iterator;

import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionBuscar extends AccionDefecto {
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionBuscar(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	/**
	 * Valida que la <code>cadena</code> sea "entendible" y realiza la 
	 * extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected boolean validarCadena() {
		if(cadena.equalsIgnoreCase("Salidas")) {
			esParaJuego = true;
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de buscar. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		Iterator<String> it = jugador.buscarSalidas();
		String g = "Parece que hay salidas hacia el ";
		while(it.hasNext()) {
			g = g.concat(it.next());
			if(it.hasNext()) g = g.concat(", ");
		}
		return g;
	}
}
