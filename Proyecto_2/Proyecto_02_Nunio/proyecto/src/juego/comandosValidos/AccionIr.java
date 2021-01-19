package juego.comandosValidos;

import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionIr extends AccionDefecto {
	
	private boolean regresar = false;
	private String usar = null;
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionIr(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	/**
	 * Valida que la <code>cadena</code> sea "entendible" y realiza la 
	 * extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected boolean validarCadena() {
		String[] str = cadena.split(" ");
		String temp = "";
		if(str.length != 0 && str[str.length-1].equals("1")) {
			if(validarRegresar(str)) {
				esParaJuego = true;
			}
		} else if(str.length >= 2 && str.length <= 4) {
			if (validarNormal(str)) {
				esParaJuego = true;
			}
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de ir. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	private boolean validarRegresar(String[] str) {
		if(str.length == 2) {
			usar = "anterior";
			regresar = true;
		}
		if(str.length == 4) {
			String tem = "".concat(str[0]).concat(str[1]).concat(str[2]);
			if(tem.equalsIgnoreCase("alCuartoAnterior")) {
				usar = str[2].trim();
				regresar = true;
			}
		}
		return usar != null;
	}
	
	private boolean validarNormal(String[] str) {
		String temp = "";
		for(int i = 0; i < str.length-1; i++) {
			temp = temp.concat(str[i]);
			if(i < str.length-2) {
				temp = temp.concat(" ");
			}
		}
		if(temp.equalsIgnoreCase("al") || temp.equalsIgnoreCase("hacia el")) {
			usar = str[str.length-1].trim();
		} else if(temp.equalsIgnoreCase("al Cuarto") 
			|| temp.equalsIgnoreCase("hacia El Cuarto")) {
			usar = str[str.length-1];
			regresar = true;
		}
		return usar != null;
	}
	
	protected String ejecutarAccion() {
		String g = "";
		if(regresar) {
			if(usar.equalsIgnoreCase("anterior")) g = jugador.regresar();
			if(enemigo.obtenerUbicacionAnterior().equals(jugador.obtenerUbicacionActual())) {
				enemigo.atacar();
				g = g.concat("\nEsa cosa me ha atacado mientras trataba de ir hacia esa direccion");
				if(jugador.muerto()) g = g.concat("\n No creo poder...\nFIN DEL JUEGO");
			}
		} else {
			char d = ' ';
			if(usar.equalsIgnoreCase("norte")) {
				d = 'N';
			} else if(usar.equalsIgnoreCase("sur")) {
				d = 'S';
			} else if(usar.equalsIgnoreCase("este")) {
				d = 'E';
			} else if(usar.equalsIgnoreCase("oeste")) {
				d = 'O';
			} else {
				return "No creo que esa direccion exista";
			}
			g = jugador.cambiarCuarto(d);
			if(enemigo.obtenerUbicacionActual().equals(jugador.obtenerUbicacionAnterior())
			|| (enemigo.obtenerUbicacionActual().equals(jugador.obtenerUbicacionActual()) && 
			jugador.obtenerUbicacionActual().equals(jugador.obtenerUbicacionAnterior()))) {
				enemigo.atacar();
				g = g.concat("\nEsa cosa me ha atacado mientras trataba de ir hacia esa direccion");
				if(jugador.muerto()) g = g.concat("\n No creo poder...\nFIN DEL JUEGO");
			}
		}
		
		return g;
	}
}
