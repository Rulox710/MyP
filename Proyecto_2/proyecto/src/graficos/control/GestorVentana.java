package graficos.control;

import graficos.ventana.*;
import graficos.modelo.Logica;
import principal.Juego;

/**
 * Clase que coordeina las ventanas y la logica del proyecto
 */
public class GestorVentana {
	
	private Ventana[] ventanas;
	private Juego juego;
	
	/**
	 * Constructor de la clase
	 */
	public GestorVentana() {
		iniciarVentanas();
	}
	
	/**
	 * Inicia las trs ventanas y la logica del proyecto
	 */
	private void iniciarVentanas() {
		ventanas = new Ventana[3];
		ventanas[0] = new VentanaPrincipal(this);
		ventanas[1] = new VentanaJuego(this);
		ventanas[2] = new VentanaPausa(this);
		juego = new Juego(this);
	}
	
	/**
	 * Cambia la ventana dependiendo del entero ingresado.
	 * @param i 0 para <code>VentanaPrincipal</code>, 1 para 
	 * <code>VentanaJuego</code>, 2 para <code>VentanaPausa</code>,  cualquier 
	 * otro numero no termina la ejecucuion pero oculta todas las ventanas
	 */
	public void mostrarVentana(int i) {
		int contador = 0;
		for(Ventana v: ventanas){
			if(contador++ != i)v.setVisible(false);
		}
		ventanas[i].setVisible(true);
	}
	
	public void enviarCadenaJuego(String cadena) {
		
		((VentanaJuego)ventanas[1]).escribirEnJuego(cadena);
	}
	
	public void enviarCadenaConsola(String cadena) {
		((VentanaJuego)ventanas[1]).escribirEnConsola(cadena);
	}
	
	/**
	 * Metodo para enviar una cadena de una <code>VentanaJuego</code> a 
	 * <code>Logica</code> y devuelve un boleno dependiendo del resultado que da
	 * esta ultima clase
	 * @param String Una cadena
	 * @return Un boleano
	 */
	public boolean procesarCadena(String cadena) {
		return juego.recibirCadena(cadena);
	}
}
