package graficos.modelo;

import utilidad.Escritor;
import utilidad.Impresor;
import graficos.control.GestorVentana;
import graficos.modelo.palabras.Verbo;
import graficos.modelo.palabras.Sustantivo;
import graficos.modelo.palabras.PalabraException;
import graficos.modelo.palabras.diccionario.DiccionarioVerbos;

/**
 * Clase que tiene las acciones que se podrán realizar en las diferentes 
 * ventanas
 */
public class Logica {
	
	private GestorVentana gv;
	private DiccionarioVerbos dv;
	
	public Logica(GestorVentana gv) {
		this.gv = gv;
		this.dv = new DiccionarioVerbos();
		dv.iniciar();
	}
	
	public boolean sePuedeProcesarCadena(String cadena) {
		if(!Escritor.validarAlfabetico(cadena)) return false;
		String[] str = cadena.split(" ");
		Impresor.imprimir("" + esUnVerbo(str[0]));
		return true;
	}
	
	private boolean esUnVerbo(String str) {
		Verbo verbo;
		try {
			verbo = Verbo.nuevo(str);
		} catch(PalabraException pe) {
			pe.getMessage();
			return false;
		}
		return (dv.obtenerDiccionarioVerbos().contiene(verbo))? true: false;
	}
	
}
