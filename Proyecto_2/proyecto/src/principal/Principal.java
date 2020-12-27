package principal;

import graficos.control.GestorVentana;
import utilidad.ed.*;

/**
 * Clase que inicia la ejecucion del proyecto
 */
public class Principal {
	/**
	 * Metodo principal
	 */
	public static void main(String[] args) {
		iniciar();
	}
	
	/**
	 * Metodo que llama a lo que se requiere para comenzar el proyecto
	 */
	private static void iniciar() {
		GestorVentana gv = new GestorVentana();
		gv.mostrarVentana(0);
	}
}
