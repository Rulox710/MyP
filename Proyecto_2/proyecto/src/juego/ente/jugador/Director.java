package juego.ente.jugador;

import juego.item.*;
import juego.item.constructor.*;

/**
 * Clase que escoge el constructor adecuado para combinar objetos
 */
public class Director {
	private Constructor constructor;
	private Item[] arreglo = new Item[2];
	
	/**
	 * Obtiene y registra los objetos a combinar, aunque los constructores usan 
	 * el id del objeto no el objeto mismo
	 * @param item1 El primer objeto a combinar
	 * @param item2 El segundo objeto a combinar
	 */
	public void elementosCombinar(Item item1, Item item2) {
		arreglo = new Item[2];
		arreglo[0] = item1;
		arreglo[1] = item2;
		if(item1 instanceof Llave) {
			constructor = new ConstructorLlaves();
		} else {
			constructor = new ConstructorConsumibles();
		}
		constructor.asignarElementos(item1,item2);
	}
	
	/**
	 * Metodo que obtiene un arreglo con los objetos obtenidos de la combinacion
	 * @param Un arreglo de <code>Item</code>. Este arreglo tiene el nuevo 
	 * objeto y es de longitud uno si se combinaron los dos objetos. Tiene los 
	 * dos objetos iniciales y es de longitud dos si no se pudieron combinar
	 */
	public Item[] combinar() {
		if(constructor.sePuedeCombinar()) {
			arreglo = new Item[1];
			arreglo[0] = constructor.combinar();
		} 
		return arreglo;
	}
}
