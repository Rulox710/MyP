package juego.comandosValidos;

import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionPelear extends AccionDefecto {
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionPelear(String cadena, Jugador jugador) {
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
		if(cadena.length() == 0) {
			esParaJuego = true;
		} else if(str.length >= 1) {
			String ultimo = str[str.length-1]; 
			String[] principio = cadena.split(" ".concat(ultimo));
			boolean m = (ultimo.equalsIgnoreCase("enemigo") || 
				ultimo.equalsIgnoreCase("monstruo"));
			if(principio[0].equals(ultimo)) {
				esParaJuego = true;
			} else if((principio[0].equalsIgnoreCase("al") ||
				principio[0].equalsIgnoreCase("con El") || 
				principio[0].equalsIgnoreCase("a Ese") || 
				principio[0].equalsIgnoreCase("contra El") || 
				principio[0].equalsIgnoreCase("en Contra Del")) && m) {
				esParaJuego = true;
			}
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de pelear. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		if(jugador.hayOtroEnte()) {
			if(jugador.atacar()) {
				String g = "Le he atacado ";
				if(jugador.hayOtroEnteVivo()) {
					g = g.concat("y me ataca en respuesta... ");
					if(jugador.muerto()) {
						g = g.concat(" aunque este golpe fue demasiado...\nFI" +
							"N DEL JUEGO");
					} else {
						g = g.concat(" tengo que hacer algo antes de que me a" +
							"taque de nuevo");
					}
				} else {
					g = g.concat("y lo he derribado.");
					if(enemigo.obtenerMuerto()) {
						g = g.concat("\nLe he acabado con la espada... He ganado\nFIN DEL JUEGO");
					}
				}
				return g;
			} else {
				return "Esa cosa esta tirada en suelo, pero parece que aun se" +
					" mueve";	
			}
		}
		return "\u00BFPero a que debo atacar? Aqui no hay nadie";
	}
}
