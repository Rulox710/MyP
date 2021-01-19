package mvc.modelo.cronometro;

import java.lang.IllegalThreadStateException;
import java.lang.Thread;

import mvc.modelo.Juego;

/**
 * Clase para modelar un cronometro el cual sera para que el enemigo en el juego
 * se mueva cada cierto tiempo
 */
public final class Cronometro extends Thread {
	
	/**
	 * Unico cronometro al iniciar el juego
	 */
	public static Cronometro instancia = new Cronometro(); 
	
	private boolean enFuncionamiento, hiloActivo;
	private Juego juego;
	
	private Cronometro() {}
	
	/**
	 * Metodo para agregar a quien va a hacer que el enemigo se mueva
	 */
	public void agregarJuego(Juego juego) {
		this.juego = juego;
	}
	
	/**
	 * Metodo para notificar que se debe mover al enemigo
	 */
	private void notificarJuego() {
		if(juego != null) juego.accionarEnemigo();
	}
	
	/**
	 * Metodo para iniciar o reanudar el cronometro
	 */
	public void iniciarCronometro() {
		enFuncionamiento = true;
		hiloActivo = true;
		try {
			instancia.start();
		} catch(IllegalThreadStateException e) { }
	}
	
	/**
	 * Metodo para pausar el cronometro
	 */
	public void pausarCronometro() {
		enFuncionamiento = false;
	}
	
	/**
	 * Metodo para terminar con el cronometro
	 */
	public void terminarCronometro() {
		hiloActivo = false;
	}
	
	/**
	 * Hilo del cronometro
	 */
	public void run(){
		int x = 0;
		try {
			while(hiloActivo) {
				System.out.print("");
				while(enFuncionamiento) {
					Thread.sleep(1000);
					x++;
					if(x >= 30) {
						notificarJuego();
						x = 0;
					}
				}
			}
		} catch(Exception e) {}
	}
}
