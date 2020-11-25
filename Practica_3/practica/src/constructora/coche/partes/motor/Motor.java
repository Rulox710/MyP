package constructora.coche.partes.motor;

import constructora.coche.partes.Componente;

/**
 * Clase que modela un motor de un <code>Coche</code>
 */
public abstract class Motor extends Componente {
	
	/**
	 * Constructor de la clase
	 * @param velocidad Un entero que modela la velocidad por hora
	 * @param costo Un entero que modela el costo
	 */
	protected Motor(int velocidad, int costo) {
		this.ataque = 0;
		this.defensa = 0;
		this.velocidad = velocidad;
		this.costo = costo;
	}
}
