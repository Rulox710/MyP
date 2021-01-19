package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionEquipar extends AccionDefecto {
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionEquipar(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	/**
	 * Valida que la <code>cadena</code> sea "entendible" y realiza la 
	 * extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected boolean validarCadena() {
		if(cadena.length() < 1) return esParaJuego;
		esParaJuego = true;
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de equipar. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		if(!objetoExistente(cadena)) {
			return "No creo que esa herramienta exista";
		}
		int i = jugador.posicionEnInventario(cadena);
		if(i == -1) {
			return "No traigo eso conmigo";
		}
		if(jugador.equiparHerramienta(i)) {
			return "Ahora me he equipado " + cadena.toLowerCase();
		}
		return "No puedo equiparme eso; ni siquiera cre que sirva como herram" +
			"ienta";
	}
}

