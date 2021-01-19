package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionComer extends AccionDefecto {
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionComer(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	/**
	 * Valida que la <code>cadena</code> sea "entendible" y realiza la 
	 * extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected boolean validarCadena() {
		if(cadena.length() == 0) return esParaJuego;	
		esParaJuego = true;
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de comer. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		if(!objetoExistente(cadena)) return "No creo que ese objeto exista";
		int i = jugador.posicionEnInventario(cadena);
		int curacion = jugador.curar(i);
		String g = "Acabo de comer eso y ";
		if(curacion == 3) {
			g = g.concat("me siento de maravilla");
		} else if(curacion > 0) {
			g = g.concat("me siento mejor");
		} else if(curacion == 0) {
			g = g.concat("sigo igual");
		} else if(curacion == -1){
			g = g.concat("me siento pesimo");
		} else {
			return "Me parece que no se come eso";
		}
		if(jugador.muerto()) {
			g = g.concat(". De hecho me siento tan mal que creo que...\nFIN D" +
				"EL JUEGO");
		}
		return g;
	}
}
