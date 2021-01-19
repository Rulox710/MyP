package juego.comandosValidos;

import lectorRecursos.LectorRecursos;
import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionAgarrar extends AccionDefecto {
	
	private String usar = null;
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionAgarrar(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	/**
	 * Valida que la <code>cadena</code> sea "entendible" y realiza la 
	 * extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected boolean validarCadena() {
		String[] str = cadena.split(" ",1);
		if(str.length == 2) {
			boolean articulo = (str[0].equalsIgnoreCase("el")
				|| str[0].equalsIgnoreCase("un") || str[0].equalsIgnoreCase("una")
				|| str[0].equalsIgnoreCase("la"));
			if(articulo) {
				usar = str[1].trim();
			} else {
				usar = cadena.trim();
			}
			esParaJuego = true;
		} else if(str.length == 1) {
			esParaJuego = true;
			usar = cadena.trim();
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de agarrar. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		if(!objetoExistente(usar)) return "No creo que encuentre un objeto co" +
			"mo ese";
		if(!jugador.tomarObjeto(usar)) {
			if(!jugador.muebleAbierto()) {
				return "No he abierto el mueble aun";
			} else if(!jugador.muebleCon(usar)) {
				return "Ese objeto no esta aqui";
			} else {
				return "No puedo cargar mas de esos. Voy a devolver el objeto" +
					"al mueble";
			}
		}
		return "He tomado " + usar.toLowerCase() + ". Ya esta guardado y en e" +
			"l inventario";
	}
}
