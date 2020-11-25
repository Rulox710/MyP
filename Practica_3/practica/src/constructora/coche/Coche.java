package constructora.coche;

import constructora.coche.partes.llantas.Llantas;
import constructora.coche.partes.motor.Motor;
import constructora.coche.partes.carroceria.Carroceria;
import constructora.coche.partes.blindaje.Blindaje;
import constructora.coche.partes.armas.Armas;

/**
 * Clase que modela un coche tipo Mad Max
 */
public class Coche {
	private Llantas llantas;
	private Motor motor;
	private Carroceria carroceria;
	private Blindaje blindaje;
	private Armas armas;
	
	/**
	 * Constructor de la clase.
	 * @param llantas El tipo de <code>Llantas</code> que tendra
	 * @param motor El tipo de <code>Motor</code> que tendra
	 * @param carroceria El tipo de <code>Carroceria</code> que tendra
	 * @param blindaje El tipo de <code>Blindaje</code> que tendra
	 * @param armas El tipo de <code>Armas</code> que tendra
	 */
	public Coche(Llantas llantas, Motor motor, Carroceria carroceria, Blindaje
		blindaje, Armas armas) {
		this.llantas = llantas;
		this.motor = motor;
		this.carroceria = carroceria;
		this.blindaje = blindaje;
		this.armas = armas;
	}
	
	/**
	 * Metodo que regresa el valor de los puntos de ataque del <code>Coche</code>
	 * @return Un numero entero
	 */
	public int obtenerAtaque() {
		return armas.obtenerAtaque();
	}
	
	/**
	 * Metodo que regresa el valor de la defensa del <code>Coche</code>
	 * @return Un numero entero
	 */
	public int obtenerDefensa() {
		return llantas.obtenerDefensa() + carroceria.obtenerDefensa() + 
			blindaje.obtenerDefensa();
	}
	
	/**
	 * Metodo que regresa el valor de la velocidad del <code>Coche</code>
	 * @return Un numero entero
	 */
	 public int obtenerVelocidad() {
		 return 200 + llantas.obtenerVelocidad() + motor.obtenerVelocidad() + 
			carroceria.obtenerVelocidad() + blindaje.obtenerVelocidad();
	 }
	 
	 /**
	 * Metodo que regresa el valor del costo del <code>Coche</code>
	 * @return Un numero entero
	 */
	 public int obtenerCosto() {
		 return llantas.obtenerCosto() + motor.obtenerCosto() + 
			carroceria.obtenerCosto() + blindaje.obtenerCosto() + 
			armas.obtenerCosto();
	 }
	 
	 /**
	  * Metodo que representa al <code>Coche</code> como una cadena
	  * @return Una cadena
	  */
	 public String toString() {
		 return "Coche con " + llantas.toString() + ", " + motor.toString() +
			", " + carroceria.toString() + ", " + blindaje.toString() + " y a" +
			"rmado con " + armas.toString() + ". Su costo es de " + 
			obtenerCosto() + " pesos\nSus estadisticas son las siguientes\t A" +
			"taque:" + obtenerAtaque() + "\tDefensa:" + obtenerDefensa() + "\tV"
			+ "elocidad:" + obtenerVelocidad() ;
	 }
}
