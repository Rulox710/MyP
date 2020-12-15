package graficos.control;

import graficos.ventana.*;
import graficos.modelo.Logica;

public class GestorVentana {
	
	private Ventana[] ventanas;
	private Logica logica;
	
	public GestorVentana() {
		iniciarEstadosVentana();
	}
	
	private void iniciarEstadosVentana() {
		ventanas = new Ventana[3];
		ventanas[0] = new VentanaPrincipal(this);
		ventanas[1] = new VentanaJuego(this);
		ventanas[2] = new VentanaPausa(this);
		logica = new Logica(this); 
	}
	
	public void mostrarVentana(int i) {
		int contador = 0;
		for(Ventana v: ventanas){
			if(contador++ != i)v.setVisible(false);
		}
		ventanas[i].setVisible(true);
	}
	
	public void enviarCadena(String cadena) {
		logica.procesarCadena(cadena);
	}
}
