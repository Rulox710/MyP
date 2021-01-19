package juego.comandosValidos;

import java.util.Iterator;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;
import juego.item.Item;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionObservar extends AccionDefecto {
	
	private boolean esMueble = false;
	private String usar = null;
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionObservar(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	/**
	 * Valida que la <code>cadena</code> sea "entendible" y realiza la 
	 * extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected boolean validarCadena() {
		boolean art = false;
		if(cadena.length() > 3 && cadena.charAt(0) == 'e' 
			&& cadena.charAt(1) == 'l' && cadena.charAt(2) == ' ') art = true;
		if(art) {
			usar = cadena.split(" ",2)[1];
		} else {
			usar = cadena;
		}
		if(usar.equals("") || usar.equalsIgnoreCase("cuarto")) {
			esParaJuego = true;
		} else if(jugador.validarMueble(usar)) {
			esMueble = true;
			esParaJuego = true;
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de Observar. Regresa una
	 *  cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		String resultado = "";
		if(esMueble) {
			Iterator<Item> it = jugador.verContenidoMueble();
			if(!it.hasNext()) return "El mueble esta vacio";
			Item objeto = it.next();
			if (objeto == null) return "El mueble esta cerrado";
			resultado = resultado.concat(objeto.toString());
			if(it.hasNext()) resultado = resultado.concat(", ");
			while(it.hasNext()) {
				resultado = resultado.concat(it.next().toString());
				if(it.hasNext()) resultado = resultado.concat(", ");
			}
		} else {
			resultado = jugador.describirCuarto();
		}
		return resultado;
	}
}
