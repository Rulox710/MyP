package juego.ente.enemigo;

import java.util.ArrayList;
import java.util.Random;

import juego.ente.Ente;
import juego.cuarto.Cuarto;

/**
 * Clase que extiende de <code>Ente</code> y modela a un enemigo
 */
public class Enemigo extends Ente{
	
	private boolean muerto = false;
	private Random r = new Random();
	
	/**
	 * Constructor de la clase
	 * @param cuarto La ubicacion inicial del enemigo
	 */
	public Enemigo(Cuarto cuarto) {
		super(cuarto);
		vida = 2;
		ataque = 3;
	}
	
	/**
	 * Metodo que hace que este ente reciba danio y reduce sus puntos de vida 
	 * actual. Solo llega hasta <code>0</code> si hay un exedente, admeas si el 
	 * danio es igual a la vida maxima lo registra como muerto y ya no podra 
	 * revivirse {@link revivir() metodo}
	 * @param d Puntos de vida actual a reducir
	 */
	public void recibirDanio(int d) {
		super.recibirDanio(d);
		if(d == vidaM) muerto = true;
	}
	
	/**
	 * Metodo para atacar a un ente ajeno a este en la misma ubicacion
	 * @return <code>true</code> si se ha atacado al ente, <code>false</code>
	 * si no se ataca porque no hay a quien
	 */
	public boolean atacar() {
		int danio = ataque;
		if(hayOtroEnteVivo()) {
			ubicacion.obtenerEnteAjeno(this).recibirDanio(ataque);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para revivir a este ente con toda la vida
	 * @param <code>true</code> si se puedo revivir, <code>false</code> si no ya
	 * que aun no ha muerto
	 */
	public boolean revivir() {
		if(muerto() && !obtenerMuerto()) {
			vida = vidaM;
			return true;
		}
		return false;
	}
	
	public String cambiarCuarto(char caracter) {
		char c = caracter;
		if(caracter == ' ') {
			ArrayList<Character> car = ubicacion.llaveSalidasValidas();
			boolean continuar = true;
			do {
				char d = car.get(r.nextInt(car.size()));
				if(c != d || car.size() == 1) {
					c = d;
					continuar = false;
				}
			} while(continuar);
		}
		Cuarto cuarto = ubicacion.cambiarCuarto(c);
		ubicacionAnterior = obtenerUbicacionActual();
		switch(c) {
			case 'N': ubicacionAnteriorCar = 'S'; break;
			case 'S': ubicacionAnteriorCar = 'N'; break;
			case 'E': ubicacionAnteriorCar = 'N'; break;
			case 'O': ubicacionAnteriorCar = 'E'; break;
		}
		ubicacion.retirarEnte(this);
		ubicacion = cuarto;
		ubicacion.agregarEnte(this);
		return "";
	}
	
	/**
	 * Metodo para obtener si este ente ya no puede revivirse
	 * @return Un boleano
	 */
	public boolean obtenerMuerto() {
		return muerto;
	}
}
