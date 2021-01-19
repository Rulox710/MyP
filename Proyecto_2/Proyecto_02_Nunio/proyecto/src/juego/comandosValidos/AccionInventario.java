package juego.comandosValidos;

import java.util.Iterator;

import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionInventario extends AccionDefecto {
	
	private char c = ' ';
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionInventario(String cadena, Jugador jugador) {
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
		} else {
			String[] str = cadena.split(" ",2);
			if(str.length == 2 && str[0].trim().equalsIgnoreCase("de")) {
				if(str[1].trim().equalsIgnoreCase("consumibles")) {
					c = 'C';
				} else if(str[1].trim().equalsIgnoreCase("herramientas")) {
					c = 'H';
				} else if(str[1].trim().equalsIgnoreCase("notas")) {
					c = 'N';
				} else if(str[1].trim().equalsIgnoreCase("llaves")) {
					c = 'L';
				}
				esParaJuego = true;
			}
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de inventario. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		String g = "Lo que traigo ";
		switch(c) {
			case 'L': g = g.concat("de llaves "); break;
			case 'N': g = g.concat("de notas "); break;
			case 'H': g = g.concat("de herramientas "); break;
			case 'C': g = g.concat("de consimubles "); break;
		}
		g = g.concat("es: ");
		Iterator it = jugador.obtenerInventario(c);
		if(!it.hasNext()) return "No tengo nada conmigo";
		while(it.hasNext()) {
			g = g.concat(it.next().toString().toLowerCase());
			if(it.hasNext()) g = g.concat(", ");
		}
		return g;
	}
}
