package juego.item.constructor;

import juego.item.Item;

/**
 * Clase abstracta para modelar el patron builder. Usa los ID de los objetos 
 * para combinarlos
 */
public interface Constructor {
	
	/**
	 * Metodo para asignar los objetos a combinar
	 * @param primero Un <code>Item</code>
	 * @param segundo Otro <codeItem</code>
	 */
	public abstract void asignarElementos(Item primero, Item segundo);
	
	/**
	 * Metodo para validar que sean objetos combinables
	 * @return Un boleano
	 */
	public abstract boolean sePuedeCombinar();
	
	/**
	 * Metodo para combinar los objetos
	 * @return Un <code>Item</code> 
	 */
	public abstract Item combinar();
}
