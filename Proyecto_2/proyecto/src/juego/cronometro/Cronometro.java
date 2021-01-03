package juego.cronometro;

import java.lang.IllegalThreadStateException;

import java.lang.Thread;

import principal.Juego;

public final class Cronometro extends Thread{
	
	private static Cronometro instancia; 
	private boolean enFuncionamiento, hiloActivo = false;
	private Juego juego;
	
	private Cronometro() {}
	
	public static Cronometro obtenerInstancia() {
		if(instancia == null) {
			instancia = new Cronometro();
		} 
		return instancia;
	}
	
	public void agregarJuego(Juego juego) {
		this.juego = juego;
	}
	
	private void notificarJuego() {
		if(juego != null) juego.accionarEnemigo();
	}
	
	public void iniciarCronometro() {
		enFuncionamiento = true;
		hiloActivo = true;
		try {
			instancia.start();
		} catch(IllegalThreadStateException e) { }
	}
	
	public void pausarCronometro() {
		enFuncionamiento = false;
	}
	
	public void terminarCronometro() {
		hiloActivo = false;
	}
	
	public void run(){
		int x = 0;
		try {
			while(hiloActivo) {
				System.out.print("");
				while(enFuncionamiento) {
					Thread.sleep(1000);
					x++;
					if(x == 30) {
						notificarJuego();
						x = 0;
					}
				}
			}
		} catch(Exception e) {}
	}
}
