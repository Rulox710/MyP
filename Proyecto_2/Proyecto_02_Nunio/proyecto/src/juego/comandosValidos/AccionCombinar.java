package juego.comandosValidos;

import juego.ente.jugador.Jugador;

/**
 * Clase que extiende <code>AccionDefecto</code>. Es parte del patron Template
 */
public class AccionCombinar extends AccionDefecto {
	
	private String primero = null;
	private String segundo = null;
	
	/**
	 * Constructor de la clase
	 * @param cadena Una cadena a analizar
	 * @param jugador El jugador sobre el cual se ejecutaran las acciones
	 */
	public AccionCombinar(String cadena, Jugador jugador) {
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
			if(con.length == 2){
				primero = con[0].trim();
				segundo = con[1].trim();
				esParaJuego = true;
			}
		}
		return esParaJuego;
	}
	
	/**
	 * Ejecuta los metodos correspondientes a la accion de combinar. Regresa una
	 * cadena la cual va a ser tratada como un error o 
	 * como parte del juego segun el valor de <code>esParaJuego</code>, 
	 * <code>false</code> si es error <code>true</code> en el otro caso, el cual 
	 * va a ser asignado en este mismo metodo
	 * @return Una cadena
	 */
	protected String ejecutarAccion() {
		if(!objetoExistente(primero) || !objetoExistente(segundo)){
			esParaJuego = false;
			return "Hay un objeto que no reconozco";
		}
		int i = jugador.posicionEnInventario(primero);
		if(i == -1) {
			return "Es posible que no tenga alguno de esos conmigo";
		}
		int j = jugador.posicionEnInventario(segundo);
		if(j == -1) {
			return "Es posible que no tenga alguno de esos conmigo";
		}
		boolean t = jugador.combinarItems(i,j);
		if(t) {
			return "Combine los objetos. Deberia tener el nuevo objeto en mi" +
				" inventario";
		}
		return "No puedo combinar eso";
	}
}

