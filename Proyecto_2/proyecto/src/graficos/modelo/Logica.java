package graficos.modelo;

import utilidad.Escritor;
import graficos.control.GestorVentana;

/**
 * Clase que tiene las acciones que se podrán realizar en las diferentes 
 * ventanas
 */
public class Logica {
	
	private GestorVentana gv;
	
	public Logica(GestorVentana gv) {
		this.gv = gv;
	}
	
	public void procesarCadena(String cadena) {
		String[] str = cadena.split(" ");
		boolean letras = Escritor.validarAlfabetico(cadena);
			if(letras) {
				
			}
	}
	
}
