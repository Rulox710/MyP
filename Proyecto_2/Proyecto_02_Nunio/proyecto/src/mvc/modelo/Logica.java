package mvc.modelo;

import juego.comandosValidos.comandos.Comando;
 
import juego.comandosValidos.*;
import lectorRecursos.LectorRecursos;
import juego.mueble.Mueble;
import juego.item.Item;
import juego.ente.jugador.Jugador;
import juego.ente.enemigo.Enemigo;

/**
 * Clase para ejecutar las distintas acciones y obtener un resultado en forma de
 * cadena
 */
public class Logica {
	private boolean esParaJuego = false;
	private Jugador jugador;
	private Enemigo enemigo;
	
	/**
	 * Constructor de la clase
	 * @param jugador un <code>Jugador</code>
	 */
	public Logica(Jugador jugador, Enemigo enemigo) {
		this.jugador = jugador;
		this.enemigo = enemigo;
	}
	
	/**
	 * Metodo para obtener el indice para el comando similar a la cadena pasada
	 * @param cadena Una cadena
	 * @return Un numero entero. <code>-1</code> si no existe
	 */
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
	
	/**
	 * Metodo para saber si una cadena obtenida de 
	 * {@link acciones(String, Jugador) metodo} debe ser tratada como error o
	 * como parte del juego
	 */
	public boolean obtenerEsParaJuego() {
		return esParaJuego;
	}
	
	/**
	 * Metodo para obtener un resultado de la cadena dada
	 * @param cadena Una cadena a analizar
	 * @return Una cadena para escribir donde corresponda
	 */
	public String acciones(String cadena) {
		esParaJuego = true;
		String[] str = cadena.trim().split(" ",2);
		String t = "";
		if(str.length > 1) t = str[1].trim();
		AccionDefecto ad = null;
		switch(indiceComandoCadena(str[0].trim())) {
			case 0: ad = new AccionAyuda(t,null); break;
			case 1: ad = new AccionInventario(t,jugador); break;
			case 2: ad = new AccionVida(t,jugador); break;
			case 3: ad = new AccionIr(t + " 1",jugador);
			ad.asignarEnemigo(enemigo); break;
			case 4: ad = new AccionIr(t,jugador);
			ad.asignarEnemigo(enemigo); break;
			case 5: ad = new AccionComer(t,jugador); break;
			case 6: ad = new AccionLeer(t,jugador); break;
			case 7: ad = new AccionObservar(t,jugador); break;
			case 8: ad = new AccionEquipar(t,jugador); break;
			case 9: ad = new AccionPelear(t,jugador); 
			ad.asignarEnemigo(enemigo); break;
			case 10: ad = new AccionAgarrar(t,jugador); break;
			case 11: ad = new AccionAbrir(t,jugador); break;
			case 12: ad = new AccionBuscar(t,jugador); break;
			case 13: ad = new AccionCombinar(t,jugador); break;
			default: ad = new AccionAyuda("a",null);
		}
		String resultado = ad.realizarAccion();
		esParaJuego = ad.obtenerEsParaJuego();
		return resultado;
	}
}
