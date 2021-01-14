package graficos.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import utilidad.Escritor;
import juego.comandosValidos.comandos.Comando;
 
import juego.comandosValidos.*;
import lectorRecursos.LectorRecursos;
import juego.casa.cuarto.mueble.Mueble;
import juego.casa.cuarto.mueble.item.Item;
import juego.ente.jugador.Jugador;

/**
 * Clase que tiene las acciones que se podrán realizar en las diferentes 
 * ventanas
 */
public class Logica {
	
	private boolean esParaJuego = false;
	
	/**
	 * Constructor de la clase
	 */
	public Logica() {}
	
	private int indiceComandoCadena(String cadena) {
		int i = 0;
		for(Comando comando: LectorRecursos.obtenerComandosValidos()){
			if(comando.igual(cadena)) {
				break;
			}
			i++;
		}
		return i;
	}
	
	public boolean obtenerEsParaJuego() {
		return esParaJuego;
	}
	
	public String acciones(String cadena, Jugador jugador) {
		esParaJuego = true;
		String[] str = cadena.split(" ",2);
		String t = "";
		if(str.length > 1) t = str[1];
		AccionDefecto ad = null;
		switch(indiceComandoCadena(str[0])) {
			case 0: ad = new AccionAyuda(t,null); break;
			case 3: ad = new AccionIr(t + " 1",jugador); break;
			case 4: ad = new AccionIr(t,jugador); break;
			case 5: ad = new AccionComer(t,jugador); break;
			case 6: ad = new AccionLeer(t,jugador); break;
			case 7: ad = new AccionObservar(t,jugador); break;
			case 8: ad = new AccionEquipar(t,jugador); break;
			case 9: ad = new AccionPelear(t,jugador); break;
			case 10: ad = new AccionAgarrar(t,jugador); break;
			case 11: ad = new AccionAbrir(t,jugador); break;
			case 12: ad = new AccionBuscar(t,jugador); break;
			default: ad = new AccionAyuda("a",null);
		}
		String resultado = ad.realizarAccion();
		esParaJuego = ad.obtenerEsParaJuego();
		return resultado;
	}
}
