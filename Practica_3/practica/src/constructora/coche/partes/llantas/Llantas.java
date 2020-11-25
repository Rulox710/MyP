package constructora.coche.partes.llantas;

import constructora.coche.partes.Componente;

/**
 * Clase que modela las llantas de un <code>Coche</code>
 */
public abstract class Llantas extends Componente {
	
	/**
	 * Constructor de la clase
	 * @param defensa Un entero que modela la defensa
	 * @param velocidad Un entero que modela la velocidad por hora
	 * @param costo Un entero que modela el costo
	 */
	protected Llantas(int defensa, int velocidad, int costo) {
		this.ataque = 0;
		this.defensa = defensa;
		this.velocidad = velocidad;
		this.costo = costo;
	}
	
}
