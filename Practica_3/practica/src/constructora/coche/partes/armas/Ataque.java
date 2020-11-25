package constructora.coche.partes.armas;

import constructora.coche.partes.Componente;

/**
 * Clase que modela  las armas de un <code>Coche</code>
 */
public class Armas extends Componente {
	
	/**
	 * Constructor de la clase
	 * @param ataque Un entero que modela la defensa
	 * @param velocidad Un entero que modela la velocidad por hora
	 * @param costo Un entero que modela el costo
	 */
	protected Carroceria(int defensa, int velocidad, int costo) {
		this.ataque = ataque;
		this.defensa = 0;
		this.velocidad = velocidad;
		this.costo = costo;
	}
}
