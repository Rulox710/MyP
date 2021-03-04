package mvc.modelo;

import juego.ente.jugador.Jugador;
import juego.ente.enemigo.Enemigo;
import mvc.controlador.GestorVentana;
import mvc.modelo.Logica;
import lectorRecursos.LectorRecursos;
import mvc.modelo.cronometro.Cronometro;

/**
 * Clase para hacer que el proyecto funcione
 */
public class Juego {
	
	private Jugador jugador;
	private Enemigo enemigo;
	private GestorVentana gv;
	private Logica lg;
	private LogicaEnemigo lge;
	
	public Juego(GestorVentana gv) {
		this.gv = gv;
		Cronometro.instancia.agregarJuego(this);
		prepararJuego();
	}
	
	private void prepararJuego() {
		LectorRecursos.reiniciar();
		LectorRecursos.iniciar();
		jugador = new Jugador(LectorRecursos.obtenerCasa().get(3));
		enemigo = new Enemigo(LectorRecursos.obtenerCasa().get(1));
		lg = new Logica(jugador,enemigo);
		lge = new LogicaEnemigo(jugador,enemigo);
	}
	
	/**
	 * Metodo que recibe una cadena para que el jugador realice alguna accion
	 * @param cadena Una cadena
	 */
	public void recibirCadena(String cadena) {
		if(!jugador.muerto()) {
			acciones(cadena);
		} else {
			enviarCadenaJuego("FIN DEL JUEGO");
		}
	}
	
	public void accionarEnemigo() {
		String str = lge.acciones();
		if(str.length() > 0) {
			enviarCadenaJuego(str);
		}
	}
	
	/**
	 * Metodo para enviar una cadena a la consola (sera tratada como error) 
	 * auxiliandose de <code>GestorVentana</code>
	 * @param cadena una cadena 
	 */
	private void enviarCadenaConsola(String cadena) {
		gv.enviarCadenaConsola(cadena);
	}
	
	/**
	 * Metodo para enviar una cadena al juego (sera tratada como parte del 
	 * juego) auxiliandose de <code>GestorVentana</code>
	 * @param cadena una cadena 
	 */
	private void enviarCadenaJuego(String cadena) {
		gv.enviarCadenaJuego(cadena);
	}
	
	/**
	 * Metodo para ejecutar las distintas acciones deacuarto a una cadena
	 * @param cadena La cadena a analizar
	 */
	private void acciones(String cadena) {
		String resultado = lg.acciones(cadena);
		if(lg.obtenerEsParaJuego()) {
			enviarCadenaJuego(resultado);
		} else {
			enviarCadenaConsola(resultado);
		}
	}
}
