package juego.comandosValidos;

import java.lang.UnsupportedOperationException;

import juego.ente.jugador.Jugador;
import juego.ente.enemigo.Enemigo;
import lectorRecursos.LectorRecursos;
import juego.item.Item;
import juego.mueble.Mueble;

/**
 * Clase abstracta para modelar distintos hooks para Template
 */
public abstract class AccionDefecto {
	
	protected String cadena;
	protected Jugador jugador;
	protected Enemigo enemigo;
	protected boolean esParaJuego;
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionDefecto(String cadena, Jugador jugador) {
		this.cadena = cadena.trim();
		this.jugador = jugador;
		esParaJuego = false;
	}
	
	/**
	 * Metodo para asignar un enemigo para auxiliar al relizar las acciones
	 * @param enemigo Un <code>enemigo</code> para auxiliar a las acciiones que 
	 * lo necesiten
 	 */
	public void asignarEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}
	
	/**
	 * Metodo para template que todas las clase que extiendan esta van a 
	 * realizar. Primero valida que la cadena sea entendible para el comando 
	 * correspondiente, si lo es entonces ejecuta la accion, si no devulve un 
	 * error para la consola
	 * @return Una cadena, la cual es obtenida de ejecutar la accion o como un 
	 * error para la consola
	 */
	public String realizarAccion() {
		if(validarCadena()) {
			return ejecutarAccion();
		}
		return "No se lo que hay que hacer";
	}
	
	/**
	 * Metodo para saber si la cadena obtenida de 
	 * {@link realizarAccion(String) metodo} debe ser tratada como error o como 
	 * parte del juego
	 * @return <code>true</code> si es para el juego, <code>false</code> si no
	 */
	public boolean obtenerEsParaJuego() {
		return esParaJuego;
	}
	
	/**
	 * Metodo para validar que una cadena represente a un objeto que exite 
	 * realmente en el juego. No es estricto, así que <code>cadena</code> puede 
	 * o no ser el nombre exacto de un objeto
	 * @param cadena Una Cadena
	 * @return Si hay algun objeto que pueda ser reconocido con la cadena pasada 
	 */
	protected boolean objetoExistente(String cadena) {
		for(Item it: LectorRecursos.obtenerItems()) {
			if(it.validarItemCadena(cadena)) return true;
		}
		return false;
	}
	
	/**
	 * Metodo para validar que una cadena represente a un mueble que exite 
	 * realmente en el juego. No es estricto, así que <code>cadena</code> puede 
	 * o no ser el nombre exacto de un mueble
	 * @param cadena Una Cadena
	 * @return Si hay algun mueble que pueda ser reconocido con la cadena pasada 
	 */
	protected boolean muebleExistente(String cadena) {
		for(Mueble mu: LectorRecursos.obtenerMuebles()) {
			if(mu.validarMuebleCadena(cadena)) return true;
		}
		return false;
	}
	
	/**
	 * Metodo a extender. Valida que la <code>cadena</code> sea "entendible"
	 * y realiza la extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected abstract boolean validarCadena();
	
	/**
	 * Metodo a extender. Ejecuta los metodos correspondientes a la accion a 
	 * realizar. Regresa una cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected abstract String ejecutarAccion();
}
