package juego.comandosValidos;

import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionAbrir extends AccionDefecto {
	
	private String mueble = null;
	private String llave = null;
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionAbrir(String cadena, Jugador jugador) {
		super(cadena, jugador);
	}
	
	/**
	 * Valida que la <code>cadena</code> sea "entendible" y realiza la 
	 * extraccion de partes importantes de la misma de ser 
	 * necesario
	 * @return <code>true</code> si es "entendible"
	 */
	protected boolean validarCadena() {
		if(cadena.length() > 0) {
			String[] con = cadena.split("con",2);
			mueble = con[0].trim();
			if(con.length > 1) {
				llave = con[1].trim();
			}
			esParaJuego = true;
			if(con.length == 1 && con[0].length() > cadena.trim().length()) {
				esParaJuego = false;
			}
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de abrir. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		String resultado = "";
		if(!jugador.validarMueble(mueble)) return "No encuetro ningun mueble" +
			" como ese";
		if(jugador.muebleAbierto()) return "Ya habia abierto ese mueble con a" +
			"nterioridad";
		if(llave != null && !objetoExistente(llave)) {
			return "No creo que hay un objeto como ese";
		}
		int i = -2;
		if(llave != null) i = jugador.posicionEnInventario(llave);
		if(i == -1) return "No tengo eso";
		if(jugador.abrirMueble(i)) {
			return "Abri el mueble";
		} else if (i == -2) {
			return "Necesitare de una llave para abrir el mueble";
		} 
		return "No parece ser la llave indicada para abrir el mueble, aunque " +
			"tambien puede ser que no nececite una";
	}
}
